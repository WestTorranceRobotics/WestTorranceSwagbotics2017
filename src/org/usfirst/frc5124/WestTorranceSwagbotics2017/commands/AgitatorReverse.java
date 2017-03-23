package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class AgitatorReverse extends Command {

    public AgitatorReverse() {
        requires(Robot.agitator);				/* Uses the agitator subsystem */
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.agitator.reverse();				/* Run the agitator */	
    }

    protected boolean isFinished() {
        return false;							/* Scheduler will handle this */
    }

    protected void end() {
    	Robot.agitator.stop();					/* Stop the agitator */
    }

    protected void interrupted() {
    	end();
    }
}
