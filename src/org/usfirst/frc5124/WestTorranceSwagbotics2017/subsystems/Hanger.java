package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hanger extends Subsystem {

    private final CANTalon hangerMotor = RobotMap.hangerHangerMotor;
    
    private int direction = 1;

    public void initDefaultCommand() {
    }
    
    public void setHangerPower(double power) {
    	hangerMotor.set(power);
    }
    
    public void magicHang() {
    	hangerMotor.set(0.3 * direction);
    }
    
    public void stop() {
    	hangerMotor.set(0);
    }
    
    public double getCurrentLoad() {
    	return hangerMotor.getOutputCurrent();
    }
    
    public int getDirection() {
    	return direction;
    }
    
    public void changeDirection (int newDirection) {
    	direction = newDirection;
    }
}
