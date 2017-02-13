package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterStopShooting extends Command {

    public ShooterStopShooting() {
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.setControlMode(0);
    	Robot.shooter.setAllShooters(Robot.shooter.getShootingSpeed());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.setAllShooters(0);
    	org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap.shooterLeftShooterMotor.enableBrakeMode(false);
    
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
