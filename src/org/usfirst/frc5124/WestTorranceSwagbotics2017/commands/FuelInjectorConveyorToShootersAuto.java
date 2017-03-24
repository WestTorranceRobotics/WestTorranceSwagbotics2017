package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FuelInjectorConveyorToShootersAuto extends Command {

    public FuelInjectorConveyorToShootersAuto() {
    	requires(Robot.fuelInjector);				/* This is the same as the regular one, except it immediately ends so it can be used in command groups */
    }

    protected void initialize() {
    	Robot.fuelInjector.intake();						
    	Robot.fuelInjector.inject();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
