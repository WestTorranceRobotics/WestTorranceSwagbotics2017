package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousFuelForRedLeft extends CommandGroup {

    public AutonomousFuelForRedLeft() {
    	//move up 1/2 the distance it takes to reach the base line starting from about 4 feet from center
    	addSequential(new AutoDriveByEncoder(46));
    	//Turn towards tank
    	addSequential(new AutoTurnWithGyro(90));
    	//move towards tank
    	addSequential(new AutoDriveByEncoder(22));
    	//Turn to face tank head on
    	addSequential(new AutoTurnWithGyro(45));
    	//addSequential(new AutoShoot());    	
    	addSequential(new AutoShoot(5));
    }
}
