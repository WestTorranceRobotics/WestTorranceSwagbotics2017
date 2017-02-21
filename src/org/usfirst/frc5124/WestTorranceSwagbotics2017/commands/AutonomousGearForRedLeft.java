package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGearForRedLeft extends CommandGroup {

    public AutonomousGearForRedLeft() {
    	//move up beginning from center of wall
    	addSequential(new AutoDriveByEncoder(92));
    	addSequential(new AutoTurnWithGyro(45));
    	addSequential(new AutoDriveByEncoder(12));
    	addSequential(new AutonomousPlaceGear());
    	//move away from wall by a foot
    	addSequential(new AutoDriveByEncoder(-12));
    	
    }
}
