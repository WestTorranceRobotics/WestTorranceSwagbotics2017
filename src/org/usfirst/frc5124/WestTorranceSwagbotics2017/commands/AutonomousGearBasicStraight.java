package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGearBasicStraight extends CommandGroup {

    public AutonomousGearBasicStraight() {
    	//addSequential(new AutoDriveByPID(85));
    	addSequential(new AutoDriveByEncoder(85, 0.6));
    	//go to lift
    	addSequential(new AutoKamikazeGear());
    	addSequential(new GearHolderSafelyOpen());
    }
}
