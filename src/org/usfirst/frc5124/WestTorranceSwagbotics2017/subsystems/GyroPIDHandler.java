package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import com.analog.adis16448.frc.ADIS16448_IMU;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class GyroPIDHandler extends PIDSubsystem {

    private final ADIS16448_IMU IMU = RobotMap.drivetrainIMU;
    
    public GyroPIDHandler() {
    	super(0, 0, 0);
        getPIDController().setAbsoluteTolerance(1);
        getPIDController().setContinuous(false);
    }

    public void initDefaultCommand() {
    }

    protected double returnPIDInput() {
        return IMU.getAngleZ();
    }

    protected void usePIDOutput(double output) {
        Robot.drivetrain.writeGyroOutput(output);
    }
    
}
