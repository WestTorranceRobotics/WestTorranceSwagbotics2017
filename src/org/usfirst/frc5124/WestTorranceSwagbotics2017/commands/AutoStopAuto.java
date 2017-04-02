package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStopAuto extends CommandGroup {

    public AutoStopAuto() {
        addSequential(new ShooterStopShooting());			/* Turn off everything associated with shooting */
        addSequential(new FuelInjectorStopAuto());			/* Agitator, Conveyor, and Shooters */
        addSequential(new AgitatorStop());
    }
}
