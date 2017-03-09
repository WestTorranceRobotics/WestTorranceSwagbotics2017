package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class EncoderPIDHandler extends PIDSubsystem {

	private final Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;
    private final Encoder rightEncoder = RobotMap.drivetrainRightEncoder;
	
    public EncoderPIDHandler() {
    	super(0, 0, 0);
    	getPIDController().setContinuous(false);
    	getPIDController().setAbsoluteTolerance(50);
    	getPIDController().setOutputRange(-0.7, 0.7);
    }

    public void initDefaultCommand() {
    }

    protected double returnPIDInput() {
        return leftEncoder.getDistance();
    }

    protected void usePIDOutput(double output) {
    	Robot.drivetrain.getEncoderOutput(output);
    }
    
    public void resetEncoders() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public double getLeft() {
    	return leftEncoder.getDistance();
    }
    
    public double getRight() {
    	return leftEncoder.getDistance();
    }
    
}
