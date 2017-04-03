 package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class EncoderPIDHandler extends PIDSubsystem {

	private final Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;			
    private final Encoder rightEncoder = RobotMap.drivetrainRightEncoder;
	
    public EncoderPIDHandler() {								
    	super(.12, 0.005, 1.3);									/* super(double, double, double) sets the PID gains, absolute tolerance is how far way the sensor can */
    	getPIDController().setContinuous(false);				/* be from the target and the loop will say that it is good enough. It is set to 2 inches, becuase  */
    	getPIDController().setAbsoluteTolerance(2);			    /* thats is accurate enough for any auto im writing. Output range just caps the outputs*/
    	getPIDController().setOutputRange(-0.85, 0.85);			/* the PID loop will output. I capped it becuase I was just a little afraid of full speed */
    }															/* but there's really no real point in not allowing it the full range of values (-1, 1) */
    															
    public void initDefaultCommand() {
    }

    protected double returnPIDInput() {							/* The input for this PID loop is the left encoder */
        return leftEncoder.getDistance();
    }

    protected void usePIDOutput(double output) {				/* Normal use may be to use the output to set a speed to a motor, but we pass it on to the drivetrain */
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
