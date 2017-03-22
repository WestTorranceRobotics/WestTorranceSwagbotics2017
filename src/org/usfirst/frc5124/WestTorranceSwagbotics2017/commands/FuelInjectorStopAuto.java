package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FuelInjectorStopAuto extends Command {

    public FuelInjectorStopAuto() {
    	requires(Robot.fuelInjector);
    }

    protected void initialize() {
    	Robot.fuelInjector.stop();
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
