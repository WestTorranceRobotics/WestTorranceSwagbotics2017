package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hanger extends Subsystem {

    private final VictorSP hangerMotor = RobotMap.hangerHangerMotor;

    public void initDefaultCommand() {
    }
    
    public void setHangerPower(double power) {
    	hangerMotor.set(power);
    }
    
    public void stop() {
    	hangerMotor.set(0);
    }
    /*
    public double getCurrentLoad() {
    	return hangerMotor.getOutputCurrent();
    }*/
}
