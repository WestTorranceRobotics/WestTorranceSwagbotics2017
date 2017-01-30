package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

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
        return Robot.gearHolder.getLimitSwitch();
    }
    
    protected void end() {
    }

    protected void interrupted() {
    }
}
