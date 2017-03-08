package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoShoot extends CommandGroup {

    public AutoShoot(double pow) {
    
        addSequential(new ShooterStartShooting());
        addSequential(new Wait(pow));
        addSequential(new ShooterStopShooting());
    }
}
