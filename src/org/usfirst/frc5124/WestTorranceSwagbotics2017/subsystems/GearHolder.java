package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearHolder extends Subsystem {
	
	private final DoubleSolenoid holderSolenoid = RobotMap.gearHolderHolderSolenoid;
	private final DoubleSolenoid forkliftSolenoid = RobotMap.gearHolderForkliftSolenoid;
	
    public void initDefaultCommand() {
    }
    
    public void holderOpen() {
    	holderSolenoid.set(Value.kForward);
    }
    
    public void holderClose() {
    	holderSolenoid.set(Value.kReverse);
    }
    
    public void forkliftUp() {
    	forkliftSolenoid.set(Value.kReverse);
    }
    
    public void forkliftDown() {
    	forkliftSolenoid.set(Value.kForward);
    }
}

