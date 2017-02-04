package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	private final RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
    private final Encoder encoder = RobotMap.drivetrainEncoder;
    
    public double encoderOutput = 0;
    public double gyroOutput = 0;
    public boolean encoderEnabled = false;
    public boolean gyroEnabled = false;
    
    public Drivetrain() {
	}

    public void initDefaultCommand() {
        setDefaultCommand(new JoystickPuppetry());
    }
    
    public void tank(double left, double right) {
    	robotDrive.tankDrive(left, right);
    }
    
    public void robonaughtDrive(double power, double turn) {
    	robotDrive.arcadeDrive(power, turn);
    }
    
    public void enableEncoderPID() {
    	Robot.encoderPIDHandler.enable();
    	encoderEnabled = true;
    }
    
    public void disableEncoderPID() {
    	Robot.encoderPIDHandler.disable();
    	encoderEnabled = false;
    	encoderOutput = 0;
    }
    
    public void enableAll() {
    	enableEncoderPID();
    }
    
    public void disableAll() {
    	disableEncoderPID();
    }
    
    public void writeEncoderOutput(double input) {
    	encoderOutput = input;
    }
    
    public void writeGyroOutput(double input) {
    	gyroOutput = input;
    }
    
    public void iWannaWalkLikeYouTalkLikeYouToo() {
    	tank(encoderOutput, 0);
    }
    
    public void setSetpoints(int encoderSetpoint/*, double gyroSetpoint*/) {
    	Robot.encoderPIDHandler.setSetpoint(encoderSetpoint + encoder.get());
    	//Robot.gyroPIDHandler.setSetpoint(gyroSetpoint);
    }
    
    public void stop() {
    	tank(0, 0);
    }
   
    
}

