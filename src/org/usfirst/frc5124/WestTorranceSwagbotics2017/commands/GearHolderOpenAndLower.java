package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearHolderOpenAndLower extends CommandGroup {

    public GearHolderOpenAndLower() {
    	addSequential(new GearHolderForkliftDown());
    	addSequential(new GearHolderOpenGearHolder());
    }
}
