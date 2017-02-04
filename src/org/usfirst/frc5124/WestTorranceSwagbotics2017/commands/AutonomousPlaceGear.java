package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousPlaceGear extends CommandGroup {

    public AutonomousPlaceGear() {
        addSequential(new AutoKamikazeGear());
        addSequential(new GearHolderSafelyOpen());
        addSequential(new Wait(0.5));
        addSequential(new GearHolderSafelyClose());
    }
}
