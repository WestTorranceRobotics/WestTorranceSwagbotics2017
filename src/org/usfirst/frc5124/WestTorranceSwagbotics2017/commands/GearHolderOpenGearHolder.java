package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GearHolderOpenGearHolder extends Command {

    public GearHolderOpenGearHolder() {
    	requires(Robot.gearHolder);
    }

    protected void initialize() {
    	Robot.gearHolder.holderOpen();
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
