package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousPassBaseLine extends CommandGroup {

    public AutonomousPassBaseLine() {
        addSequential(new AutoTrashDrive(0.6, 4));
    }
}
