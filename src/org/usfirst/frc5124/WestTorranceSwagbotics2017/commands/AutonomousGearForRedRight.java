package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Wait;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGearForRedRight extends CommandGroup {

    public AutonomousGearForRedRight() {
    	//addSequential(new AutoDriveByEncoder(92, 0.5));
    	addSequential(new AutoDriveByPID(90));
    	addSequential(new AutoTurnWithGyro(-60));
    	//addSequential(new AutoDriveByEncoder(35, 0.5));
    	addSequential(new AutoDriveByPID(35));
    	addSequential(new AutoTrashDrive(0.6, 0.5));
    	addSequential(new GearHolderOpenAndLower());
    	addSequential(new Wait(0.6));
    	addSequential(new AutoTrashDrive(-0.5, 1.5));
    }
}
