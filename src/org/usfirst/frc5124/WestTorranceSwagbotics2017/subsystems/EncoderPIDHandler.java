 package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class EncoderPIDHandler extends PIDSubsystem {

	private final Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;			/* Two drivetrain encoders */
    private final Encoder rightEncoder = RobotMap.drivetrainRightEncoder;
	
    public EncoderPIDHandler() {								/* Never actually got the time to tune this so it was never used. May this be a reminder that */
    	super(.12, 0.005, 1.3);									/* engineers are the slowest people on this planet and will never finish the robot in time so that useful */
    	getPIDController().setContinuous(false);				/* auto code can be written before the robot is in an actual plastic bag so that auto is never ready for */
    	getPIDController().setAbsoluteTolerance(2);			    /* competition. May this code be forever in our hearts and always be remembered. RIP in pieces */
    	getPIDController().setOutputRange(-0.85, 0.85);			/* super(double, double, double) sets the PID gains, absolute tolerance is how far way the sensor can */
    															/* be from the target and the loop will say that it is good enough. It is set to 50 inches. Why it is */
    }															/* I don't know because thats probably longer than most commands for going a distance will ever be */
    															/* but then again, it was never used so it doesn't matter in the end. Output range just caps the outputs */
    															/* the PID loop will output */
    public void initDefaultCommand() {
    }

    protected double returnPIDInput() {							/* The input for this PID loop is the left encoder */
        return leftEncoder.getDistance();
    }

    protected void usePIDOutput(double output) {				/* Normal use may be to use the output to set a speed to a motor, but we pass is on to the drivetrain */
    	Robot.drivetrain.getEncoderOutput(output);				/* subsystem to be used later when the setPIDOutputs() method is called */
    }
    
    public void resetEncoders() {								/* resets encoders to 0 */
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public double getLeft() {									/* getter method for left encoder */
    	return leftEncoder.getDistance();
    }
    
    public double getRight() {									/* getter method for right encoder */
    	return leftEncoder.getDistance();
    }
    
}
