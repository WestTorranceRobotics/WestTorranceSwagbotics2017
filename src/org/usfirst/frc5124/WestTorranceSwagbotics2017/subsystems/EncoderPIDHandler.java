package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class EncoderPIDHandler extends PIDSubsystem {
	
	private final Encoder encoder = RobotMap.drivetrainEncoder;

    public EncoderPIDHandler() {
        super(0.0000001, 0, 0);
        getPIDController().setAbsoluteTolerance(10);
        getPIDController().setContinuous(false);
    }

    public void initDefaultCommand() {
    }

    protected double returnPIDInput() {
        return encoder.get();
    }

    protected void usePIDOutput(double output) {
    	Robot.drivetrain.writeEncoderOutput(output);
    }
}
