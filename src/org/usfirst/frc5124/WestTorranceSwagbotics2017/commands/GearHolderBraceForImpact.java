package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class GearHolderBraceForImpact extends Command {

    public GearHolderBraceForImpact() {
        requires(Robot.gearHolder);
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        //return Robot.gearHolder.getLimitSwitch() ? Robot.oi.getDriver().getRawButton(1) : false;
    	return Robot.gearHolder.getLimitSwitch();
    }
    
    protected void end() {
    	Scheduler.getInstance().add(new GearHolderAutoRelase());
    }

    protected void interrupted() {
    }
}
