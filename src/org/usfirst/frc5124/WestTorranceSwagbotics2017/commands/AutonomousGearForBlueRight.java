package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGearForBlueRight extends CommandGroup {

    public AutonomousGearForBlueRight() {
    	addSequential(new AutoDriveByEncoder(92, 0.5));
    	addSequential(new AutoTurnWithGyro(-45));
    	addSequential(new AutoDriveByEncoder(12, 0.5));
    	addSequential(new AutonomousPlaceGear());
    	//move away from wall by a foot
    	addSequential(new AutoDriveByEncoder(-12, 0.5));
    }
}
