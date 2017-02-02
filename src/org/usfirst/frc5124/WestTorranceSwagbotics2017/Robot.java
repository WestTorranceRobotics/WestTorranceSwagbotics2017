package org.usfirst.frc5124.WestTorranceSwagbotics2017;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutoDrive;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems.*;


public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    public static GearHolder gearHolder;
    public static Conveyor conveyor;
    public static Intake intake;
    public static Shooter shooter;
    public static Hanger hanger;
    public static Drivetrain drivetrain;
    public static GyroPIDHandler gyroPIDHandler;
    public static EncoderPIDHandler encoderPIDHandler;

    public void robotInit() {
    	
    	RobotMap.init();
        
        gearHolder = new GearHolder();
        conveyor = new Conveyor();
        intake = new Intake();
        shooter = new Shooter();
        hanger = new Hanger();
        drivetrain = new Drivetrain();
        gyroPIDHandler = new GyroPIDHandler();
        encoderPIDHandler = new EncoderPIDHandler();
        
        oi = new OI();
        
        autonomousCommand = new AutoDrive(260, 0);

    }

    public void disabledInit(){
    	Robot.gearHolder.pusherRetract();
    	Robot.gearHolder.holderGrab();
    	RobotMap.drivetrainEncoder.reset();
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Enc", RobotMap.drivetrainEncoder.get());
        Timer.delay(0.005);
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        Timer.delay(0.005);
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
