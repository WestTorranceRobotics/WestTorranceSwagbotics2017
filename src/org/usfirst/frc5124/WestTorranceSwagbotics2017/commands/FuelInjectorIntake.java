package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FuelInjectorIntake extends Command {

    public FuelInjectorIntake() {
    	requires(Robot.fuelInjector);				/* Uses the fuel injector subsystem */
    }

    protected void initialize() {
    	Robot.fuelInjector.intake();				/* Intake and extract so that balls go to the hopper */
    	Robot.fuelInjector.extract();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;								/* While held, scheduler will handle this */
    }

    protected void end() {
    	Robot.fuelInjector.stop();					/* Stop */
    }

    protected void interrupted() {
    	end();
    }
}
