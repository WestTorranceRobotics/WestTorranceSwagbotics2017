package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShooterStartShooting extends Command {

    public ShooterStartShooting() {
        requires(Robot.shooter);														/* Uses the shooter subsystem */
    }

    protected void initialize() {
    	Robot.shooter.setControlMode(2);												/* Set the shooters to the velocity PID mode */
    	Robot.shooter.setLeftShooter(Robot.shooter.getShootingSpeedLeft());				/* set each shooter to its respective shooting velocity setpoint */
    	Robot.shooter.setCenterShooter(Robot.shooter.getShootingSpeedCenter());
    	Robot.shooter.setRightShooter(Robot.shooter.getShootingSpeedRight());
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;																	/* end immediately, for use in auto and command groups */
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
