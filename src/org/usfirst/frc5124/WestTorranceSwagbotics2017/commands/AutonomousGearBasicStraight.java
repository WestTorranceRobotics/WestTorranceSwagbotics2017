package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGearBasicStraight extends CommandGroup {

    public AutonomousGearBasicStraight() {
    	//move up beginning from center of wall
    	addSequential(new AutoDriveByEncoder(75));
    	//go to lift
    	addSequential(new AutoKamikazeGear());
    	//place gear
    	addSequential(new GearHolderSafelyOpen());
    }
}
