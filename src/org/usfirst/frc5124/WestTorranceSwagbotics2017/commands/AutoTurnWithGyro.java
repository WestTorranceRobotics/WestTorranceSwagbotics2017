package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurnWithGyro extends Command {
	
	double target;
	//double power = 0.5;
	
    public AutoTurnWithGyro(double degrees) {
    	requires(Robot.drivetrain);
    	target = degrees;
    }

    protected void initialize() {
    	//position = RobotMap.drivetrainIMU.getAngle();
    	//Math.copySign(power, desire);
    	//desire = position + desire;
    	Robot.drivetrain.setSetpoint(target + Robot.drivetrain.getGyro());
    	Robot.drivetrain.enable();
    }
    
    protected void execute() {
    }

    protected boolean isFinished() {
        //return (Math.abs(desire - (RobotMap.drivetrainIMU.getAngle() - position)) < 5);
    	return Robot.drivetrain.onTarget();
    }

    protected void end() {
    	Robot.drivetrain.disable();
    	Robot.drivetrain.stop();
    }

    protected void interrupted() {
    	end();
    }
}
