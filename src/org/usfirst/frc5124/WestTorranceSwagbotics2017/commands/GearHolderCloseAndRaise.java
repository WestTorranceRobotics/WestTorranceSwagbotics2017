package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GearHolderCloseAndRaise extends CommandGroup {

    public GearHolderCloseAndRaise() {
    	addSequential(new GearHolderCloseGearHolder());
    	addSequential(new Wait(.25));
    	addSequential(new GearHolderForkliftUp());
    }
}
