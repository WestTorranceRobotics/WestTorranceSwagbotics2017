package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearHolderAutoRelase extends CommandGroup {

    public GearHolderAutoRelase() {
        addSequential(new GearHolderOpen());
        addSequential(new Wait(.2));
        addSequential(new GearHolderRectractPusher());
        addSequential(new Wait(.5));
    }
}
