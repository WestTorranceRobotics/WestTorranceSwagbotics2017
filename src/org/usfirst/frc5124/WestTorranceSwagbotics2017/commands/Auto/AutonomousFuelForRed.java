package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Auto;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.FuelInjectorConveyorToShooters;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.ShooterStartShooting;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousFuelForRed extends CommandGroup {

    public AutonomousFuelForRed() {
    	//move up ~2/3 or so the distance it takes to reach the base line starting from right next to the boiler
    	//addSequential(new AutoDriveByPID(-50));
    	addSequential(new AutoDriveByEncoder(50, -0.6));
    	//Turn towards boiler
    	addSequential(new AutoTurnWithGyro(-50));
    	//move towards boiler
    	//addSequential(new AutoDriveByPID(75));
    	addSequential(new AutoDriveByEncoder(75, 0.6));
    	//addSequential(new AutoTrashDrive(4, -1));
    	//turn on conveyor and shooters for rest of auto
    	addParallel(new FuelInjectorConveyorToShooters());
    	addSequential(new ShooterStartShooting());
    }
}
