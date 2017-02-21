package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoKamikazeGear extends Command {

    public AutoKamikazeGear() {
        requires(Robot.drivetrain);
        setTimeout(10);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivetrain.tank(0.35, 0.35);
    }

    protected boolean isFinished() {
        return (Robot.gearHolder.getLimitSwitch()) || isTimedOut();
    }

    protected void end() {
    	Robot.drivetrain.stop();
    }

    protected void interrupted() {
    	end();
    }
}
