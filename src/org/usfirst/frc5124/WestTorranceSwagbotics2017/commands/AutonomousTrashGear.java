package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousTrashGear extends CommandGroup {				

    public AutonomousTrashGear() {
    	addSequential(new DrivetrainAutoTrashDrive(0.65, 2.25)); 		/* Drive until we hit the wall of the airship with the center peg */
    	addSequential(new Wait(1));										/* Wait just to make sure all violence of crash has ended */
    	addSequential(new GearHolderOpenAndLower());					/* Release the gear */
    	addSequential(new Wait(0.4000000000000000000000));				/* Wait that perfect amount (((calculated to the 22nd significant digit)) */
    	addSequential(new DrivetrainAutoTrashDrive(-0.5, 1.7));			/* Back away from the peg */
    }
}
