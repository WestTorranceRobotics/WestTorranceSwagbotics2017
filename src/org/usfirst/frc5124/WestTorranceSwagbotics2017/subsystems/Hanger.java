package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hanger extends Subsystem {

    private final CANTalon hangerMotor = RobotMap.hangerHangerMotor; 		/* a motor */

    public void initDefaultCommand() {
    }
    
    public void setHangerPower(double power) {								/* Set power to the hanger motor */
    	hangerMotor.set(power);
    }
    
    public void stop() {													/* Stop the hanger motor */
    	hangerMotor.set(0);
    }
    
    public double getCurrentLoad() {										/* Get the current going to the motor. Could've been used to do something cool, but */
    	return hangerMotor.getOutputCurrent();								/* they changed their minds and said they didn't need it. Tool lazy to delete this */
    }
    
}
