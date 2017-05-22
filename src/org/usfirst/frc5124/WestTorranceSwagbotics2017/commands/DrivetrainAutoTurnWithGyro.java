package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DrivetrainAutoTurnWithGyro extends Command {
	
	double degrees;
	
    public DrivetrainAutoTurnWithGyro(double degrees) {
    	requires(Robot.drivetrain);															/* Uses the drivetrain */
    	this.degrees = degrees;																/* Pass the degrees to the global degrees */
    }

    protected void initialize() {
    	Robot.gyroPIDHandler.getPIDController().setPID(0.1, 0.05, 0.56);
    	Robot.drivetrain.resetAllOutputs();													/* Reset PID outputs */
    	Robot.gyroPIDHandler.setSetpoint(degrees + Robot.gyroPIDHandler.getGyro());			/* Set the setpoint to where we are + where we wanna go */
    	Robot.gyroPIDHandler.enable();														/* Enable the PID loop */
    }
    
    protected void execute() {
    	Robot.drivetrain.setPIDOutputs();													/* Use the PID outputs to set motor powers to the drivetrain */
    }

    protected boolean isFinished() {
    	return Robot.gyroPIDHandler.onTarget();												/* Stop when we're there */
    }

    protected void end() {
    	Robot.gyroPIDHandler.disable();														/* Turn off PID loop */
    	Robot.drivetrain.stop();															/* Stop the drivetrain */
    	Robot.drivetrain.resetAllOutputs();													/* Reset the PID outputs */
    }

    protected void interrupted() {
    	end();
    }
}
