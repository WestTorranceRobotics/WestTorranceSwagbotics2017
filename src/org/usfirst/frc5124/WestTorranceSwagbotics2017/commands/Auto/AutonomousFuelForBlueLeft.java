package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousFuelForBlueLeft extends CommandGroup {

    public AutonomousFuelForBlueLeft() {
    	//move up 1/2 the distance it takes to reach the base line starting from 4 feet to the left
    	addSequential(new AutoDriveByEncoder(46, 0.5));
    	//Turn towards tank
    	addSequential(new AutoTurnWithGyro(-90));
    	//move towards tank
    	addSequential(new AutoDriveByEncoder(14, 0.5));
    	//Turn to face tank head on
    	addSequential(new AutoTurnWithGyro(-45));
    	//addSequential(new AutoShoot());       
    	addSequential(new AutoShoot(5));
    } 
    	}
