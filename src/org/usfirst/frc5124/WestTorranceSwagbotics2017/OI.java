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
    public JoystickButton driverButton4;
    public JoystickButton driverButton7;
    
    
    public JoystickButton operatorButton2;
    public JoystickButton operatorButton2copy;
    public JoystickButton operatorButton3;
    public JoystickButton operatorButton4;
    public JoystickButton operatorButton4copy;
    public JoystickButton operatorButton5;
    public JoystickButton operatorButton5copy;
    public JoystickButton operatorButton6;
    public JoystickButton operatorButton7;
    public JoystickButton operatorButton8;
    public JoystickButton operatorButton9;
    public JoystickButton operatorButton10;
    

    public OI() {

        //joysticks
    	driver = new Joystick(0);
        operator = new Joystick(1);
        
        //joystick buttons
        driverButton4 = new JoystickButton(driver, 4);
        driverButton4.whenPressed(new DrivetrainReverseFront());
        
        driverButton7 = new JoystickButton(driver, 7);
        driverButton7.whileHeld(new ShooterTeleopShoot());
        
        operatorButton2 = new JoystickButton(operator, 2);
        operatorButton2.whileHeld(new IntakeExhaust());
        
        operatorButton2copy = new JoystickButton(operator, 2);
        operatorButton2copy.whileHeld(new FuelInjectorInjectFuel());
        
        operatorButton3 = new JoystickButton(operator, 3);
        operatorButton3.whileHeld(new HangerHang());
        
        operatorButton4 = new JoystickButton(operator, 4);
        operatorButton4.whileHeld(new IntakeIntake());
        
        operatorButton4copy = new JoystickButton(operator, 4);
        operatorButton4copy.whileHeld(new FuelInjectorExtractFuel());
        
        operatorButton5 = new JoystickButton(operator, 5);
        operatorButton5.whileHeld(new IntakeIntake());
        
        operatorButton5copy = new JoystickButton(operator, 5);
        operatorButton5copy.whileHeld(new FuelInjectorInjectFuel());
        
        operatorButton6 = new JoystickButton(operator, 6);
        operatorButton6.whenPressed(new GearHolderSafelyOpen());
        
        operatorButton7 = new JoystickButton(operator, 7);
        operatorButton7.whenPressed(new GearHolderSafelyClose());
        
        operatorButton8 = new JoystickButton(operator, 8);
        operatorButton8.whenPressed(new GearHolderFunnelBackward());
        
        operatorButton9 = new JoystickButton(operator, 9);
        operatorButton9.whenPressed(new GearHolderFunnelForward());
        
        operatorButton10= new JoystickButton(operator, 10);
        operatorButton10.whileHeld(new AgitatorAgitate());
        
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
    	if(Math.abs(driver.getRawAxis(2)) > 0.02) {
    		return driver.getRawAxis(2);
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
    	if(Math.abs(driver.getRawAxis(2)) > 0.02) {
    		return Math.pow(driver.getRawAxis(2), 3);
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

