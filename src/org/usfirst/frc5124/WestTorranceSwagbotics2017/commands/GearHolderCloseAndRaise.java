package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GearHolderCloseAndRaise extends CommandGroup {

    public GearHolderCloseAndRaise() {
    	addSequential(new GearHolderCloseGearHolder()); 		/* Grab the Gear */
    	addSequential(new Wait(.25));							/* Wait for the thing to actually move */
    	addSequential(new GearHolderForkliftUp());				/* Move the gear mech up */
    }
}
