package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	private final RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
	private final Compressor compressor = RobotMap.drivetrainCompressor;
	
	public double direction = 1;
    public double turnSpeed = 0.75;
    
    public double gyroOutput = 0;
    public double encoderOutput = 0;
    
    public Drivetrain() {
	}
    
    public void compressorOff() {
    	compressor.setClosedLoopControl(false);
    	compressor.stop();
    }
    
    public void compressorOn() {
    	compressor.setClosedLoopControl(true);
    	compressor.start();
    }
    
    public void setDrivetrainSpeed(double speed) {
    	robotDrive.setMaxOutput(speed);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new JoystickPuppetry());
    }
    
    public void setSpeed(double speed) {
    	robotDrive.setMaxOutput(speed);
    }
       
    public void tank(double left, double right) {
    	robotDrive.tankDrive(left, right);
    }
    
    public void robonaughtDrive(double power, double turn) {
    	robotDrive.arcadeDrive(power, turn);
    	
    }
    
    public void stop() {
    	tank(0, 0);
    }
    
    public double getDirection() {
		return direction;
	}
	
	public void reverseFront() {
		direction = Math.copySign(1, -direction);
	}
	
	public void frontAndCenter() {
		direction = 1;
	}
    
	public void slowTurn() {
		turnSpeed = 0.75;
	}
	
	public void fastTurn() {
		turnSpeed = 0.8;
	}
	
	public double getTurnSpeed() {
		return turnSpeed;
	}
	
	public void getEncoderOutput(double encoderOutput) {
		this.encoderOutput = encoderOutput;
	}
	
	public void getGyroOutput(double gyroOutput) {
		this.gyroOutput = gyroOutput;
	}
	
	public void getAllOutputs(double encoderOutput, double gyroOutput) {
		getEncoderOutput(encoderOutput);
		getGyroOutput(gyroOutput);
	}
	
	public void resetGyroOutput() {
		gyroOutput = 0;
	}
	
	public void resetEncoderOutput() {
		encoderOutput = 0;
	}
	
	public void resetAllOutputs() {
		resetEncoderOutput();
		resetGyroOutput();
	}
	
	public void setPIDOutputs() {
		robotDrive.arcadeDrive(encoderOutput, gyroOutput);
	}
}

