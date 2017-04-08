package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousPassBaseLine extends CommandGroup {

    public AutonomousPassBaseLine() {
        addSequential(new DrivetrainAutoTrashDrive(0.6, 3));		/* Drive for three seconds easiest points of my life */
    }
}
