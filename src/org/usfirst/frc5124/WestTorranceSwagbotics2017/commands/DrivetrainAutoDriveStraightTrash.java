package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DrivetrainAutoDriveStraightTrash extends Command {
	
	double power;
	
	// This exists because no drivetrain will ever drive straight, but PID solves this by going fast. I've observed that the faster
	// you go, the less the drivetrain will naturally curve. However, with this command, you may want to drive slower
	// becuase unlike with PID, this wont slow down at the end, so it may be better to go slow the whole way,
	// and this ensures (hopefully) that the drivetrain goes straight at slow speeds

    public DrivetrainAutoDriveStraightTrash(double power, double time) {
    	requires(Robot.drivetrain);												/* Uses the Drivetrain subsystem */
    	this.power = power;														/* Pass power to the global power */
    	setTimeout(time);														/* Set timeout of command to the time parameter */
    }

    protected void initialize() {												
    	Robot.gyroPIDHandler.getPIDController().setPID(0.35, 0, 0);				/* Set the PID gains to only use P, thats all you need to go straight */
    	Robot.drivetrain.resetAllOutputs();										/* Reset the PID outputs, set the gyro set point to our current  */
    	Robot.gyroPIDHandler.setSetpoint(Robot.gyroPIDHandler.getGyro());		/* heading and enable the gyro PID */
    	Robot.gyroPIDHandler.enable();
    }

    protected void execute() {
    	Robot.drivetrain.driveStraightPlease(power);							/* Use the drive straight function with the power specified by user */
    }																			/* Look at the function in drivetrain to learn more */

    protected boolean isFinished() {
        return isTimedOut();													/* Stop driving when the time is up */
    }

    protected void end() {
    	Robot.gyroPIDHandler.disable();											/* Disable the gyro PID */
    	Robot.drivetrain.resetAllOutputs();										/* Reset the PID outputs to zero */
    	Robot.drivetrain.stop();												/* Stop the drivetrain for good measure */
    }

    protected void interrupted() {
    	end();
    }
}
