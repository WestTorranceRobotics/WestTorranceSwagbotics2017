package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class AutoTrashDrive extends Command {
	
	double power;
    
    public AutoTrashDrive(double power, double time) {
    	setTimeout(time);
        requires(Robot.drivetrain);
    	this.power = power;
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.drivetrainRobotDrive.arcadeDrive(power, 0);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.drivetrain.stop();
    }

    protected void interrupted() {
    	end();
    }
}
