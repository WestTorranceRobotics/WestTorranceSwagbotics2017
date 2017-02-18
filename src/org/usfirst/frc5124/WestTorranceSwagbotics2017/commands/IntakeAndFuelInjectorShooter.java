package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeAndFuelInjectorShooter extends CommandGroup {

    public IntakeAndFuelInjectorShooter() {
        addParallel(new IntakeMoveToShooter());
        addParallel(new FuelInjectorInjectFuel());
    }
}
