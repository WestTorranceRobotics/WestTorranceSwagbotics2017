package org.usfirst.frc5124.WestTorranceSwagbotics2017;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Encoder;

public class RobotMap {
	
	//Gear Holder
	public static DoubleSolenoid gearHolderHolderSolenoid;
	public static DoubleSolenoid gearHolderPusherSolenoid;
	public static DoubleSolenoid gearHolderFunnelSolenoid;
	public static DigitalInput gearHolderLimitSwitch;
	
	//Conveyor
	public static VictorSP conveyorConveyorMotor;
	
	//Intake
	public static VictorSP intakeIntakeMotor;
	
	//Shooter
	public static CANTalon shooterLeftShooterMotor;
	public static CANTalon shooterCenterShooterMotor;
	public static CANTalon shooterRightShooterMotor;
	
	//Hanger
	public static CANTalon hangerHangerMotor;
	
	//DriveTrain
	public static Compressor drivetrainCompressor;
	public static Encoder drivetrainLeftEncoder;
	public static Encoder drivetrainRightEncoder;
	public static ADIS16448_IMU drivetrainIMU;
    public static VictorSP drivetrainLeft1;
    public static VictorSP drivetrainLeft2;
    public static VictorSP drivetrainRight1;
    public static VictorSP drivetrainRight2;
    public static RobotDrive drivetrainRobotDrive;

    public static void init() {
    	
    	
    	//////////////////////////
    	///GEAR HOLDER HARDWARE///
    	//////////////////////////
    	
    	gearHolderHolderSolenoid = new DoubleSolenoid(0, 1);
    	LiveWindow.addActuator("Gear Holder", "Holder Solenoid", gearHolderHolderSolenoid);
    	
    	gearHolderPusherSolenoid = new DoubleSolenoid(2, 3);
    	LiveWindow.addActuator("Gear Holder", "Pusher Solenoid", gearHolderPusherSolenoid);
    	
    	gearHolderFunnelSolenoid = new DoubleSolenoid(4, 5);
    	LiveWindow.addActuator("Gear Holder", "Funnel Solenoid", gearHolderFunnelSolenoid);
    	
    	gearHolderLimitSwitch = new DigitalInput(3);
    	
    	///////////////////////
    	///CONVEYOR HARDWARE///
    	///////////////////////
    	
    	conveyorConveyorMotor = new VictorSP(6);
    	LiveWindow.addActuator("Conveyor", "Conveyor Motor", conveyorConveyorMotor);
    	
    	
    	/////////////////////
    	///INATKE HARDWARE///
    	/////////////////////
    	
    	intakeIntakeMotor = new VictorSP(5);
    	LiveWindow.addActuator("Intake", "Intake Motor", intakeIntakeMotor);
    	
    	
    	//////////////////////
    	///SHOOTER HARDWARE///
    	//////////////////////
    	
    	shooterLeftShooterMotor = new CANTalon(3);
    	shooterLeftShooterMotor.enableBrakeMode(false);
    	shooterLeftShooterMotor.setProfile(0);
    	shooterLeftShooterMotor.setP(.1);
    	shooterLeftShooterMotor.setI(0);
    	shooterLeftShooterMotor.setD(0);
    	shooterLeftShooterMotor.setF(0.037);
    	shooterLeftShooterMotor.setAllowableClosedLoopErr(50);
    	shooterLeftShooterMotor.setControlMode(2);
    	shooterLeftShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	LiveWindow.addActuator("Shooter", "Left Shooter", shooterLeftShooterMotor);
    	
    	shooterCenterShooterMotor = new CANTalon(4);
    	shooterCenterShooterMotor.enableBrakeMode(false);
    	shooterCenterShooterMotor.setProfile(0);
    	shooterCenterShooterMotor.setP(.1);
    	shooterCenterShooterMotor.setI(0);
    	shooterCenterShooterMotor.setD(0);
    	shooterCenterShooterMotor.setF(0.037);
    	shooterCenterShooterMotor.setAllowableClosedLoopErr(50);
    	shooterCenterShooterMotor.setControlMode(2);
    	shooterCenterShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	LiveWindow.addActuator("Shooter", "Center Shooter", shooterCenterShooterMotor);
    	
    	shooterRightShooterMotor = new CANTalon(5);
    	shooterRightShooterMotor.enableBrakeMode(false);
    	shooterRightShooterMotor.setProfile(0);
    	shooterRightShooterMotor.setP(.1);
    	shooterRightShooterMotor.setI(0);
    	shooterRightShooterMotor.setD(0);
    	shooterRightShooterMotor.setF(0.037);
    	shooterRightShooterMotor.setAllowableClosedLoopErr(50);
    	shooterRightShooterMotor.setControlMode(2);
    	shooterRightShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	LiveWindow.addActuator("Shooter", "Right Shooter", shooterRightShooterMotor);
    	
    	
    	/////////////////////
    	///HANGER HARDWARE///
    	/////////////////////
    	
    	hangerHangerMotor = new CANTalon(6);
    	LiveWindow.addActuator("Hanger", "Hanger Motor", hangerHangerMotor);
    	
    	
    	/////////////////////////
    	///DRIVETRAIN HARDWARE///
    	/////////////////////////
    	
    	//drivetrainCompressor = new Compressor(0);
    	
    	drivetrainLeftEncoder = new Encoder(0, 1);
    	drivetrainRightEncoder = new Encoder(2, 3);
    	
    	//drivetrainIMU = new ADIS16448_IMU();

        drivetrainLeft1 = new VictorSP(0);
        LiveWindow.addActuator("Drivetrain", "Left 1", drivetrainLeft1);
        
        drivetrainLeft2 = new VictorSP(1);
        LiveWindow.addActuator("Drivetrain", "Left 2", drivetrainLeft2);
        
        drivetrainRight1 = new VictorSP(2);
        LiveWindow.addActuator("Drivetrain", "Right 1", drivetrainRight1);
        
        drivetrainRight2 = new VictorSP(3);
        LiveWindow.addActuator("Drivetrain", "Right 2", drivetrainRight2);
        
        drivetrainRobotDrive = new RobotDrive(drivetrainLeft1, drivetrainLeft2,
              drivetrainRight1, drivetrainRight2);
        
        drivetrainRobotDrive.setSafetyEnabled(false);
        drivetrainRobotDrive.setExpiration(0.1);
        drivetrainRobotDrive.setSensitivity(1);
        drivetrainRobotDrive.setMaxOutput(1);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

    }
}
