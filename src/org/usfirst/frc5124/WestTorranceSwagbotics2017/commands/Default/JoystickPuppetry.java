package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickPuppetry extends Command {

    public JoystickPuppetry() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	//Robot.drivetrain.tank(Robot.oi.getLeftSensitivity(.7), Robot.oi.getRightSensitvity(.7));
    	Robot.drivetrain.robonaughtDrive(Robot.oi.getLeftYAxisSens(), Robot.oi.getRightXAxisSens());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
