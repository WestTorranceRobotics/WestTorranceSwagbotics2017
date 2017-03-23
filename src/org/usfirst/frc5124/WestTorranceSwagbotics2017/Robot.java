package org.usfirst.frc5124.WestTorranceSwagbotics2017;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousGearBasicStraight;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousGearForBlueLeft;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousGearForBlueRight;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousGearForRedLeft;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousGearForRedRight;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousPassBaseLine;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems.*;

public class Robot extends IterativeRobot {

    Command autonomousCommand;
    Command gearClose;

    public static OI oi;
    public static Agitator agitator;
    public static GearHolder gearHolder;
    public static FuelInjector fuelInjector;
    public static Shooter shooter;
    public static Hanger hanger;
    public static Drivetrain drivetrain;
    public static GyroPIDHandler gyroPIDHandler;
    public static EncoderPIDHandler encoderPIDHandler;
    public static boolean button3IsPressed;
    public static boolean button6IsPressed;
    public static boolean button8IsPressed;

    public void robotInit() {
    	
    	RobotMap.init();
        
    	agitator = new Agitator();
        gearHolder = new GearHolder();
        fuelInjector = new FuelInjector();
        shooter = new Shooter();
        hanger = new Hanger();
        drivetrain = new Drivetrain();
        gyroPIDHandler = new GyroPIDHandler();
        encoderPIDHandler = new EncoderPIDHandler();
        
        oi = new OI();
        
       CameraServer.getInstance().startAutomaticCapture();
       
       /*                                      
                                                  ___  ____    _________  ____  ___ 
                                                 / _ \/ __ \  / ___/ __ \/ __ \/ _ \
                                                / // / /_/ / / (_ / /_/ / /_/ / // /
                                               /____/\____/  \___/\____/\____/____/                                           
                                                
                                    ___   __  ___   ____   ___  ___________   ___  __   _______  ___ 
                                   / _ | /  |/  /  /  _/  / _ \/  _/ __/ _ | / _ )/ /  / __/ _ \/__ \
                                  / __ |/ /|_/ /  _/ /   / // // /_\ \/ __ |/ _  / /__/ _// // / /__/
                                 /_/ |_/_/  /_/  /___/  /____/___/___/_/ |_/____/____/___/____/ (_)  
                                                                  
                 __________  __  ________  ________ ______  _  _______      __  _____________  ___   ___________ ________
 				/ ___/ _ \ \/ / /  _/ __/ /_  __/ // / __/ / |/ / __/ | /| / / / __/_  __/ _ \/ _ | /  _/ ___/ // /_  __/
               / (_ / __ |\  / _/ /_\ \    / / / _  / _/  /    / _/ | |/ |/ / _\ \  / / / , _/ __ |_/ // (_ / _  / / /   
               \___/_/ |_|/_/ /___/___/   /_/ /_//_/___/ /_/|_/___/ |__/|__/ /___/ /_/ /_/|_/_/ |_/___/\___/_//_/ /_/    
                                                                                                                                                                                                 
           				                    ___________ ________  _____  _____  _______
  							               / __/ __/ _ /_  __/ / / / _ \/  _/ |/ / ___/
 						                  / _// _// __ |/ / / /_/ / , _// //    / (_ / 
						                 /_/ /___/_/ |_/_/  \____/_/|_/___/_/|_/\___/  
                                             
         				                  __   ____  _  ____________   ___  ____  ____
      				                     / /  / __ \/ |/ / ___/ ___/  / _ )/ __ \/  _/
 	   				                    / /__/ /_/ /    / (_ / (_ /  / _  / /_/ // /  
      				                   /____/\____/_/|_/\___/\___/  /____/\____/___/
      				  
                                             ___  _________   _______  _______     
  			  	                            / _ )/  _/ ___/  / __/ _ \/ __/ _ \  
 		   	                               / _  |/ // (_ /  _\ \/ ___/ _// // /  
		  	                              /____/___/\___/  /___/_/  /___/____/  
        */
    }

