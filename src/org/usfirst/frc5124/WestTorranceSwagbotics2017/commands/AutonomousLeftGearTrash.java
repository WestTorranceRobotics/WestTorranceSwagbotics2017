package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousLeftGearTrash extends CommandGroup {

    public AutonomousLeftGearTrash() {
    	addSequential(new AutoDriveStraightTrash(0.6, 1.5));
    	addSequential(new AutoTurnWithGyro(60));
    	addSequential(new AutoDriveStraightTrash(0.6, 2));
    	addSequential(new Wait(0.75));
    	addSequential(new GearHolderOpenAndLower());
    	addSequential(new Wait(0.4));
    	addSequential(new AutoTrashDrive(-0.5, 1.7));
    }
}
