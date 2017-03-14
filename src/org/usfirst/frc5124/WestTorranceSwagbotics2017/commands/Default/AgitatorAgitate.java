package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class AgitatorAgitate extends Command {

    public AgitatorAgitate() {
        requires(Robot.agitator);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.agitator.agitate();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.agitator.stop();
    }

    protected void interrupted() {
    	end();
    }
}
