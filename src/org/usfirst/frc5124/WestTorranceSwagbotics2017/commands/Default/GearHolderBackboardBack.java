package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearHolderBackboardBack extends Command {

    public GearHolderBackboardBack() {
        requires(Robot.gearHolder);
    }

    protected void initialize() {
    	Robot.gearHolder.backBoardBack();
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
