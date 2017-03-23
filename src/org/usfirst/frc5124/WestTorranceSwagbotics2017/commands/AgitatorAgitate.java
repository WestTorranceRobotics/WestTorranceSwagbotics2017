package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class AgitatorAgitate extends Command {

    public AgitatorAgitate() {
        requires(Robot.agitator);				/* Uses the Agitator subsystem */
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.agitator.agitate();				/* Run agitator */
    }

    protected boolean isFinished() {
        return false;							/* Is a WhileHeld command, so scheduler will handle this */
    }

    protected void end() {
    	Robot.agitator.stop();					/* Stop Agitator */
    }

    protected void interrupted() {
    	end();
    }
}
