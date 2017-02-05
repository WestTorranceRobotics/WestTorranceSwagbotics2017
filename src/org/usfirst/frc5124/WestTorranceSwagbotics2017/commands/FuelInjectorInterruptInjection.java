package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FuelInjectorInterruptInjection extends Command {

    public FuelInjectorInterruptInjection(double time) {
        requires(Robot.fuelInjector);
        setTimeout(time);
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.fuelInjector.stop();
    }

    protected void interrupted() {
    	end();
    }
}
