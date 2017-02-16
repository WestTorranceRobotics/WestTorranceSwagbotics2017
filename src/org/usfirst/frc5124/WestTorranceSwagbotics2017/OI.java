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
    public JoystickButton operatorButton11;
    public JoystickButton operatorButton12;

    public OI() {

        //joysticks
    	driver = new Joystick(0);
        operator = new Joystick(1);
        
        //joystick buttons
        operatorButton11 = new JoystickButton(operator, 11);
        operatorButton11.whenPressed(new GearHolderFunnelBackward());
        
        operatorButton12 = new JoystickButton(operator, 12);
        operatorButton12.whenPressed(new GearHolderFunnelForward());
        
        
        // SmartDashboard Buttons
        SmartDashboard.putData("Extend Pusher", new GearHolderExtendPusher());
        SmartDashboard.putData("Retract Pusher", new GearHolderRectractPusher());
        SmartDashboard.putData("Open", new GearHolderOpen());
        SmartDashboard.putData("Close", new GearHolderClose());
        
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

