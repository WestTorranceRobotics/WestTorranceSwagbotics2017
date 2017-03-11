package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoKamikazeGear extends Command {

    public AutoKamikazeGear() {
        requires(Robot.drivetrain);
        setTimeout(5);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivetrain.tank(0.45, 0.45);
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
