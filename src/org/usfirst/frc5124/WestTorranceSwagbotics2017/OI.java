package org.usfirst.frc5124.WestTorranceSwagbotics2017;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	//Joysticks
    public static Joystick driver;
    public Joystick operator;
    
    // Driver Joystick Buttons
    public JoystickButton driverButton2;
    public JoystickButton driverButton7;
    
    //Operator Joystick Buttons
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
    	
    	///////////////
    	///JOYSTICKS///
        ///////////////
    	
    	driver = new Joystick(0);												/* First Driver on the 0th slot */
    	
        operator = new Joystick(1);												/* Second Driver on the 1st slot */
        
        
        ////////////////////
        ///DRIVER BUTTONS///
        ////////////////////       
        
       
        driverButton7 = new JoystickButton(driver, 7);							/* 7th button on first driver */
        driverButton7.whileHeld(new ShooterTeleopShoot());						/* While button is held, run shooters on PID loop */
        
        //////////////////////
        ///OPERATOR BUTTONS///
        //////////////////////
        
        operatorButton6 = new JoystickButton(operator, 6);						/* 6th button on second driver */		
		operatorButton6.whenPressed(new GearHolderCloseAndRaise());				/* When switch is flipped up, only go up and grab once */
		operatorButton6.whenReleased(new GearHolderOpenAndLower());				/* When flipped down, only go down and let go once */
        
        operatorButton8 = new JoystickButton(operator, 8);						/* 8th button on second driver */
        operatorButton8.whileHeld(new AgitatorReverse());						/* While switch is flipped, run agitator one way */
        
        operatorButton9 = new JoystickButton(operator, 9);						/* 9th button on second driver */
        operatorButton9.whileHeld(new AgitatorAgitate());						/* While switch is flipped, run agitator the other way */
        
        operatorButton10 = new JoystickButton(operator, 10);					/* 10th button on second driver */
        operatorButton10.whileHeld(new FuelInjectorIntake());					/* While button is held, intake to hopper */
        
        operatorButton11 = new JoystickButton(operator, 11);					/* 11th button on second driver */
        operatorButton11.whileHeld(new FuelInjectorConveyorToShooters());		/* While button is held, convey balls to shooters */
        
        operatorButton12 = new JoystickButton(operator, 12);					/* 12th button on second driver */
        operatorButton12.whenPressed(new GearHolderCloseGearHolder());			/* When button is first pressed, grab gear */
        
        operatorButton13 = new JoystickButton(operator, 13);					/* 13th button on second driver */
        operatorButton13.whileHeld(new FuelInjectorExhaust());					/* When button is held, outtake balls out of robot */
        
        operatorButton14 = new JoystickButton(operator, 14);					/* 14th button on second driver */
        operatorButton14.whenPressed(new GearHolderCloseAndRaise());				/* When button is first pressed, raise gear holder to stay inside size constraints */
        operatorButton14.whileHeld(new HangerHang());							/* While button is held, run hanger */
        
        operatorButton15 = new JoystickButton(operator, 15);					/* 15th button on second driver */
        operatorButton15.whenPressed(new GearHolderOpenGearHolder());			/* When button is first pressed, let go of gear */
        
     
        

    }
        
    public Joystick getDriver() {												/* Return the first driver */
        return driver;
    }

    public Joystick getOperator() {												/* Return the second driver */
        return operator;
    }
    
    public double getLeftYAxisSens() {											/* Return the left Y axis of first driver fit to a cubic curve, with a deadzone */
    	if(Math.abs(driver.getRawAxis(1)) > 0.02) {
    		return Math.pow(driver.getRawAxis(1), 3);
    	} else {
    		return 0;
    	}
    }
    
    public double getRightXAxisSens() {											/* Return the right X axis of first driver fit to a cubic curve, with a deadzone */
    	if(Math.abs(driver.getRawAxis(2)) > 0.02) {
    		return Math.pow(driver.getRawAxis(2), 3);
    	} else {
    		return 0;
    	}
    }

    public boolean getAuto1() {													/* Return the state of the first switch for determining auto */
    	return getOperator().getRawButton(1);
    }
    	
    public boolean getAuto2() {													/* Return the state of the second switch for determining auto */
    	return getOperator().getRawButton(2);
    }
    
    public boolean getAuto3() {													/* Return the state of the third switch for determining auto */
    	return getOperator().getRawButton(3);
    }
    
    public boolean getAuto4() {													/* Return the state of the fourth switch for determining auto */
    	return getOperator().getRawButton(4);
    }
    
    public boolean getAuto7() {													/* Return the state of the fifth switch for determining auto */
    	return getOperator().getRawButton(7);
    }
}

