package org.usfirst.frc5124.WestTorranceSwagbotics2017;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class OI {
    

	//joysticks
    public static Joystick driver;
    public Joystick operator;
    
    //joystickbuttons
    public JoystickButton operatorButton3;
    public JoystickButton operatorButton4;
    public JoystickButton operatorButton5;
    public JoystickButton operatorButton6;
    public JoystickButton operatorButton7;
    public JoystickButton operatorButton8;
    public JoystickButton operatorButton9;
    public JoystickButton operatorButton10;
    public JoystickButton operatorButton11;
    public JoystickButton operatorButton12;
    

    public OI() {

        //joysticks
    	driver = new Joystick(0);
        operator = new Joystick(1);
        
        //joystick buttons
        operatorButton4 = new JoystickButton(operator, 4);
        operatorButton4.whileHeld(new IntakeAndFuelInjectorHopper());
        
        operatorButton5 = new JoystickButton(operator, 5);
        operatorButton5.whileHeld(new IntakeAndFuelInjectorShooter());
        
        operatorButton6 = new JoystickButton(operator, 6);
        operatorButton6.whenPressed(new GearHolderSafelyOpen());
        
        operatorButton7 = new JoystickButton(operator, 7);
        operatorButton7.whenPressed(new GearHolderSafelyClose());
        
        operatorButton8 = new JoystickButton(operator, 8);
        operatorButton8.whenPressed(new GearHolderFunnelBackward());
        
        operatorButton9 = new JoystickButton(operator, 9);
        operatorButton9.whenPressed(new GearHolderFunnelForward());
        
        
        // SmartDashboard Buttons
        SmartDashboard.putData("Extend Pusher", new GearHolderExtendPusher());
        SmartDashboard.putData("Retract Pusher", new GearHolderRectractPusher());
        SmartDashboard.putData("Open GearHolder", new GearHolderOpen());
        SmartDashboard.putData("Close Gearholder", new GearHolderClose());
        SmartDashboard.putData("Forward", new GearHolderFunnelForward());
        SmartDashboard.putData("backward", new GearHolderFunnelBackward());
        
        SmartDashboard.putData("auto do", new GearHolderAutoRelase());
        
    }

    public Joystick getDriver() {
        return driver;
    }

    public Joystick getOperator() {
        return operator;
    }
    
    public double getLeftYAxis() {
    	if(Math.abs(driver.getRawAxis(1)) > 0.02) {
    		return driver.getRawAxis(1);
    	} else {
    		return 0;
    	}
    }
    
    public double getRightXAxis() {
    	if(Math.abs(driver.getRawAxis(4)) > 0.02) {
    		return driver.getRawAxis(4);
    	} else {
    		return 0;
    	}
    }
    
    public double getLeftYAxisSens() {
    	if(Math.abs(driver.getRawAxis(1)) > 0.02) {
    		return Math.pow(driver.getRawAxis(1), 3);
    	} else {
    		return 0;
    	}
    }
    
    public double getRightXAxisSens() {
    	if(Math.abs(driver.getRawAxis(4)) > 0.02) {
    		return Math.pow(driver.getRawAxis(4), 3);
    	} else {
    		return 0;
    	}
    }
    
    public void vibrateDriver() {
    	driver.setRumble(GenericHID.RumbleType.kLeftRumble, 0.5);
   		driver.setRumble(GenericHID.RumbleType.kRightRumble, 1);
    }
    	     
    public void stopVibrate() {
    	driver.setRumble(GenericHID.RumbleType.kLeftRumble, 0);
    	driver.setRumble(GenericHID.RumbleType.kRightRumble, 0);
    }
   
}

