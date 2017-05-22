package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousTrashRedBoiler extends CommandGroup {

    public AutonomousTrashRedBoiler() {
    	addSequential(new DrivetrainAutoTrashDrive(-0.5, 1.3102913555));		/* Drive to the turn point. The time to drive is my phone number */
																				/* because we never tested it. There it is if you need to conatct me */
    	addSequential(new DrivetrainAutoTurnWithGyro(-45));						/* Turn to be perpendicular to the boiler */
    	
    	addSequential(new DrivetrainAutoTrashDrive(0.6, 2));					/* Drive to the boiler and smash it to be straight */
    	
    	addSequential(new AgitatorAutoAgitate());								/* Turn on everything associated with shooting */
    	addSequential(new FuelInjectorConveyorToShootersAuto());				/* Agitator, Conveyor, and Shooters */
    	addSequential(new ShooterStartShooting());
    }
}
