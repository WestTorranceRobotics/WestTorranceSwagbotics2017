package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShooterStartShooting extends Command {

    public ShooterStartShooting() {
        requires(Robot.shooter);
    }

    protected void initialize() {
    	Robot.shooter.setControlMode(2);
    	Robot.shooter.setLeftShooter(Robot.shooter.getShootingSpeedLeft());
    	Robot.shooter.setCenterShooter(Robot.shooter.getShootingSpeedCenter());
    	Robot.shooter.setRightShooter(Robot.shooter.getShootingSpeedRight());
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}