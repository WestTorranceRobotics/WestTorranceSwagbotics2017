package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends PIDSubsystem {

	private final Encoder encoder = RobotMap.drivetrainEncoder;
    private final SpeedController left1 = RobotMap.drivetrainLeft1;
    private final SpeedController left2 = RobotMap.drivetrainLeft2;
    private final SpeedController right1 = RobotMap.drivetrainRight1;
    private final SpeedController right2 = RobotMap.drivetrainRight2;
    private final RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
    
    public Drivetrain() {
		super(0, 0, 0); //TODO tune drivetrain PID
		getPIDController().setAbsoluteTolerance(50);
		getPIDController().setContinuous(false);
		getPIDController().setOutputRange(-0.5, 0.5);
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

	@Override
	protected double returnPIDInput() {
		return encoder.get();
	}

	@Override
	protected void usePIDOutput(double output) {
		//TODO use the output for  drivetrain PID
	}
}

