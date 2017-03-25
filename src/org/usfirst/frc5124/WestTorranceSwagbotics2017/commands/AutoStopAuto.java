package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStopAuto extends CommandGroup {

    public AutoStopAuto() {
        addSequential(new ShooterStopShooting());
        addSequential(new FuelInjectorStopAuto());
        addSequential(new AgitatorStop());
    }
}
