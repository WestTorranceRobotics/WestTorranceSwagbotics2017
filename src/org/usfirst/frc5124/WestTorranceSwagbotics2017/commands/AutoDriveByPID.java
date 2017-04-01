package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveByPID extends Command {
	
	public double distance = 0;

    public AutoDriveByPID(double distance) {
        requires(Robot.drivetrain);																	/* Uses the drivetrain */		
        this.distance = distance;																	/* Pass distance to global distance (inches) */
        //setTimeout(50);
    }
    
    public AutoDriveByPID(double distance, double emergencyTimeout) {
    	this(distance);
    	//setTimeout(emergencyTimeout);
    }
    
    protected void initialize() {
    	Robot.drivetrain.resetAllOutputs();															/* Reset PID outputs */
    	Robot.encoderPIDHandler.setSetpoint(Robot.encoderPIDHandler.getLeft() + distance);			/* Set the setpoint to where we are + where we wanna go */				
    	Robot.encoderPIDHandler.enable();															/* Enable the PID */
    }

    protected void execute() {
    	Robot.drivetrain.setPIDOutputs();															/* Use the PID outputs to set motor powers to the drivetrain */
    }

    protected boolean isFinished() {
        return Robot.encoderPIDHandler.onTarget();/* || isTimedOut();*/											/* Stop when we're there */
    }

    protected void end() {
    	Robot.encoderPIDHandler.disable();															/* Turn off PID, stop the drivetrain, and reset PID outputs */
    	Robot.drivetrain.stop();
    	Robot.drivetrain.resetAllOutputs();
    }

    protected void interrupted() {
    	end();
    }
}
