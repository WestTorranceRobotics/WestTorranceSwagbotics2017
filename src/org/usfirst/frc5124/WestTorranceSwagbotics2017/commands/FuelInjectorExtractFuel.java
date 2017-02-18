package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FuelInjectorExtractFuel extends Command {

    public FuelInjectorExtractFuel() {
        requires(Robot.fuelInjector);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.fuelInjector.extract();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.fuelInjector.stop();
    }
    
    protected void interrupted() {
    	Robot.fuelInjector.stop();
    }
}
