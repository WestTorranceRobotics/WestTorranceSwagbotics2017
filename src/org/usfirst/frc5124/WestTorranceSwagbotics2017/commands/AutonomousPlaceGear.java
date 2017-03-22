package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.GearHolderSafelyClose;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.GearHolderSafelyOpen;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Wait;

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
