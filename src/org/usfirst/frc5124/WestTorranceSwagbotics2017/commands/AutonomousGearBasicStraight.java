package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGearBasicStraight extends CommandGroup {

    public AutonomousGearBasicStraight() {
    	//addSequential(new AutoDriveByPID(85));
    	addSequential(new AutoDriveByEncoder(50, 0.6));
    	//go to lift
    	addSequential(new AutoKamikazeGear());
    	addSequential(new GearHolderSafelyOpen());
    	addSequential(new GearHolderWaitForPress());
    	addSequential(new Wait(0.8));
    	addSequential(new AutoTrashDrive(-0.55, 2, 1));
    }
}
