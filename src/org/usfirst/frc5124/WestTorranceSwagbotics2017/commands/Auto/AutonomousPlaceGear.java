package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Auto;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.GearHolderSafelyClose;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.GearHolderSafelyOpen;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.Wait;

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
