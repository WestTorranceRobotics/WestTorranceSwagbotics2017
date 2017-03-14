package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AgitatorReverse extends Command {

    public AgitatorReverse() {
        requires(Robot.agitator);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.agitator.reverse();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.agitator.stop();
    }

    protected void interrupted() {
    	end();
    }
}
