package org.usfirst.frc5124.WestTorranceSwagbotics2017;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.GearHolderCloseAndRaise;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.GearHolderOpenAndLower;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	//joysticks
    public static Joystick driver;
    public Joystick operator;
 
    //joystickbuttons
    
    // Driver joystickbuttons
    public JoystickButton driverButton2;
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
    	
        //Joysticks
    	driver = new Joystick(0);
        operator = new Joystick(1);
        
        ////////////////////
        ///DRIVER BUTTONS///
        ////////////////////       
        
        //Change the front of the robot (obsolete?)
        driverButton2 = new JoystickButton(driver, 2);
        driverButton2.whenPressed(new DrivetrainReverseFront());
        
        //Turn on shooters with PID
        driverButton7 = new JoystickButton(driver, 7);
        driverButton7.whileHeld(new ShooterTeleopShoot());
        
        //////////////////////
        ///OPERATOR BUTTONS///
        //////////////////////
        
        //Switch, raise and grab gear when flipped up, lower and drop gear when flipped down
        operatorButton6 = new JoystickButton(operator, 6);
		operatorButton6.whenPressed(new GearHolderCloseAndRaise());
		operatorButton6.whenReleased(new GearHolderOpenAndLower());
        
		//Agitate a certain direction
        operatorButton8 = new JoystickButton(operator, 8);
        operatorButton8.whileHeld(new AgitatorReverse());
        
        //Agitate in the other direction
        operatorButton9 = new JoystickButton(operator, 9);
        operatorButton9.whileHeld(new AgitatorAgitate());
        
        //Intake to hopper
        operatorButton10 = new JoystickButton(operator, 10);
        operatorButton10.whileHeld(new FuelInjectorIntake());
        
        //Convey to shooters
        operatorButton11 = new JoystickButton(operator, 11);
        operatorButton11.whileHeld(new FuelInjectorConveyorToShooters());
        
        //Grab Gear
        operatorButton12 = new JoystickButton(operator, 12);
        operatorButton12.whenPressed(new GearHolderCloseGearHolder());
        
        //Outtake to ground
        operatorButton13 = new JoystickButton(operator, 13);
        operatorButton13.whileHeld(new FuelInjectorExhaust());
        
        //Climb and retract gear holder
        operatorButton14 = new JoystickButton(operator, 14);
        operatorButton14.whenPressed(new GearHolderForkliftUp());
        operatorButton14.whileHeld(new HangerHang());
        
        //Let go of gear
        operatorButton15 = new JoystickButton(operator, 15);
        operatorButton15.whenPressed(new GearHolderOpenGearHolder());

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

    public boolean getAuto1() {
    	return getOperator().getRawButton(1);
    }
    	
    public boolean getAuto2() {
    	return getOperator().getRawButton(2);
    }
    
    public boolean getAuto3() {
    	return getOperator().getRawButton(3);
    }
    
    public boolean getAuto4() {
    	return getOperator().getRawButton(4);
    }
    
    public boolean getAuto7() {
    	return getOperator().getRawButton(7);
    }
}

