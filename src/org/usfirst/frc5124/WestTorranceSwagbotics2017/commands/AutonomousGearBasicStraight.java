package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Wait;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGearBasicStraight extends CommandGroup {

    public AutonomousGearBasicStraight() {
    	addSequential(new AutoDriveByPID(80));				/* Drive to the peg */
    	addSequential(new AutoTrashDrive(0.5, 0.5));		/* Make sure we smash that motherfuckin like button (the wall) */
    	
    	addSequential(new GearHolderOpenAndLower());		/* Let go of the gear */
    	addSequential(new Wait(0.6));						/* Wait a little */
    	
    	addSequential(new AutoTrashDrive(-0.5, 1.5));		/* Back away from the peg */
    }
}
