package org.usfirst.frc5124.WestTorranceSwagbotics2017;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;

public class RobotMap {
	 
	//All hardware declarations go here. Reference this hardware for subsystem hardware.
	//Declarations should be public and static here for use everywhere in the code.
	  
	//Shooter PIDF (Proportional, Integral, Derivative, Feed Forward) values.
	//Left PIDF Values
	public static double leftKp = 0.05;
	public static double leftKi = 0;
	public static double leftKd = 0;
	public static double leftKf = 0.0365;
		
	//Center PIDF Values
	public static double centerKp = 0.04;
	public static double centerKi = 0;
	public static double centerKd = 0;
	public static double centerKf = 0.035;

	//Right PIDF Values
	public static double rightKp = 0.05;
	public static double rightKi = 0;
	public static double rightKd = 0;
	public static double rightKf = 0.0375;
	
	//Agitator
    public static VictorSP agitatorAgitatorMotor;
	
	//Gear Holder
	public static DoubleSolenoid gearHolderHolderSolenoid;
	public static DoubleSolenoid gearHolderForkliftSolenoid;
    
	//Fuel Injector
	public static VictorSP fuelInjectorConveyorMotor;
	public static VictorSP fuelInjectorIntakeMotor;
	
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
	public static ADXRS450_Gyro drivetrainGyro;
    public static VictorSP drivetrainLeft1;
    public static VictorSP drivetrainLeft2;
    public static VictorSP drivetrainRight1;
    public static VictorSP drivetrainRight2;
    public static RobotDrive drivetrainRobotDrive;

    public static void init() {																			/* method for initializing robot hardware */ 
    																									/* when the code is started */
    	///////////////////////
    	///AGITATOR HARDWARE///
    	///////////////////////
    		
    	agitatorAgitatorMotor = new VictorSP(6);														/* VictorSP in PWM port 6 */
    	//LiveWindow.addActuator("Agitator", "Agitator Motor", agitatorAgitatorMotor);					/* These lines add the hardware to the LiveWindow */
    																								    /* for use during the Test mode on the driver station. */
    																								    /* They allow testing actuators and sensors without */
    																								    /* having to write code for them. They were commented out */
    																							    	/* after initial testing was over */
    																								     
    	//////////////////////////
    	///GEAR HOLDER HARDWARE///
    	//////////////////////////
    	
    	gearHolderHolderSolenoid = new DoubleSolenoid(0, 3, 6);											/* Double Solenoid On PCM 0 (CAN ID) on ports 2 and 7 */			
    	//LiveWindow.addActuator("Gear Holder", "Holder Solenoid", gearHolderHolderSolenoid);
    	
    	gearHolderForkliftSolenoid = new DoubleSolenoid(0, 2, 7);										/* Double Solenoid On PCM 0 (CAN ID) on ports 3 and 6 */
    	//LiveWindow.addActuator("Gear Holder", "Forklift Solenoid", gearHolderForkliftSolenoid);
    	
    	
    	////////////////////////////
    	///FUEL INJECTOR HARDWARE///
    	////////////////////////////
    	
    	fuelInjectorConveyorMotor = new VictorSP(4);													/* Victor SP on PWM port 4 */
    	//LiveWindow.addActuator("Fuel Injector", "Fuel Injector Motor", fuelInjectorConveyorMotor);
    	
    	fuelInjectorIntakeMotor = new VictorSP(5);														/* Victor SP on PWM port 5 */
    	//LiveWindow.addActuator("Intake", "Intake Motor", fuelInjectorIntakeMotor);
    	
    	
    	//////////////////////
    	///SHOOTER HARDWARE///
    	//////////////////////
    	
    	shooterLeftShooterMotor = new CANTalon(3);														/* TalonSRX with CAN ID 3 */
    	shooterLeftShooterMotor.enableBrakeMode(false);													/* Enable Coasting */
    	shooterLeftShooterMotor.setProfile(0);															/* Save PIDF values to profile 0 */
    	shooterLeftShooterMotor.setP(leftKp);															/* Set proportional gain */
    	shooterLeftShooterMotor.setI(leftKi);															/* Set integral gain */
    	shooterLeftShooterMotor.setD(leftKd);															/* Set derivative gain */
    	shooterLeftShooterMotor.setF(leftKf);															/* Set feed forward gain (essentially a motor power) */
    	shooterLeftShooterMotor.setAllowableClosedLoopErr(50);											/* The PID loop will tolerate 50 error */
    	shooterLeftShooterMotor.setControlMode(0);														/* Set control mode 0 (Voltage Control) */
    	shooterLeftShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);							/* Sensor attached is an encoder */
    	//LiveWindow.addActuator("Shooter", "Left Shooter", shooterLeftShooterMotor);
    	
