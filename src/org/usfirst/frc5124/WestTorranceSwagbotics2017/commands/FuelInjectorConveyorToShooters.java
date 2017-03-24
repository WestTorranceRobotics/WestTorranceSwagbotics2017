package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FuelInjectorConveyorToShooters extends Command {

    public FuelInjectorConveyorToShooters() {
    	requires(Robot.fuelInjector);				/* Uses the fuel injector subsystem */
    }

    protected void initialize() {
    	Robot.fuelInjector.intake();				/* Intake and inject so balls go to shooter */
    	Robot.fuelInjector.inject();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;								/* Let the scheduler handle this, since its a while held command */
    }

    protected void end() {
    	Robot.fuelInjector.stop();					/* Stop the motors */
    }

    protected void interrupted() {
    	end();
    }
}
