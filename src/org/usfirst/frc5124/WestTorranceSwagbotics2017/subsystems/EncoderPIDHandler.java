package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class EncoderPIDHandler extends PIDSubsystem {
	
	private final Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;
	private final Encoder rightEncoder = RobotMap.drivetrainRightEncoder;

    public EncoderPIDHandler() {
        super(0.000001, 0, 0);
        getPIDController().setAbsoluteTolerance(10);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Encoder PID", "PIDSubsystem Controller", getPIDController());
    }

    public void initDefaultCommand() {
    }

    protected double returnPIDInput() {
        return leftEncoder.get();
    }

    protected void usePIDOutput(double output) {
    	Robot.drivetrain.writeEncoderOutput(output);
    }
}
