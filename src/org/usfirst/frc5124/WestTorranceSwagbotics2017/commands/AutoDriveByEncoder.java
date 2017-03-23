package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveByEncoder extends Command {
	
	int distance = 0;											
	double power = 0;

    public AutoDriveByEncoder(int inches, double power) {
        requires(Robot.drivetrain);								/* Uses the drivetrain subsystem */
        distance = inches;										/* Pass the distance and power from the parameters */
        this.power = power;
    }

    protected void initialize() {
    	Robot.encoderPIDHandler.resetEncoders();				/*Reset encoders and make power the right direction */
    	power = Math.copySign(power, distance);
    }

    protected void execute() {
    	Robot.drivetrain.tank(power, power);					/* Drive */
    }

    protected boolean isFinished() {
    	//End the command when it passes the distance instructed to go
        return (Math.abs(Robot.encoderPIDHandler.getLeft()) >= Math.abs(distance));		
    }

    protected void end() {
    	Robot.drivetrain.stop();  								/* Stop driving */
    }

    protected void interrupted() {
    	end();
    }
}
