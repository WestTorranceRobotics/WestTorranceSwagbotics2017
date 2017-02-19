package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousTopTier extends CommandGroup {

    public AutonomousTopTier() {
        addSequential(new AutoKamikazeGear());
        addParallel(new GearHolderAutoRelase());
    }
}
