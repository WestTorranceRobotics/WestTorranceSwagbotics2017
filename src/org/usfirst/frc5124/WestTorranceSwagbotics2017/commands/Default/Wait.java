package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Wait extends Command {

    public Wait(double waitTime) {
    	setTimeout(waitTime);
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
