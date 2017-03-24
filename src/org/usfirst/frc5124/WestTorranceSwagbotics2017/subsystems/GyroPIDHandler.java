package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class GyroPIDHandler extends PIDSubsystem {
	
	private ADXRS450_Gyro gyro = RobotMap.drivetrainGyro;				/* Gyro sensor */

    public GyroPIDHandler() {
    	super(0.05, 0.000001, 0.11);									/* PID gains this thing doesn't really work that well :/ . Sad isn't it? */
    	getPIDController().setContinuous(false);						/* Not continuous sensor because it doesn't loop around, degrees go forever */
    	getPIDController().setAbsoluteTolerance(1);						/* 1 degree of tolerance. Now that's a sensible tolerance, could even be bigger */
    	getPIDController().setOutputRange(-0.6, 0.6);					/* Slow your roll, don't go too fast */
    }

    public void initDefaultCommand() {
    }

    protected double returnPIDInput() {									/* Input sensor is the gyro */
        return gyro.getAngle();
    }
    
    public double getGyro() {											/* Getter for the gyro */
    	return gyro.getAngle();
    } 

    protected void usePIDOutput(double output) {						/* Send the PID output to the drivetrain subsystem */
    	Robot.drivetrain.getGyroOutput(output);
    }
}
