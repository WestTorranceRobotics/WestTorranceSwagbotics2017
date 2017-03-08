package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShooterTeleopShoot extends Command {

    public ShooterTeleopShoot() {
        requires(Robot.shooter);
    }

    protected void initialize() {
    	Robot.shooter.setControlMode(2);
    	Robot.shooter.setAllShooters(Robot.shooter.getShootingSpeed());
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.shooter.setControlMode(0);
    	Robot.shooter.setBrakeFalse();
    	Robot.shooter.setAllShooters(0);
    }

    protected void interrupted() {
    	end();
    }
}
