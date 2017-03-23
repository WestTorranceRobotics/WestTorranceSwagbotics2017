package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FuelInjectorConveyorToShootersAuto extends Command {

    public FuelInjectorConveyorToShootersAuto() {
    	requires(Robot.fuelInjector);
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
