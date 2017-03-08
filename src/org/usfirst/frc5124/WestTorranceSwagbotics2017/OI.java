package org.usfirst.frc5124.WestTorranceSwagbotics2017;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.*;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    
	//joysticks
    public static Joystick driver;
    public Joystick operator;
    
    // Driver joystickbuttons
    public JoystickButton driverButton4;
    public JoystickButton driverButton5;
    public JoystickButton driverButton6;
    public JoystickButton driverButton7;
    
    //Operator Joystickbuttons
    public JoystickButton operatorButton6;
    public JoystickButton operatorButton7;
    public JoystickButton operatorButton8;
    public JoystickButton operatorButton9;
    public JoystickButton operatorButton10;
    public JoystickButton operatorButton11;
    public JoystickButton operatorButton12;
    public JoystickButton operatorButton13;
    public JoystickButton operatorButton14;
    public JoystickButton operatorButton15;

    public OI() {

        //joysticks
    	driver = new Joystick(0);
        operator = new Joystick(1);
        
        // driver joystick buttons
        driverButton5 = new JoystickButton(driver, 5);//toggle switch
        driverButton5.whenPressed(new GearHolderBackboardBack());
        
        driverButton6 = new JoystickButton(driver, 6);//toggle switch
        driverButton6.whenPressed(new GearHolderBackboardForward());
        
        driverButton7 = new JoystickButton(driver, 7);
        driverButton7.whileHeld(new ShooterTeleopShoot());
        
        //operator joystick buttons
        operatorButton6 = new JoystickButton(operator, 6);
        operatorButton6.whileHeld(new HangerHang());
        
        operatorButton8 = new JoystickButton(operator, 8);
        operatorButton8.whileHeld(new AgitatorReverse());
        
        operatorButton9 = new JoystickButton(operator, 9);
        operatorButton9.whileHeld(new AgitatorAgitate());
        
        operatorButton10 = new JoystickButton(operator, 10);
        operatorButton10.whileHeld(new FuelInjectorIntake());
        
        operatorButton11 = new JoystickButton(operator, 11);
        operatorButton11.whileHeld(new FuelInjectorConveyorToShooters());
        
        operatorButton12 = new JoystickButton(operator, 12);
        operatorButton12.whenPressed(new GearHolderFunnelForward());
        operatorButton12.whenReleased(new GearHolderFunnelBackward());
        
        operatorButton13 = new JoystickButton(operator, 13);
        operatorButton13.whileHeld(new FuelInjectorExhaust());
                
        operatorButton14 = new JoystickButton(operator, 14);
        operatorButton14.whenPressed(new GearHolderAutoRelase());
        
        operatorButton15 = new JoystickButton(operator, 15);
        operatorButton15.whenPressed(new GearHolderFunnelandBackboardForward());
        operatorButton15.whenReleased(new GearHolderFunnelandBackboardBack());   
    }

    public Joystick getDriver() {
        return driver;
    }

    public Joystick getOperator() {
        return operator;
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
}

