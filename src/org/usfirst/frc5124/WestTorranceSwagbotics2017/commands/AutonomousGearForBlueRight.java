package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Wait;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGearForBlueRight extends CommandGroup {

    public AutonomousGearForBlueRight() {
    	addSequential(new AutoDriveByPID(90));				/* Drive to around the baseline are to turn to the peg */
    	addSequential(new AutoTurnWithGyro(-60));			/* Turn to be perpendicular to the peg */
    	
    	addSequential(new AutoDriveByPID(35));				/* Drive to the peg */
    	addSequential(new AutoTrashDrive(0.6, 0.5));		/* Smash the wall to be staright and make sure were all the way there */
    	
    	addSequential(new GearHolderOpenAndLower());		/* Let go of the gear */
    	addSequential(new Wait(0.6));						/* Wait a little */
    	
    	addSequential(new AutoTrashDrive(-0.5, 1.5));		/* Back away from the peg */
    }
}
