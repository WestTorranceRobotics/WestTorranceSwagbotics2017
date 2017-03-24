package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FuelInjectorStopAuto extends Command {

    public FuelInjectorStopAuto() {	
    	requires(Robot.fuelInjector);			/* Uses fuel injector subsystem */
    }

    protected void initialize() {
    	Robot.fuelInjector.stop();				/* Stop drivetrain */
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;							/* Immediately end for use in conjunction with the other fuel injector auto commands in command groups */
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
