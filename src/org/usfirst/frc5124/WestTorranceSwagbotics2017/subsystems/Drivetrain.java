package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.*;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends PIDSubsystem {

	private final RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
    private final Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;
    private final Encoder rightEncoder = RobotMap.drivetrainRightEncoder;
    private ADIS16448_IMU imu = RobotMap.drivetrainIMU;
    
    private boolean frontLeftInverted = true;
    private boolean frontRightInverted = true;
    private boolean backLeftInverted = true;
    public boolean backRightInverted = true;
    
    public Drivetrain() {
    	super(0, 0, 0);
    	getPIDController().setContinuous(false);
    	getPIDController().setAbsoluteTolerance(100);
    	getPIDController().setOutputRange(-0.7, 0.7);
	}
    
    public void resetEncoders() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public int getLeft() {
    	return leftEncoder.get();
    }
    
    public int getRight() {
    	return leftEncoder.get();
    }
    
    public void setDrivetrainSpeed(double speed) {
    	robotDrive.setMaxOutput(speed);
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
    
    public void stop() {
    	tank(0, 0);
    }

	@Override
	protected double returnPIDInput() {
		return leftEncoder.get();
	}

	@Override
	protected void usePIDOutput(double output) {
		robotDrive.arcadeDrive(output, 0);
	}
	
	public void calibrate() {
		imu.calibrate();
	}
	
	//return to normal direction configuration
	public void frontAndCenter() {
		robotDrive.setInvertedMotor(MotorType.kFrontLeft, frontLeftInverted = true);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, frontRightInverted = true);
		robotDrive.setInvertedMotor(MotorType.kRearLeft, backLeftInverted = true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, backRightInverted = true);
	}
   
	public void switcheroo() {
		robotDrive.setInvertedMotor(MotorType.kFrontLeft, frontLeftInverted = !frontLeftInverted);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, frontRightInverted = !frontRightInverted);
		robotDrive.setInvertedMotor(MotorType.kRearLeft, backLeftInverted = !backLeftInverted);
		robotDrive.setInvertedMotor(MotorType.kRearRight, backRightInverted = !backRightInverted);
	}
    
}

