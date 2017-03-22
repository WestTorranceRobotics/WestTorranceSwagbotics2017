package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Wait;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGearBasicStraight extends CommandGroup {

    public AutonomousGearBasicStraight() {
    	addSequential(new AutoDriveByEncoder(35, 0.6));
    	//go to lift
    	addSequential(new AutoTrashDrive(0.6, 3));
    	addSequential(new AutoTrashDrive(-0.5, 0.75));
    	addSequential(new GearHolderOpenAndLower());
    	addSequential(new Wait(1.5));
    	addSequential(new AutoTrashDrive(-0.5, 1));
    }
}
