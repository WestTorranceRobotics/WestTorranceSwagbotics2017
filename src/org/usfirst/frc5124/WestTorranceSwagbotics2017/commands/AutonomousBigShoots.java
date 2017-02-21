package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousBigShoots extends CommandGroup {

    public AutonomousBigShoots() {
    	/*addSequential(new DrivetrainCalibrate());
    	addSequential(new AutoTrashDrive(2, -1));
        
        addSequential(new AutoTurnWithGyro(-70));
        addSequential(new AutoTrashDrive(3, 1));*/
        addSequential(new ShooterStartShooting());
        addSequential(new Wait(5));
        addSequential(new ShooterStopShooting());
    }
}
