package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShooterStopShooting extends Command {

    public ShooterStopShooting() {
        requires(Robot.shooter);														/* Uses the shooter subsystem */
    }

    protected void initialize() {
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	Robot.shooter.setControlMode(0);												/* set shooters to volatge control */
    	Robot.shooter.setBrakeFalse();													/* set to coast mode */
        Robot.shooter.setLeftShooter(0);												/* set all shooters to 0% power */
        Robot.shooter.setCenterShooter(0);
    	Robot.shooter.setRightShooter(0);
    }

    protected void interrupted() {
    }
}
