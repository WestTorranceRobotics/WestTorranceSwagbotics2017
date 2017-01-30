package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConveyorInterruptOperation extends Command {

    public ConveyorInterruptOperation(double time) {
        requires(Robot.conveyor);
        setTimeout(time);
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.conveyor.stop();
    }

    protected void interrupted() {
    	end();
    }
}
