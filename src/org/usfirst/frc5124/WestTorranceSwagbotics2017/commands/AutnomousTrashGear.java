package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutnomousTrashGear extends CommandGroup {

    public AutnomousTrashGear() {
    	addSequential(new AutoDriveStraightTrash(0.65, 2.25));
    	addSequential(new Wait(1));
    	addSequential(new GearHolderOpenAndLower());
    	addSequential(new Wait(0.4));
    	addSequential(new AutoTrashDrive(-0.5, 1.7));
    }
}
