package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class JoystickPuppetry extends Command {

    public JoystickPuppetry() {
        requires(Robot.drivetrain);																			/* Uses the drivetrain subsystem */
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivetrain.robonaughtDrive(Robot.oi.getLeftYAxisSens(), Robot.oi.getRightXAxisSens()); 		/* Split arcade drive */
    }

    protected boolean isFinished() {
        return false;																						/* Default command, scheduler will handle this */
    }

    protected void end() {																					/* No need to stop the drive train, because this probably */
    }																										/* will never happen, since it theoretically only runs */
    																										/* during teleop and even if it is interrupted, the command */
    protected void interrupted() {																			/* that interrupts it will just run the drivetrain. */
    }																										/* This may run in auto if autonomousCommand is null */
}
