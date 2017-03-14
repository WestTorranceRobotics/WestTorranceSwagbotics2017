package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Auto;

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
    	Robot.drivetrain.tank(0.5, 0.5);
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