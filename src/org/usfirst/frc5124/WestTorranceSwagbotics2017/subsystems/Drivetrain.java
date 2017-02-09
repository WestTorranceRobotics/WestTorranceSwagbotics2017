package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	private final RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
    private final Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;
    private final Encoder rightEncoder = RobotMap.drivetrainRightEncoder;
    
    public Drivetrain() {
	}
    
    public void resetEncoders() {
    	leftEncoder.reset();
    	//rightEncoder.reset();
    }
    
    public int getLeft() {
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
   
    
}

