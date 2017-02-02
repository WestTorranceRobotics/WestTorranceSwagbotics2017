package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {

    public AutoDrive(int enc, double gyro) {
        requires(Robot.drivetrain);
        Robot.drivetrain.setSetpoints(enc);
    }

    protected void initialize() {
    	Robot.encoderPIDHandler.enable();
    }

    protected void execute() {
    	Robot.drivetrain.iWannaWalkLikeYouTalkLikeYouToo();
    }

    protected boolean isFinished() {
        return Robot.encoderPIDHandler.onTarget();
    }

    protected void end() {
    	Robot.drivetrain.disableAll();
    	Robot.drivetrain.stop();
    }
    
    protected void interrupted() {
    	end();
    }
}