    public void disabledInit(){
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        
        if(oi.getAuto4()) {
    		if(oi.getAuto3() && oi.getAuto1() && oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Base Line Red");
    		} else if(oi.getAuto3() && oi.getAuto1() && !oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Gear Left Red");
    		} else if(oi.getAuto3() && !oi.getAuto1() && oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Gear Right Red");
    		} else if(oi.getAuto3() && !oi.getAuto1() && !oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Gear Straight Red");
    		} else if(!oi.getAuto3() && oi.getAuto1() && oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Base Line Blue");
    		} else if(!oi.getAuto3() && oi.getAuto1() && !oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Gear Left BLue");
    		} else if(!oi.getAuto3() && !oi.getAuto1() && oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Gear Right Blue");
    		} else if(!oi.getAuto3() && !oi.getAuto1() && !oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Gear Straight Blue");
    		}
    	} else {
    		SmartDashboard.putString("Auto", "Null");
    	}
        
    }

    public void autonomousInit() {
    	drivetrain.setDrivetrainSpeed(1);
    	drivetrain.frontAndCenter();
    	
    	encoderPIDHandler.resetEncoders();
        
    	if(oi.getAuto4()) {
    		if(oi.getAuto3() && oi.getAuto1() && oi.getAuto2()) {
    			autonomousCommand = new AutonomousPassBaseLine();
    		} else if(oi.getAuto3() && oi.getAuto1() && !oi.getAuto2()) {
    			autonomousCommand = new AutonomousGearForRedLeft();
    		} else if(oi.getAuto3() && !oi.getAuto1() && oi.getAuto2()) {
    			autonomousCommand = new AutonomousGearForRedRight();
    		} else if(oi.getAuto3() && !oi.getAuto1() && !oi.getAuto2()) {
    			autonomousCommand = new AutonomousGearBasicStraight();
    		} else if(!oi.getAuto3() && oi.getAuto1() && oi.getAuto2()) {
    			autonomousCommand = new AutonomousPassBaseLine();
    		} else if(!oi.getAuto3() && oi.getAuto1() && !oi.getAuto2()) {
    			autonomousCommand = new AutonomousGearForBlueLeft();
    		} else if(!oi.getAuto3() && !oi.getAuto1() && oi.getAuto2()) {
    			autonomousCommand = new AutonomousGearForBlueRight();
    		} else if(!oi.getAuto3() && !oi.getAuto1() && !oi.getAuto2()) {
    			autonomousCommand = new AutonomousGearBasicStraight();
    		}
    	} else {
    		autonomousCommand = null;
    	}
    	
    	if (autonomousCommand != null) autonomousCommand.start();
   
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        Timer.delay(0.005);
    }

    public void teleopInit() {
    	Robot.gyroPIDHandler.disable();
    	Robot.encoderPIDHandler.disable();
    	Robot.drivetrain.resetAllOutputs();
        if (autonomousCommand != null) autonomousCommand.cancel();
        gearClose.start();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        if(oi.getDriver().getRawButton(5)) {
        	drivetrain.setSpeed(1);
        	drivetrain.fastTurn();
        	drivetrain.compressorOff();
        } else if(oi.getDriver().getRawButton(8)) {
        	drivetrain.setSpeed(0.45);
        	drivetrain.slowTurn();
        } else {
        	drivetrain.setSpeed(0.65);
        	drivetrain.slowTurn();
        	drivetrain.compressorOn();
        }
        
        if(oi.getDriver().getRawButton(6) && !button6IsPressed) {
        	button6IsPressed = true;
        	shooter.shootingSpeedLeft -= 200;
        	shooter.shootingSpeedCenter -= 200;
        	shooter.shootingSpeedRight -= 200;
        } else if(oi.getDriver().getRawButton(6)) {
        	button6IsPressed = false;
        }
        /*
        if(oi.getDriver().getRawButton(8) && !button8IsPressed) {
        	button8IsPressed = true;
        	shooter.shootingSpeedLeft += 200;
        	shooter.shootingSpeedCenter += 200;
        	shooter.shootingSpeedRight += 200;
        } else if(oi.getDriver().getRawButton(8)) {
        	button8IsPressed = false;
        }
        */
        
       
        
        
        if(oi.getDriver().getRawButton(3) && !button3IsPressed) {
        	button3IsPressed = true;
        	shooter.shootingSpeedLeft = -16200;
        	shooter.shootingSpeedCenter = -16600;
        	shooter.shootingSpeedRight = -16600;
        } else if(!oi.getDriver().getRawButton(3)) {
        	button3IsPressed = false;
        }
        
        Timer.delay(0.005);
        
        Robot.drivetrain.frontAndCenter();
        
        Robot.drivetrain.slowTurn();       
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
