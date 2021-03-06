package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class HangerHangReverse extends Command {

    public HangerHangReverse() {
        requires(Robot.hanger);					/* Uses the Hanger Subsystem */
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.hanger.setHangerPower(1);			/* Run the hanger in reverse */
    }

    protected boolean isFinished() {
    	return false;							/* While held, scheduler will handle this */
    }

    protected void end() {
    	Robot.hanger.stop();					/* Stop the hanger */
    }

    protected void interrupted() {
    	end();
    }
}
