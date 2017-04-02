package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.ShooterStartShooting;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousFuelForBlue extends CommandGroup {

    public AutonomousFuelForBlue() {
    	addSequential(new AutoDriveByPID(-100));						/* Drive to the base line by PID */
    	addSequential(new Wait(1));										/* Wait so refs count it and gimme those 5 points */	
    	
    	addSequential(new AutoDriveByPID(50));							/* Drive back to the turn point by PID */					
    	addSequential(new AutoTurnWithGyro(45));						/* Tune to be perpendicular to the boiler */
    	
    	addSequential(new AutoDriveByPID(40));							/* Drive to the boiler */
    	addSequential(new AutoTrashDrive(0.6, 1.5));					/* make sure we slam the boiler wall and are straight */
    	
    	addSequential(new AgitatorAutoAgitate());						/* Turn on everything associated with shooting */
    	addSequential(new FuelInjectorConveyorToShootersAuto());		/* Agitator, Conveyor, and Shooters */
    	addSequential(new ShooterStartShooting());
    }
}
