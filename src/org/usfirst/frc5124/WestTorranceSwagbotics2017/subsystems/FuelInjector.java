package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;


public class FuelInjector extends Subsystem {

    private final VictorSP fuelInjectorMotor = RobotMap.fuelInjectorFuelInjectorMotor;

    public void initDefaultCommand() {
    }
    
    public void inject() {
    	fuelInjectorMotor.set(0.5);
    }
    
    public void extract() {
    	fuelInjectorMotor.set(-1);
    }
    
    public void stop() {
    	fuelInjectorMotor.set(0);
    }
    
}
