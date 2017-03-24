package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearHolder extends Subsystem {
	
	private final DoubleSolenoid holderSolenoid = RobotMap.gearHolderHolderSolenoid;			/* Two solenoid valves */
	private final DoubleSolenoid forkliftSolenoid = RobotMap.gearHolderForkliftSolenoid;
	
    public void initDefaultCommand() {
    }
    
    public void holderOpen() {																	/* Same sentiment as written in the Fuel Injector Subsystem */
    	holderSolenoid.set(Value.kForward);														/* Each method sets a solenoid valve to be open in one direction */
    }																							/* or the other */
    
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

