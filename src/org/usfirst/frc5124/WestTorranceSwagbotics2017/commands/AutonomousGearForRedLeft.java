package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGearForRedLeft extends CommandGroup {

    public AutonomousGearForRedLeft() {
    	//move up beginning from center of wall
    	addSequential(new AutoDriveByEncoder(90, 0.5));
    	addSequential(new AutoTurnWithGyro(30));
    	addSequential(new AutoDriveByEncoder(35, 0.5));
    	addSequential(new AutoKamikazeGear());
    	addSequential(new GearHolderSafelyOpen());
    	addSequential(new GearHolderWaitForPress());
    	addSequential(new Wait(1.5));
    	addSequential(new AutoTrashDrive(-0.45, 1, 1));
    	
    }
}
