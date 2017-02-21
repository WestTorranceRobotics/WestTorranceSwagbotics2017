package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.GearHolderBraceForImpact;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearHolder extends Subsystem {

    private final DoubleSolenoid holderSolenoid = RobotMap.gearHolderHolderSolenoid;
    private final DoubleSolenoid pusherSolenoid = RobotMap.gearHolderPusherSolenoid;
    private final DoubleSolenoid funnelSolenoid = RobotMap.gearHolderFunnelSolenoid;
    private final DoubleSolenoid backboardSolenoid = RobotMap.gearHolderBackboardSolenoid;
    private final DigitalInput limitSwitch = RobotMap.gearHolderLimitSwitch;
    
    public boolean switchIsPressed = false;
    public boolean funnelIsForward = false;
    public boolean backboardIsForward = false;

    public void initDefaultCommand() {
    	setDefaultCommand(new GearHolderBraceForImpact());
    }
    
    public void holderGrab() {
    	holderSolenoid.set(Value.kReverse);
    }
    
    public void holderLetItGo() {
    	holderSolenoid.set(Value.kForward);
    }
    
    public void pusherExtend() {
    	pusherSolenoid.set(Value.kForward);
    }
    
    public void pusherRetract() {
    	pusherSolenoid.set(Value.kReverse);
    }
    
    public void funnelForward() {
    	funnelSolenoid.set(Value.kForward);
    	funnelIsForward = true;
    }
    
    public void funnelBackward() {
    	funnelSolenoid.set(Value.kReverse);
    	funnelIsForward = false;
    }
    
    public void backBoardBack() {
    	backboardSolenoid.set(Value.kReverse);
    	backboardIsForward = false;
    }
    
    public void backBoardForward() {
    	backboardSolenoid.set(Value.kForward);
    	backboardIsForward = true;
    }
    
    public boolean getLimitSwitch() {
    	return !limitSwitch.get();
    }
    
    public boolean getFunnelForward() {
    	return funnelIsForward;
    }
    
    public boolean getBackboardForward() {
    	return backboardIsForward;
    }
    
    public void checkPosition() {
    	if(funnelSolenoid.get() == Value.kForward) {
    		funnelIsForward = true;
    	} else {
    		funnelIsForward = false;
    	}
    	
    	if(backboardSolenoid.get() == Value.kForward) {
    		backboardIsForward = true;
    	} else {
    		backboardIsForward = false;
    	}
    }
    
}

