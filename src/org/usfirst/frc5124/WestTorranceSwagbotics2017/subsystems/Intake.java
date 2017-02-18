package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

    private final VictorSP intakeMotor = RobotMap.intakeIntakeMotor;

    public void initDefaultCommand() {
    }
    
    public void intake() {
    	intakeMotor.set(-1);
    }
    
    public void exhaust() {
    	intakeMotor.set(1);
    }
    
    public void stop() {
    	intakeMotor.set(0);
    }
    
    public void intakeSlow() {
    	intakeMotor.set(-0.5);
    }
    
}

