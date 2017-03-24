package org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Agitator extends Subsystem {
	
	private final VictorSP agitatorMotor = RobotMap.agitatorAgitatorMotor;		/* Just one motor for spinning the surf board */

    public void initDefaultCommand() {
    }
    
    public void agitate() {														/* Run the agitator one way */
    	agitatorMotor.set(1);
    }
    
    public void reverse() {														/* Run the agitator the other way */
    	agitatorMotor.set(-1);
    }
    
    public void stop() {														/* Stop the agitator */
    	agitatorMotor.set(0);
    }
}

