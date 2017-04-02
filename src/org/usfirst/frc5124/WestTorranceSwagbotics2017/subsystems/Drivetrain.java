package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	private final RobotDrive robotDrive = RobotMap.drivetrainRobotDrive; 			/* The drivetrain has more hardware that are children of the robot drive */
	private final Compressor compressor = RobotMap.drivetrainCompressor;			/* but this is all you need to run the drivetrain */
	
	public double direction = 1;													/* Direction multiplier for the reversing of the front */
    public double turnSpeed = 0.75;													/* percentage speed to turn at */
    
    public double gyroOutput = 0;													/* PID outputs for the cascading PID subsytems. Essentially, the outputs*/
    public double encoderOutput = 0;												/* of the two PID handlers are passed to these variables and then set to */
    																				/* drivetrain out puts so that they can both be run at the same time or */
    public Drivetrain() {															/* Independently of each other */
	}
    	
    public void initDefaultCommand() {												/* The defualt command is the joystick driving command. This will run when */
        setDefaultCommand(new JoystickPuppetry());									/* nothing else is running on the subsystem */ 
    }
    
    public void compressorOff() {													/* Turn off the compressor */
    	compressor.setClosedLoopControl(false);
    	compressor.stop();
    }
    
    public void compressorOn() {													/* Turn on the compressor */
    	compressor.setClosedLoopControl(true);
    	compressor.start();
    }
    
    public void setDrivetrainSpeed(double speed) {									/* Set the max output of the drivetrain */
    	robotDrive.setMaxOutput(speed);
    }
       
    public void tank(double left, double right) {									/* Tank drive */
    	robotDrive.tankDrive(left, right);
    }
    
    public void robonaughtDrive(double power, double turn) {						/* arcade drive, used for split arcade drive in our case */
    	robotDrive.arcadeDrive(power, turn);
    }
    
    public void stop() {															/* Stop the drivetrain */
    	tank(0, 0);
    }
    
    public double getDirection() {													/* Returns the direction, and thus the front of the robot */
		return direction;
	}
	
	public void reverseFront() {													/* Reverse the sign of direction so the "front" of the robot flips */
		direction = Math.copySign(1, -direction);
	}
	
	public void frontAndCenter() {													/* Set the intake as the front of the robot */
		direction = 1;
	}
    
	public void slowTurn() {														/* Turn slower */
		turnSpeed = 0.75;
	}
	
	public void fastTurn() {														/* Turn faster */
		turnSpeed = 0.8;
	}
	
	public double getTurnSpeed() {													/* Return the turn speed */
		return turnSpeed;
	}
	
	public void getEncoderOutput(double encoderOutput) {							/* Get the encoder PID output, used to grab PID output from encoder PID handler */
		this.encoderOutput = encoderOutput;
	}
	
	public void getGyroOutput(double gyroOutput) {									/* Same thing as the encoder one but for the gyro PID handler */
		this.gyroOutput = gyroOutput;
	}
	
	public void getAllOutputs(double encoderOutput, double gyroOutput) {			/* This is useless. Nowhere in this code is this used or can it be used */
		getEncoderOutput(encoderOutput);											/* But here it will stay */
		getGyroOutput(gyroOutput);
	}
	
	public void resetGyroOutput() {													/* Reset gyro PID output to 0 */
		gyroOutput = 0;
	}
	
	public void resetEncoderOutput() {												/* Same thing as the gyro one but for the encoder output */ 
		encoderOutput = 0;
	}
	
	public void resetAllOutputs() {													/* Reset both PID outputs at the same time */		
		resetEncoderOutput();														
		resetGyroOutput();
	}
	
	public void setPIDOutputs() {													/* Pass the PID outputs into the arcade drive function to use to drive the robot */
		robotDrive.arcadeDrive(encoderOutput, gyroOutput);							
	}
	
	public void driveStraightPlease(double power) {									/* Drive using a power, but use the gyro PID output for the turn value */
		robotDrive.arcadeDrive(power, gyroOutput);									/* This is used exclusively for driving straight with a motor power */
	}																				/* in the AutoDriveStraightTrash Command */
}

