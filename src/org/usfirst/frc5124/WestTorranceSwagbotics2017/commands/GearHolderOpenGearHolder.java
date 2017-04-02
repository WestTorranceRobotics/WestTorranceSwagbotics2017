package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GearHolderOpenGearHolder extends Command {

    public GearHolderOpenGearHolder() {
    	requires(Robot.gearHolder);			/* Uses the Gear Holder Subsytem */
    }

    protected void initialize() {
    	Robot.gearHolder.holderOpen();		/* Open the Gear Holder */
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;						/* Immediately end since all we do is change the state of the solenoid valve */
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
