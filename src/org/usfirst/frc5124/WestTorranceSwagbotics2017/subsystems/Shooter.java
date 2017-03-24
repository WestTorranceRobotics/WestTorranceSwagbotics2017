package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

    private CANTalon leftShootermotor = RobotMap.shooterLeftShooterMotor;			/* the shooter motors */
    private CANTalon centerShootermotor = RobotMap.shooterCenterShooterMotor;
    private CANTalon rightShootermotor = RobotMap.shooterRightShooterMotor;
    
	public int shootingSpeedLeft = -16200;											/* Each shooter's velocity setpoint */
	public int shootingSpeedCenter = -16600;
	public int shootingSpeedRight = -16600;
	
    public void initDefaultCommand() {
    }
    
    public void setLeftShooter(double speed) {										/* these next three methods set their respective motor's speed or setpoint */
    	leftShootermotor.set(speed);
    }
    
    public void setCenterShooter(double speed) {
    	centerShootermotor.set(speed);
    }
    
    public void setRightShooter(double speed) {
    	rightShootermotor.set(speed);
    }
        
    public void setControlMode(int mode) {											/* set the control mode of all three mtotors */
    	leftShootermotor.setControlMode(mode);
    	centerShootermotor.setControlMode(mode);
    	rightShootermotor.setControlMode(mode);
    }
    
    public double getLeftVelocity() {												/* The next three methods are getters for their respective motor's velocity */
    	return leftShootermotor.getEncVelocity();
    }
    
    public double getCenterVelocity() {
    	return centerShootermotor.getEncVelocity();
    }
    
    public double getRightVelocity() {
    	return rightShootermotor.getEncVelocity();
    }
    
    public int getShootingSpeedLeft() {												/* The next three methods are getters for the respective motor's velocity setpoint */
    	return shootingSpeedLeft;
    }
    
    public int getShootingSpeedCenter(){
    	return shootingSpeedCenter;
    }
    
    public int getShootingSpeedRight(){
    	return shootingSpeedRight;
    }
    
    public double getLeftCurrent() {												/* These three methods are getters for the respective motor's current load */
    	return leftShootermotor.getOutputCurrent();									/* was going to use to make graphs to tune PID but couldn't get writing */
    }																				/* numbers to text files to work so it was all for naught */
    
    public double getCenterCurrent() {
    	return centerShootermotor.getOutputCurrent();
    }
    
    public double getRightCurrent() {
    	return rightShootermotor.getOutputCurrent();
    }
    
    public void setBrakeFalse() {													/* Set each motor to coast mode */
    	leftShootermotor.enableBrakeMode(false);
    	centerShootermotor.enableBrakeMode(false);
    	rightShootermotor.enableBrakeMode(false);
    }
    
    
}

