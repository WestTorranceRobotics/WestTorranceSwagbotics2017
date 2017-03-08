package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGearBasicStraight extends CommandGroup {

    public AutonomousGearBasicStraight() {
    	//move up beginning from center of wall
    	addSequential(new AutoDriveByEncoder(92, 0.5));
    	//place gear
    	addSequential(new AutonomousPlaceGear());
    	//move away from wall by a foot
    	addSequential(new AutoDriveByEncoder(-12, 0.5));
    }
}
