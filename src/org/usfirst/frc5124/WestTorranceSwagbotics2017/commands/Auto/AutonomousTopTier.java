package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Auto;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.GearHolderAutoRelase;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousTopTier extends CommandGroup {

    public AutonomousTopTier() {
        addSequential(new AutoKamikazeGear());
        addSequential(new Wait(2));
        addParallel(new GearHolderAutoRelase());
    }
}
