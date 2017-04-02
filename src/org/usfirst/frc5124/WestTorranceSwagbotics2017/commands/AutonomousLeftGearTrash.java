package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousLeftGearTrash extends CommandGroup {			/* This should proabbaly never be used, as it will never work */

    public AutonomousLeftGearTrash() {
    	addSequential(new AutoDriveStraightTrash(0.6, 1.5));		/* Drive to the base line area to turn */
    	addSequential(new AutoTurnWithGyro(60));					/* Tune to be perpendicular to the peg */
    	
    	addSequential(new AutoDriveStraightTrash(0.6, 2));			/* Drive to the peg and smash the wall */
    	addSequential(new Wait(0.75));								/* Wait for the violence to end */
    	
    	addSequential(new GearHolderOpenAndLower());				/* Release the gear */
    	addSequential(new Wait(0.4));								/* Wait a little */
    		
    	addSequential(new AutoTrashDrive(-0.5, 1.7));	 			/* Back away from the peg */
    }
}
