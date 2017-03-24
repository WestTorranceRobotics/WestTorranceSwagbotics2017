package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShooterTeleopShoot extends Command {

    public ShooterTeleopShoot() {
        requires(Robot.shooter);														/* Uses the shooter subsystem */
    }

    protected void initialize() {
    	Robot.shooter.setControlMode(2);												/* Set shootersto velocity PID mode */
    	Robot.shooter.setLeftShooter(Robot.shooter.getShootingSpeedLeft());				/* Set each shooter to its respective velocity setpoint */
    	Robot.shooter.setCenterShooter(Robot.shooter.getShootingSpeedCenter());
    	Robot.shooter.setRightShooter(Robot.shooter.getShootingSpeedRight());
    	
    }

    protected void execute() {
    	Robot.shooter.setLeftShooter(Robot.shooter.getShootingSpeedLeft());				/* Keep setting the velocities to update them because they can be updated */
    	Robot.shooter.setCenterShooter(Robot.shooter.getShootingSpeedCenter());			/* in telop periodic to change the speed on the fly by the drivers */
    	Robot.shooter.setRightShooter(Robot.shooter.getShootingSpeedRight());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.shooter.setControlMode(0);												/* set shooters to volatge control */
    	Robot.shooter.setBrakeFalse();													/* set to coast mode */
        Robot.shooter.setLeftShooter(0);												/* set all shooters to 0% power */
        Robot.shooter.setCenterShooter(0);
    	Robot.shooter.setRightShooter(0);
    }

    protected void interrupted() {
    	end();
    }
}
