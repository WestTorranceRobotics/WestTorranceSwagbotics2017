package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Wait;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GearHolderAutoRelease extends CommandGroup {

	    public GearHolderAutoRelease() {
	        addSequential(new GearHolderForkliftDown());	        
	        addSequential(new Wait(.125));
	        addSequential(new GearHolderOpenGearHolder());

	    }
	}
