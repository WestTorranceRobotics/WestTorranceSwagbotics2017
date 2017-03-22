package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FuelInjector extends Subsystem {

    private final VictorSP conveyorMotor = RobotMap.fuelInjectorConveyorMotor;
    
    private final VictorSP intakeMotor = RobotMap.fuelInjectorIntakeMotor;
    
    public void initDefaultCommand() {
    }
    
    public void inject() {
    	conveyorMotor.set(0.5);
    }
    
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

