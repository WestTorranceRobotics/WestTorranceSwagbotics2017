package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousTrashRedBoiler extends CommandGroup {

    public AutonomousTrashRedBoiler() {
    	addSequential(new AutoDriveStraightTrash(-0.5, 1.3102913555));
    	addSequential(new AutoTurnWithGyro(-45));
    	addSequential(new AutoDriveStraightTrash(0.6, 2));
    	addSequential(new AgitatorAutoAgitate());
    	addSequential(new FuelInjectorConveyorToShootersAuto());
    	addSequential(new ShooterStartShooting());
    }
}
