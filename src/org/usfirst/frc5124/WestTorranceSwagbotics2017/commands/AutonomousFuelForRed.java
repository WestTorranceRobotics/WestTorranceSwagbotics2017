package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousFuelForRed extends CommandGroup {

    public AutonomousFuelForRed() {
    	//move up ~2/3 or so the distance it takes to reach the base line starting from right next to the boiler
    	addSequential(new AutoDriveByEncoder(60));
    	//Turn towards boiler
    	addSequential(new AutoTurnWithGyro(-20));
    	//move towards boiler
    	addSequential(new AutoDriveByEncoder(63));
    	//addSequential(new AutoTrashDrive(4, -1));
    	//turn on conveyor and shooters for rest of auto
    	addParallel(new FuelInjectorConveyorToShooters());
    	addSequential(new ShooterStartShooting());
    }
}
