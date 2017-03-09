package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousTestDrive extends CommandGroup {

    public AutonomousTestDrive() {
    	
    	addSequential(new AutoDriveByEncoder(24, 0.5));
    	addSequential(new AutoDriveByEncoder(-24, 0.5));
    	addSequential(new AutoTurnWithGyro(90));
    	addSequential(new AutoTurnWithGyro(-90));
    }
}
