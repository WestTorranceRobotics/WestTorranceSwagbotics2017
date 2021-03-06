package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class GyroPIDHandler extends PIDSubsystem {
	
	private ADXRS450_Gyro gyro = RobotMap.drivetrainGyro;			/* Gyro sensor */

    public GyroPIDHandler() {
    	super(0.1, 0.05, 0.56);										/* PID gains */
    	getPIDController().setContinuous(false);					/* Not continuous sensor because its degrees, not a compass */
    	getPIDController().setAbsoluteTolerance(3);					/* 3 degrees of tolerance. Now that's a sensible tolerance */
    	getPIDController().setOutputRange(-0.85, 0.85);				/* Max outputs of PID loop, just afraid of full speed (-1, 1) */
    }

    public void initDefaultCommand() {
    }

    protected double returnPIDInput() {								/* Input sensor is the gyro */
        return gyro.getAngle();
    }
    
    public double getGyro() {										/* Getter for the gyro */
    	return gyro.getAngle();
    } 

    protected void usePIDOutput(double output) {					/* Send the PID output to the drivetrain subsystem */
    	Robot.drivetrain.getGyroOutput(output);
    }
    
    public void calibrate() {										/* Calibrate the gyro, which calibrates it and sets the */
    	gyro.calibrate();											/* current heading to 0 degrees */
    }
}
