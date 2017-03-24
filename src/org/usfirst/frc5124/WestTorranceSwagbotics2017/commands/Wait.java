package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command {

    public Wait(double waitTime) {
    	setTimeout(waitTime);						/* Pass the waittime to the timeout */
    }

    protected void initialize() {
    }

    protected void execute() {						/* do nothing, other commands can probably still run because this command requires no subsystem */
    }												/* To avoid this, a wait command can be made for each subsystem, but I've never had a problem with this */

    protected boolean isFinished() {
        return isTimedOut();						/* finish when the set time has passed by */
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
