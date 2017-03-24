package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FuelInjectorExhaust extends Command {

    public FuelInjectorExhaust() {
    	requires(Robot.fuelInjector);				/* Uses the fuel injector subsystem */
    }

    protected void initialize() {
    	Robot.fuelInjector.exhaust();				/* Outtake and extract so balls go to the floor */
    	Robot.fuelInjector.extract();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;								/* While held, so the scheduler will handle this */
    }

    protected void end() {
    	Robot.fuelInjector.stop();					/* Stop */
    }

    protected void interrupted() {
    	end();
    }
}
