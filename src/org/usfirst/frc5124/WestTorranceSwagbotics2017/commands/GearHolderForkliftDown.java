package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GearHolderForkliftDown extends Command {

    public GearHolderForkliftDown() {
    	requires(Robot.gearHolder);					/* Uses the gear holder subsystem */
    }

    protected void initialize() {
    	Robot.gearHolder.forkliftDown();			/* move the gear holder down */
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;								/* Immediately end since all we do is change the state of the solenoid valve */
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
