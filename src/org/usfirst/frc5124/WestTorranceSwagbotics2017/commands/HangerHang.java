package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class HangerHang extends Command {

    public HangerHang() {
        requires(Robot.hanger);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.hanger.setHangerPower(-0.5);
    }

    protected boolean isFinished() {
        //return Robot.hanger.getCurrentLoad() > 20 || Robot.oi.getOperator().getRawButton(3);
    	return false;
    }

    protected void end() {
    	Robot.hanger.stop();
    }

    protected void interrupted() {
    	end();
    }
}
