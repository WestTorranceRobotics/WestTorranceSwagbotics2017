package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearHolderForkliftDown extends Command {

    public GearHolderForkliftDown() {
    	requires(Robot.gearHolder);
    }

    protected void initialize() {
    	Robot.gearHolder.forkliftDown();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
