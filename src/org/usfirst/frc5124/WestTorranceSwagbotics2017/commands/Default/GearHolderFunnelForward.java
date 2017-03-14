package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GearHolderFunnelForward extends Command {

    public GearHolderFunnelForward() {
        requires(Robot.gearHolder);
    }
    
    protected void initialize() {
    	Robot.gearHolder.funnelForward();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
