package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveByEncoder extends Command {
	
	int distance = 0;
	double power = 0;

    public AutoDriveByEncoder(int inches, double power) {
        requires(Robot.drivetrain);
        distance = inches;
        this.power = power;
    }

    protected void initialize() {
    	Robot.encoderPIDHandler.resetEncoders();
    	power = Math.copySign(power, distance);
    }

    protected void execute() {
    	Robot.drivetrain.tank(power, power);
    }

    protected boolean isFinished() {
        return (Math.abs(Robot.encoderPIDHandler.getLeft()) >= Math.abs(distance));
    }

    protected void end() {
    	Robot.drivetrain.stop();
    }

    protected void interrupted() {
    	end();
    }
}
