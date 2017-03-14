package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterStopShooting extends Command {

    public ShooterStopShooting() {
        requires(Robot.shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	Robot.shooter.setLeftShooter(0);
    	Robot.shooter.setCenterShooter(0);
    	Robot.shooter.setRightShooter(0);
    	org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap.shooterLeftShooterMotor.enableBrakeMode(false);    	
    }

    protected void interrupted() {
    }
}