    	shooterCenterShooterMotor = new CANTalon(4);													/* TalonSRX with CAN ID 4 */
    	shooterCenterShooterMotor.enableBrakeMode(false);												/* Enable Coasting */
    	shooterCenterShooterMotor.setProfile(0);														/* Save PIDF values to profile 0 */
    	shooterCenterShooterMotor.setP(centerKp);														/* Set proportional gain */
    	shooterCenterShooterMotor.setI(centerKi);														/* Set integral gain */
    	shooterCenterShooterMotor.setD(centerKd);														/* Set derivative gain */
    	shooterCenterShooterMotor.setF(centerKf);														/* Set feed forward gain (essentially a motor power) */
    	shooterCenterShooterMotor.setAllowableClosedLoopErr(50);										/* The PID loop will tolerate 50 error */
    	shooterCenterShooterMotor.setControlMode(0);													/* Set control mode 0 (Voltage Control) */
    	shooterCenterShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);						/* Sensor attached is an encoder */
    	//LiveWindow.addActuator("Shooter", "Center Shooter", shooterCenterShooterMotor);
    	
    	shooterRightShooterMotor = new CANTalon(5);														/* TalonSRX with CAN ID 5 */
    	shooterRightShooterMotor.enableBrakeMode(false);												/* Enable Coasting */
    	shooterRightShooterMotor.setProfile(0);															/* Save PIDF values to profile 0 */
    	shooterRightShooterMotor.setP(rightKp);															/* Set proportional gain */
    	shooterRightShooterMotor.setI(rightKi);															/* Set integral gain */
    	shooterRightShooterMotor.setD(rightKd);															/* Set derivative gain */
    	shooterRightShooterMotor.setF(rightKf);															/* Set feed forward gain (essentially a motor power) */
    	shooterRightShooterMotor.setAllowableClosedLoopErr(50);											/* The PID loop will tolerate 50 error */
    	shooterRightShooterMotor.setControlMode(0);														/* Set control mode 0 (Voltage Control) */
    	shooterRightShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);				      		/* Sensor attached is an encoder */
    	//LiveWindow.addActuator("Shooter", "Right Shooter", shooterRightShooterMotor);
    	
    	
    	/////////////////////
    	///HANGER HARDWARE///
    	/////////////////////
    	
    	hangerHangerMotor = new CANTalon(6);															/* TalonSRX with CAN ID 6 */
    	//LiveWindow.addActuator("Hanger", "Hanger Motor", hangerHangerMotor);
    	
    	
    	/////////////////////////
    	///DRIVETRAIN HARDWARE///
    	/////////////////////////
    	
    	drivetrainCompressor = new Compressor(0);														/* Compressor on PCM 0, not needed for it to run */
    	drivetrainCompressor.setClosedLoopControl(false);
    	
    	drivetrainLeftEncoder = new Encoder(8, 9);														/* Left  encoder on DIO ports 8 and 9 */
    	drivetrainLeftEncoder.setDistancePerPulse(0.0526990913949759);									/* Set the distance per encoder tick so it returns inches */
    	//LiveWindow.addSensor("Left", "Left", drivetrainLeftEncoder);									/* this number is derived from taking a distance the robot */
    																									/* Was pushed, and dividing it by the number of encoder */
    																									/* ticks the encoder read over that distance, thus */
    																									/* distance per pulse (pulse is the same as tick) */
    																									/* This number means there are 0.0526990913949759 inches */
    																									/* per encoder tick */
    	
    	drivetrainRightEncoder = new Encoder(6, 7);														/* Right encoder on DIO ports 6 and 7 */
    	drivetrainRightEncoder.setDistancePerPulse(0.0526990913949759);									/* Set the distance per encoder tick so it returns inches */
    	//LiveWindow.addSensor("Right", "Right", drivetrainRightEncoder);
    	
    	drivetrainGyro = new ADXRS450_Gyro();															/* Gyro plugged in the default SPI port (there's only one) */
        //LiveWindow.addSensor("Gyro", "Gyro", drivetrainGyro);
        
        drivetrainLeft1 = new VictorSP(0);																/* VictorSP on PWM port 0 */
        //LiveWindow.addActuator("Drivetrain", "Left 1", drivetrainLeft1);
        
        drivetrainLeft2 = new VictorSP(1);																/* VictorSP on PWM port 1 */
        //LiveWindow.addActuator("Drivetrain", "Left 2", drivetrainLeft2);
        
        drivetrainRight1 = new VictorSP(3);																/* VictorSP on PWM port 3 */
        //LiveWindow.addActuator("Drivetrain", "Right 1", drivetrainRight1);
        
        drivetrainRight2 = new VictorSP(2);																/* VictorSP on PWM port 2 */
        //LiveWindow.addActuator("Drivetrain", "Right 2", drivetrainRight2);
        
        drivetrainRobotDrive = new RobotDrive(drivetrainLeft1, drivetrainLeft2,							/* Robot drive consisting of those motors */
              drivetrainRight1, drivetrainRight2);
        
        drivetrainRobotDrive.setSafetyEnabled(false);													/* No safety? Thought this was on */
        drivetrainRobotDrive.setExpiration(0.1);														/* Set how long before safety watch dog stops drive train */
        drivetrainRobotDrive.setSensitivity(1);															/* Don't know what this does, there by default */
        drivetrainRobotDrive.setMaxOutput(1);															/* Set the max output speed to 100% */
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);					/* Set all motors to be reversed */
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);					
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);					
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);					

    }
}
