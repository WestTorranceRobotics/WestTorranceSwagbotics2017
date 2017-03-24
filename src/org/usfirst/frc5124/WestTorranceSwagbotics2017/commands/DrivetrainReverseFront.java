package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DrivetrainReverseFront extends Command {

    public DrivetrainReverseFront() {
    	requires(Robot.drivetrain);					/* Uses the Drivetrain */
    }

    protected void initialize() {
    	Robot.drivetrain.stop();					/* Stop before reversing motors to prevent damage, but it probably has little/no actual effect b/c its so fast */
    	Robot.drivetrain.reverseFront();			/* Switch the front of the robot */
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;								/* Immediately finish */
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
