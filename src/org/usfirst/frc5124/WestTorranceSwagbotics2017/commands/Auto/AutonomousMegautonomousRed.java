package org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Auto;

import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.FuelInjectorConveyorToShooters;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.GearHolderSafelyClose;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.GearHolderSafelyOpen;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.ShooterStartShooting;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.Default.Wait;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMegautonomousRed extends CommandGroup {

    public AutonomousMegautonomousRed() {
    	//drive to just short of base line
        addSequential(new AutoDriveByEncoder(76, 0.7));
        //turn perpendicular to peg
        addSequential(new AutoTurnWithGyro(-60));
        //drive to peg fast
        addSequential(new AutoDriveByEncoder(63, 0.6));
        //finish driving to peg slow
        addSequential(new AutoDriveByEncoder(10, 0.45));
        //release gear
        addSequential(new GearHolderSafelyOpen());
        //wait little for good measure? may need to remove
        addSequential(new Wait(0.5));
        //drive back to base line
        addSequential(new AutoDriveByEncoder(-73, 0.6));
        //good place to close this up
        addParallel(new GearHolderSafelyClose());
        //turn perpendicular to alliance wall
        addSequential(new AutoTurnWithGyro(60));
        //drive to key boundary
        addSequential(new AutoDriveByEncoder(-35, 0.7));
        //turn the long way perpendicular to boiler so shooters are in back
        addSequential(new AutoTurnWithGyro(135));
        //driveto boiler
        addSequential(new AutoDriveByEncoder(50, 0.6));
        //shoot
        addSequential(new ShooterStartShooting());
        //shoot
        addSequential(new FuelInjectorConveyorToShooters());
    }
}
