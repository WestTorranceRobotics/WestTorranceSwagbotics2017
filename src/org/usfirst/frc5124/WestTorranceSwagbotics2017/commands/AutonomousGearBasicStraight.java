package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Wait;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGearBasicStraight extends CommandGroup {

    public AutonomousGearBasicStraight() {
    	//addSequential(new AutoDriveByEncoder(80, 0.6));
    	addSequential(new AutoDriveByPID(80));
    	//go to lift
    	addSequential(new AutoTrashDrive(0.5, 0.5));
    	addSequential(new GearHolderOpenAndLower());
    	addSequential(new Wait(0.6));
    	addSequential(new AutoTrashDrive(-0.5, 1.5));
    }
}
