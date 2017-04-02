package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class AgitatorStop extends Command {

    public AgitatorStop() {
    	requires(Robot.agitator);			/* Uses the agitator subsystem */
    }

    protected void initialize() {
    	Robot.agitator.stop();				/* Stop the agitator */
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;						/* Immediately end. For use in command groups, auto specifically */
    }

    protected void end() {					
    }

    protected void interrupted() {
    }
}
