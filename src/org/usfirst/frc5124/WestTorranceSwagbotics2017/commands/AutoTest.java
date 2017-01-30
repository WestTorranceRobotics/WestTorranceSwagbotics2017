package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoTest extends CommandGroup {

    public AutoTest() {
        addSequential(new IntakeIntake());
        addSequential(new IntakeInterruptOperation(5));
    }
}
