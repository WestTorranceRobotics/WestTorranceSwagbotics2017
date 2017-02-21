package org.usfirst.frc5124.WestTorranceSwagbotics2017;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousBigShoots;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousTopTier;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.GearHolderSafelyClose;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.ShooterStartShooting;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems.*;

public class Robot extends IterativeRobot {
	
	public int index = 0;
	public Timer autoTimer = new Timer();
	
	File f;
	BufferedWriter bw;
	FileWriter fw;

    Command autonomousCommand;

    public static OI oi;
    public static Agitator agitator;
    public static GearHolder gearHolder;
    public static FuelInjector fuelInjector;
    public static Intake intake;
    public static Shooter shooter;
    public static Hanger hanger;
    public static Drivetrain drivetrain;

    public void robotInit() {
    	
    	RobotMap.init();
        
    	agitator = new Agitator();
        gearHolder = new GearHolder();
        fuelInjector = new FuelInjector();
        intake = new Intake();
        shooter = new Shooter();
        hanger = new Hanger();
        drivetrain = new Drivetrain();
        
        oi = new OI();
        
        //autonomousCommand = new AutonomousTestDrive();
        autonomousCommand = new AutonomousBigShoots();
        //autonomousCommand = new ShooterStartShooting();
        
        CameraServer.getInstance().startAutomaticCapture();
        
        try{ 
        	
        	f = new File("/home/lvuser/Output.txt");
        	
        	if(!f.exists()) {
        		f.createNewFile();
        	}
        	
        	fw = new FileWriter(f);
        	
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        bw = new BufferedWriter(fw);
        
    }

    public void disabledInit(){
    	//RobotMap.drivetrainLeftEncoder.reset();
    	autoTimer.stop();
    	autoTimer.reset();
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	//Scheduler.getInstance().add(new GearHolderSafelyClose());
    	Robot.drivetrain.frontAndCenter();
        if (autonomousCommand != null) autonomousCommand.start();
        autoTimer.start();
        index = 0;
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
       
        try {
			bw.write(autoTimer.get() + "," + Robot.shooter.getLeftCurrent() + "," + Robot.shooter.getLeftVelocity() + ":");
		} catch (IOException e) {
			e.printStackTrace();
		}
        	
        
        
        Timer.delay(0.005);
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        Robot.drivetrain.frontAndCenter();
        Scheduler.getInstance().add(new GearHolderSafelyClose());
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        if(Robot.oi.getDriver().getRawButton(5)) {
        	Robot.drivetrain.setDrivetrainSpeed(1);
        } else {
        	Robot.drivetrain.setDrivetrainSpeed(0.5);
        }
        
       /* if(Robot.gearHolder.getLimitSwitch()) {
        	oi.vibrateDriver();
        } else {
        	oi.stopVibrate();
        }*/
        
      //  double hanger = oi.getOperator().getY();
        
       // Robot.hanger.setHangerPower(hanger);
        /*
        double power = Math.abs((oi.getOperator().getRawAxis(2) - 1)/-2);
        if (power > .1) {
        	shooter.setAllShooters(-power);
        	SmartDashboard.putNumber("pr", power);
        }
        else {
        	shooter.setAllShooters(0);
        	SmartDashboard.putNumber("pr", power);
        }*/
        
        Timer.delay(0.005);
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
