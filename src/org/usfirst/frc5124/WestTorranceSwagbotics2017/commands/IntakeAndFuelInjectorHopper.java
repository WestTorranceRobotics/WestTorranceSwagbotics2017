package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeAndFuelInjectorHopper extends CommandGroup {

    public IntakeAndFuelInjectorHopper() {
        addParallel(new IntakeIntake());
        addParallel(new FuelInjectorExtractFuel());
    }
}
