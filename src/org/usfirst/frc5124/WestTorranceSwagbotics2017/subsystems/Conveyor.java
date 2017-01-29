package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Conveyor extends Subsystem {

    private final VictorSP conveyorMotor = RobotMap.conveyorConveyorMotor;

    public void initDefaultCommand() {
    }
    
    public void up() {
    	conveyorMotor.set(1);
    }
    
    public void down() {
    	conveyorMotor.set(1);
    }
    
    public void stop() {
    	conveyorMotor.set(0);
    }
    
}

