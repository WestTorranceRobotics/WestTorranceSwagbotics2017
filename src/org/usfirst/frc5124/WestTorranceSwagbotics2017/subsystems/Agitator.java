package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Agitator extends Subsystem {
	
	private final VictorSP agitatorMotor = RobotMap.agitatorAgitatorMotor;

    public void initDefaultCommand() {
    }
    
    public void agitate() {
    	agitatorMotor.set(1);
    }
    
    public void stop() {
    	agitatorMotor.set(0);
    }
}

