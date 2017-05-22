package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class DrivetrainAutoTrashDrive extends Command {
	
	double power;
    
    public DrivetrainAutoTrashDrive(double power, double time) {
    	setTimeout(time);													/* Pass the timeout */
        requires(Robot.drivetrain);											/* Uses drivetrain */
    	this.power = power;													/* Pass the power to global power */
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.drivetrainRobotDrive.arcadeDrive(power, 0);				/* Go */
    }

    protected boolean isFinished() {
        return isTimedOut();												/* Stop after the set amount off time */
    }

    protected void end() {
    	Robot.drivetrain.stop();											/* Stop the drive train */
    }

    protected void interrupted() {
    	end();
    }
}
