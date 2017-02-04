package org.usfirst.frc5124.WestTorranceSwagbotics2017;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class OI {
    

	//joysticks
    public static Joystick driver;
    public Joystick operator;
    
    //joystickbuttons
    //ipublic JoystickButton button1;

    public OI() {

        //joysticks
    	driver = new Joystick(0);
        operator = new Joystick(1);
        
        //joystick buttons
        
        
        
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
   
}

