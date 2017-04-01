package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveStraightTrash extends Command {
	
	double power;

    public AutoDriveStraightTrash(double power, double time) {
    	requires(Robot.drivetrain);
    	this.power = power;
    	setTimeout(time);
    }

    protected void initialize() {
    	Robot.gyroPIDHandler.getPIDController().setPID(0.35, 0, 0);
    	Robot.drivetrain.resetAllOutputs();
    	Robot.gyroPIDHandler.setSetpoint(Robot.gyroPIDHandler.getGyro());
    	Robot.gyroPIDHandler.enable();
    }

    protected void execute() {
    	Robot.drivetrain.driveStraightPlease(power);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.gyroPIDHandler.disable();
    	Robot.drivetrain.resetAllOutputs();
    	Robot.drivetrain.stop();
    }

    protected void interrupted() {
    	end();
    }
}
