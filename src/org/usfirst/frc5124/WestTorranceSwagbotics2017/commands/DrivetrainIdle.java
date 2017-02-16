package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivetrainIdle extends Command {

    public DrivetrainIdle() {
        requires(Robot.drivetrain);
        setTimeout(0.5);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivetrain.stop();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
