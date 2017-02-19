package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearHolderAutoRelase extends CommandGroup {

    public GearHolderAutoRelase() {
    	//addSequential(new DrivetrainStopForGear());
    	//addParallel(new DrivetrainIdle());
        addSequential(new GearHolderSafelyOpen());
        addSequential(new Wait(1));
        addSequential(new GearHolderWaitForClearing());
        addSequential(new Wait(1));
        addSequential(new GearHolderSafelyClose());
    }
}
