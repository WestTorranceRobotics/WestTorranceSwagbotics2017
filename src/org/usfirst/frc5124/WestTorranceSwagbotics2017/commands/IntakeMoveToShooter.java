package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeMoveToShooter extends Command {

    public IntakeMoveToShooter() {
        requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intake.intakeSlow();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.intake.stop();
    }

    protected void interrupted() {
    	end();
    }
}
