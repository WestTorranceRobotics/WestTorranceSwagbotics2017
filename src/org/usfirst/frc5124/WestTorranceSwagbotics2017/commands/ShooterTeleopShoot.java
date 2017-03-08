package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterTeleopShoot extends Command {

    public ShooterTeleopShoot() {
        requires(Robot.shooter);
    }

    protected void initialize() {
    	Robot.shooter.setControlMode(2);
    	Robot.shooter.setLeftShooter(Robot.shooter.getShootingSpeedLeft());
    	Robot.shooter.setCenterShooter(Robot.shooter.getShootingSpeedCenter());
    	Robot.shooter.setRightShooter(Robot.shooter.getShootingSpeedRight());
    	
    }

    protected void execute() {
    	Robot.shooter.setLeftShooter(Robot.shooter.getShootingSpeedLeft());
    	Robot.shooter.setCenterShooter(Robot.shooter.getShootingSpeedCenter());
    	Robot.shooter.setRightShooter(Robot.shooter.getShootingSpeedRight());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.shooter.setControlMode(0);
    	Robot.shooter.setBrakeFalse();
        Robot.shooter.setLeftShooter(0);
        Robot.shooter.setCenterShooter(0);
    	Robot.shooter.setRightShooter(0);
    }

    protected void interrupted() {
    	end();
    }
}
