package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConveyorConveyUp extends Command {

    public ConveyorConveyUp() {
        requires(Robot.conveyor);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.conveyor.up();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	Robot.conveyor.stop();
    }
}
