package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurnWithGyro extends Command {
	double desire;
	double position;
	double power = 0.5;
	
    public AutoTurnWithGyro(double wanna) {
    	requires(Robot.drivetrain);
    	desire = wanna;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	position = RobotMap.drivetrainIMU.getAngle();
    	Math.copySign(power, desire);
    	desire = position + desire;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.tank(power, -power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(desire - (RobotMap.drivetrainIMU.getAngle() - position)) < 5);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
