package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FuelInjectorInjectFuel extends Command {

    public FuelInjectorInjectFuel() {
        requires(Robot.fuelInjector);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.fuelInjector.inject();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }
    
    protected void interrupted() {
    	Robot.fuelInjector.stop();
    }
}
