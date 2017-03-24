package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GearHolderCloseGearHolder extends Command {

    public GearHolderCloseGearHolder() {
    	requires(Robot.gearHolder);				/* Uses gearholder subsystem */
    }

    protected void initialize() {
    	Robot.gearHolder.holderClose();			/* Close the holder to grab gear */
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;							/* Immediately end since all we do is change the state of the solenoid valve */
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
