package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Auto;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.GearHolderSafelyOpen;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.GearHolderWaitForPress;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGearForBlueRight extends CommandGroup {

    public AutonomousGearForBlueRight() {
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
