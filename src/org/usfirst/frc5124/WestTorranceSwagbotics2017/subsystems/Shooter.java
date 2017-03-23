package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

    private CANTalon leftShootermotor = RobotMap.shooterLeftShooterMotor;
    private CANTalon centerShootermotor = RobotMap.shooterCenterShooterMotor;
    private CANTalon rightShootermotor = RobotMap.shooterRightShooterMotor;
    
	public int shootingSpeedLeft = -16200;
	public int shootingSpeedCenter = -16600;
	public int shootingSpeedRight = -16600;
	
    public void initDefaultCommand() {
    }
    
    public void setLeftShooter(double speed) {
    	leftShootermotor.set(speed);
    }
    
    public void setCenterShooter(double speed) {
    	centerShootermotor.set(speed);
    }
    
    public void setRightShooter(double speed) {
    	rightShootermotor.set(speed);
    }
        
    public void setControlMode(int mode) {
    	leftShootermotor.setControlMode(mode);
    	centerShootermotor.setControlMode(mode);
    	rightShootermotor.setControlMode(mode);
    }
    
    public double getLeftVelocity() {
    	return leftShootermotor.getEncVelocity();
    }
    
    public double getCenterVelocity() {
    	return centerShootermotor.getEncVelocity();
    }
    
    public double getRightVelocity() {
    	return rightShootermotor.getEncVelocity();
    }
    
    public int getShootingSpeedLeft() {
    	return shootingSpeedLeft;
    }
    
    public int getShootingSpeedCenter(){
    	return shootingSpeedCenter;
    }
    
    public int getShootingSpeedRight(){
    	return shootingSpeedRight;
    }
    
    public double getLeftCurrent() {
    	return leftShootermotor.getOutputCurrent();
    }
    
    public double getCenterCurrent() {
    	return centerShootermotor.getOutputCurrent();
    }
    
    public double getRightCurrent() {
    	return rightShootermotor.getOutputCurrent();
    }
    
    public void setBrakeFalse() {
    	leftShootermotor.enableBrakeMode(false);
    	centerShootermotor.enableBrakeMode(false);
    	rightShootermotor.enableBrakeMode(false);
    }
    
    
}

