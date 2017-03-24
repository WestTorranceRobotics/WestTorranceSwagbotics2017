package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FuelInjector extends Subsystem {

    private final VictorSP conveyorMotor = RobotMap.fuelInjectorConveyorMotor;  	/* Two motors boi */
    private final VictorSP intakeMotor = RobotMap.fuelInjectorIntakeMotor;
    
    public void initDefaultCommand() {
    }
    
    public void inject() {															/* I'm not going to explain each of these at this point. I've been doing this */
    	conveyorMotor.set(0.5);														/* for a few hours now and this is getting annoying. Each method just sets a */
    }																				/* power to a motor */
    
    public void extract() {
    	conveyorMotor.set(-1);
    }
    
    public void stop() {
    	conveyorMotor.set(0);
    	intakeMotor.set(0);
    }
        
    public void intake() {
    	intakeMotor.set(-1);
    }
    
    public void exhaust() {
    	intakeMotor.set(1);
    }
        
    public void intakeSlow() {
    	intakeMotor.set(-0.5);
    }
}

