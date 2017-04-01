package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.ShooterStartShooting;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousFuelForRed extends CommandGroup {

    public AutonomousFuelForRed() {
    	//move up ~2/3 or so the distance it takes to reach the base line starting from right next to the boiler
    	//addSequential(new AutoDriveByEncoder(100, -0.6));
    	addSequential(new AutoDriveByPID(-100));
    	addSequential(new Wait(1));
    	//addSequential(new AutoDriveByEncoder(50, 0.6));
    	addSequential(new AutoDriveByPID(50));
    	//Turn towards boiler
    	addSequential(new AutoTurnWithGyro(-45));
    	//move towards boiler
    	//addSequential(new AutoDriveByEncoder(40, 0.6));
    	addSequential(new AutoDriveByPID(40));
    	addSequential(new AutoTrashDrive(0.6, 1.5));
    	//turn on conveyor and shooters for rest of auto
    	addSequential(new AgitatorAutoAgitate());
    	addSequential(new FuelInjectorConveyorToShootersAuto());
    	addSequential(new ShooterStartShooting());
    }
}
