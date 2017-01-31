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
    private final DigitalInput limitSwitch = RobotMap.gearHolderLimitSwitch;
    
    public static boolean switchIsPressed = false;

    public void initDefaultCommand() {
    	setDefaultCommand(new GearHolderBraceForImpact());
    }
    
    public void holderGrab() {
    	holderSolenoid.set(Value.kForward);
    }
    
    public void holderLetItGo() {
    	holderSolenoid.set(Value.kReverse);
    }
    
    public void pusherExtend() {
    	pusherSolenoid.set(Value.kForward);
    }
    
    public void pusherRetract() {
    	pusherSolenoid.set(Value.kReverse);
    }
    
    public boolean getLimitSwitch() {
    	return limitSwitch.get();
    }
    
}

