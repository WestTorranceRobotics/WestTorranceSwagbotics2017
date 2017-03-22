package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveByPID extends Command {
	
	public double distance = 0;

    public AutoDriveByPID(double distance) {
        requires(Robot.drivetrain);
        this.distance = distance;
    }
    
    protected void initialize() {
    	Robot.drivetrain.resetAllOutputs();
    	Robot.encoderPIDHandler.setSetpoint(Robot.encoderPIDHandler.getLeft() + distance);
    	Robot.encoderPIDHandler.enable();
    }

    protected void execute() {
    	Robot.drivetrain.setPIDOutputs();
    }

    protected boolean isFinished() {
        return Robot.encoderPIDHandler.onTarget();
    }

    protected void end() {
    	Robot.encoderPIDHandler.disable();
    	Robot.drivetrain.stop();
    	Robot.drivetrain.resetAllOutputs();
    }

    protected void interrupted() {
    	end();
    }
}
