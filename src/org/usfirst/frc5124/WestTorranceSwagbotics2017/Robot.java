package org.usfirst.frc5124.WestTorranceSwagbotics2017;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutnomousTrashGear;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutoStopAuto;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousGearForRedLeft;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousLeftGearTrash;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousPassBaseLine;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousTrashBlueBoiler;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousTrashRedBoiler;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems.*;

// Just a general note. In classes that are not subsystems that use methods defined in a subsystem, I will not explain the method
// in depth. To get a more in depth explanation of the method go to where it is defined in the subsystem.

public class Robot extends IterativeRobot {

    Command autonomousCommand;															/* command run in auto */	   
    Command stopAuto;																	/* Stops everything associated with shooting at start of teleop */

    public static OI oi;																/* Declaration of all subsystem objects */ 
    public static Agitator agitator;
    public static GearHolder gearHolder;
    public static FuelInjector fuelInjector;
    public static Shooter shooter;
    public static Hanger hanger;
    public static Drivetrain drivetrain;
    public static GyroPIDHandler gyroPIDHandler;
    public static EncoderPIDHandler encoderPIDHandler;
    
    public static boolean button3IsPressed;												/* Booleans used for toggling during teleop */
    public static boolean button2IsPressed;
    public static boolean button4IsPressed;

    public void robotInit() {															/* Run once when code is first started */
    																					/* (e.g. robot turns on or after deploying code) */ 
    	
    	RobotMap.init();																/* initialize all hardware */
        
    	agitator = new Agitator();														/* Initialization of all subsystems */
        gearHolder = new GearHolder();													/* OI is done last just in case it references another */
        fuelInjector = new FuelInjector();												/* susbsystem through the SmartDashboard or something */
        shooter = new Shooter();														/* to prevent any Null Pointer Exceptions */
        hanger = new Hanger();
        drivetrain = new Drivetrain();
        gyroPIDHandler = new GyroPIDHandler();
        encoderPIDHandler = new EncoderPIDHandler();
        
        oi = new OI();
       
       stopAuto = new AutoStopAuto();
       
       CameraServer.getInstance().startAutomaticCapture();
       
       gyroPIDHandler.calibrate();
       
       //adding good juju
       /*                                      
                                                  ___  ____    _________  ____  ___ 
                                                 / _ \/ __ \  / ___/ __ \/ __ \/ _ \
                                                / // / /_/ / / (_ / /_/ / /_/ / // /
                                               /____/\____/  \___/\____/\____/____/                                           
                                                
                                    ___   __  ___   ____   ___  ___________   ___  __   _______  ___ 
                                   / _ | /  |/  /  /  _/  / _ \/  _/ __/ _ | / _ )/ /  / __/ _ \/__ \
                                  / __ |/ /|_/ /  _/ /   / // // /_\ \/ __ |/ _  / /__/ _// // / /__/
                                 /_/ |_/_/  /_/  /___/  /____/___/___/_/ |_/____/____/___/____/ (_)  
                                                                  
                 __________  __  ________  ________ ______  _  _______      __  _____________  ___   ___________ ________
 				/ ___/ _ \ \/ / /  _/ __/ /_  __/ // / __/ / |/ / __/ | /| / / / __/_  __/ _ \/ _ | /  _/ ___/ // /_  __/
               / (_ / __ |\  / _/ /_\ \    / / / _  / _/  /    / _/ | |/ |/ / _\ \  / / / , _/ __ |_/ // (_ / _  / / /   
               \___/_/ |_|/_/ /___/___/   /_/ /_//_/___/ /_/|_/___/ |__/|__/ /___/ /_/ /_/|_/_/ |_/___/\___/_//_/ /_/    
                                                                                                                                                                                                 
           				                    ___________ ________  _____  _____  _______
  							               / __/ __/ _ /_  __/ / / / _ \/  _/ |/ / ___/
 						                  / _// _// __ |/ / / /_/ / , _// //    / (_ / 
						                 /_/ /___/_/ |_/_/  \____/_/|_/___/_/|_/\___/  
                                             
         				                  __   ____  _  ____________   ___  ____  ____
      				                     / /  / __ \/ |/ / ___/ ___/  / _ )/ __ \/  _/
 	   				                    / /__/ /_/ /    / (_ / (_ /  / _  / /_/ // /  
      				                   /____/\____/_/|_/\___/\___/  /____/\____/___/
      				  
                                             ___  _________   _______  _______     
  			  	                            / _ )/  _/ ___/  / __/ _ \/ __/ _ \  
 		   	                               / _  |/ // (_ /  _\ \/ ___/ _// // /  
		  	                              /____/___/\___/  /___/_/  /___/____/  
		  	                               
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%  %%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%    %%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%      %%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%       %%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%       %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%         %%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%         %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%          %%%@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%/          (%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%          %%%@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%            #%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%*          %@@@@@@@@@@@@@@@@@@@@@@@@@%%%%,            %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%          %@@@@@@@@@@@@@@@@@@@@@@@@%%%             %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%          @@@@@@@@@@@@@@@@@@@@@@@@%             %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%         @@@@@@@@@@@@@@@@@@@@@@%           /%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%        ,@@@@@@@@@@@@@@@,,,,           %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%     ,,,,,,,,,,,,,,,,,,,        %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@    ,,,,,,,,,,,,,,,*@     @@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@@%@@@@@@@@@@@@@@@@@.@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  @@@@@@@@@@@@@@@@@@@@@@@  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%	
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   .&&&&&,@@@@@@@@@&&&&&&&   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   &&     &&       &&      &   (%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   &&    @@ &&&&&&&&& /@    &&   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#   #&    .@ &&      &  @    &&   ,%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%     ,&&   &&&        &&(  &    .%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                                 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                                %%%%%%%%%%%%%****%%%%%%%%**%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                             %%%%%%%%%%%%%%*****%%%%%******%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                        %%%%%%%%%**%%%%%%****************%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#,..,/#%%%%%%%%%%%%%%%%%#************************%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%**********%%%%%%%%%%(****%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%((((((((%%%((((%%%(((((#((%((((((((((((((((((%(((((((,,,,/((***%%%%%%%%%%%%**********%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%      %%%    (%%      %%%                  %%%              **%%%%%%%%(***%********%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   ,%%%%%%%%%%    %%********%%%%%%%***%%%%%****%%%%*****%%%%%%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% /%%%%%%%%%%%%%%  %%*******%%%%%%%%%***%%****%%%%%%%,..%%%%%%,%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%%    *%%%,    %%*(%/(%%%%%%%%%...........%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%%             ***%%%**(%%#.......**.,**...%%(%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%%            %%%%**%%*****....%****.,**%%.....%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%%    **%%,   %%%***%%%%%%**..******.***%%%(.(%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%*    ***%,   ,%%***%%%%.....%*....,./.....%...*%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%*    ****.   ,%%**%%%%%....,****%%,%.%%%%%%....,%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%%    %%**    ,%(**%%%%%%%%..****..%%..%%%%/.%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%                   /%%%%%%%%%%     %%%%%%%%%%%    %%%*     ****%%%****,...*,.***%%..%%....%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%                  %%%%%%%%%%/      %%%%%%%%%     %%(*     **********,......***%%%%........%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%(              #%%%%%%%%%%          %%%%%.      %%**       %%*******%%%%%.........,%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#%%%%%%%%%******%%%%#...%%%...(%%%%%%%%%%%%%%%%%%%%%%
	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		  	                  				____                                   __  ___      
  										   / __/__  ___  ___  ___ ___  _______ ___/ / / _ )__ __
 										  _\ \/ _ \/ _ \/ _ \(_-</ _ \/ __/ -_) _  / / _  / // /
										 /___/ .__/\___/_//_/___/\___/_/  \__/\_,_/ /____/\_, / 
   											/_/                                          /___/                                                                                                     
		  	                                                                                                                    
                                 `.                                                                                                                                                                     
                              .+/.                                                                                                                                                                      
               `-:::--`    `/yo`                                                                                                                                                                        
          `/syso+/::/+osyssmo`                                                                                                                                                                          
        -yy/`          :hNsyy-                                    
      .hs`           /dMs`  .sh.                           -dMMMMMMMMMMMMMMMMMMN/     :ymMMMMMMMMMMMMMMMMMh      sMMMMMMMMMMMMMMMMy    /NMMMMMMN+    -mMMMMMMm      +NMMMN+    /ymMMMMMMMMMMMMMMMMMh    
     /d-           /mMh.      -m:                         oMMMMMMMmssssMMMMMMMMN:   -dMMMMMMMhsssdMMMMMMMMh    :mMMMMMMMyssssssss/   .hMMMMMMMh.    sMMMMMMMMM/   .hMMMMh.   -mMMMMMMMhsssmMMMMMMMMy    
    :m`          :dMm:         .m:                      -mMMMMMMMy```-hMMMMMMMh.   oMMMMMMMm:   /NMMMMMMN+    yMMMMMMM              +NMMMMMMN+    :mMMMMMMMMMMd  +NMMMN/    sMMMMMMMm-       
   `m:         .yMMo            /m                     sMMMMMMMMMMMMMMMMMMMms-   -mMMMMMMMs`  .hMMMMMMMh/   :mMMMMMMMMMMMMMMMm:   .hMMMMMMMh.    sMMMMMMMMMMMMM+dMMMMh.   :mMMMMMMMo        
   :m         +NMd-              N-                  -mMMMMMMMyyyymMMMMMMMm     sMMMMMMMm:   +NMMMMMMN/    yMMMMMMMdyyyyyyyyo`   +NMMMMMMN/    :mMMMMs.MMMMMMMMMMMMN/    yMMMMMMMd-  ooMMMMMMMMMN::      
   /d       .dMMs                m:                 sMMMMMMMm-   +NMMMMMMN/   -mMMMMMMMs`  .hMMMMMMMh/   /NMMMMMMMo            .dMMMMMMMy`    yMMMMm-  yMMMMMMMMMMy`   :mMMMMMMMo   -dMMMMMMMy--`       
   -N`     /NMN:         /-     `N.               :mMMMMMMMMNmmmNMMMMMMMs`   :MMMMMMMMMNmmNMMMMMMMm/    yMMMMMMMMNmmmmmmm+    +NMMMMMMN/    :NMMMMo    .MMMMMMMMN/    /MMMMMMMMMNmmNMMMMMMMd:           
    ho    sMMd.           yms:` sy               /ddddddddddddddddddhs/`     `sdddddddddddddddhyo-     hdddddddddddddddh:    sdddddddy`    +ddddh-      sddddddy`     `sdddddddddddddddhyo-             
    `m/ `hMMh`             yMMMdM+-`~                                                                                                                                                                    
     `hsdMMy                sMMMMMMMmhyo+:-.~                                                                                                                                                           
      `mMMh                `omMMMMMMMMMMNNNNmmdhyso+//:-.                                                                                                                                               
      hMMmyy+-`        `-+ys: .-..```                                                                                                                                                                   
     /MMM-  -+ssssssssss+-                                                                                                                                                                              
     mMMd        `.                                                                                                                                                                                     
    .MMMm`    .+s:                                                                                                                                                                                      
    `NMMMNhyhmh:                                                                                                                                                                                        
     :dMMMmy/`                                                                                                                                                                                          
        `                                                                                                
               
		  	                               
        */
    }

    public void disabledInit(){															/* Runs once before the robot is disabled */
    }

    public void disabledPeriodic() {													/* Run iteratively when the robot is disabled */
        
    	Scheduler.getInstance().run();													/* This is at the start of every mode. The scheduler is the man behind the */
        																				/* curtain that runs commands off buttons and default commands */
        
        if(oi.getAuto4()) {																/* Check if this switch is on before checking the other ones */
    		if(oi.getAuto3() && oi.getAuto1() && oi.getAuto2()) {						/* This giant monstrosity just checks all possible combinations */
    			SmartDashboard.putString("Auto is", "Base Line");						/* of the switches for setting different autos on the fly by the */
    		} else if(oi.getAuto3() && oi.getAuto1() && !oi.getAuto2()) {				/* drivert station. It is nested becuase if the 4th switch is not flipped */
    			SmartDashboard.putString("Auto is", "Gear Left");						/* auto is not run so it is set to null. Note that this only displays */
    		} else if(oi.getAuto3() && !oi.getAuto1() && oi.getAuto2()) {				/* the state to the SmartDashboard, and doesn't actually set the state */
    			SmartDashboard.putString("Auto is", "DONT RUN Gear Right");				/* of autonomousCammand */
    		} else if(oi.getAuto3() && !oi.getAuto1() && !oi.getAuto2()) {
    			SmartDashboard.putString("Auto is", "Gear Straight");
    		} else if(!oi.getAuto3() && oi.getAuto1() && oi.getAuto2()) {
    			SmartDashboard.putString("Auto is", "Fuel For Blue");
    		} else if(!oi.getAuto3() && oi.getAuto1() && !oi.getAuto2()) {
    			SmartDashboard.putString("Auto is", "Fuel For Red");
    		} else if(!oi.getAuto3() && !oi.getAuto1() && oi.getAuto2()) {
    			SmartDashboard.putString("Auto is", "Null");
    		} else if(!oi.getAuto3() && !oi.getAuto1() && !oi.getAuto2()) {
    			SmartDashboard.putString("Auto is", "Null");
    		}
    	} else {
    		SmartDashboard.putString("Auto is", "Null");
    	}    
    }

    public void autonomousInit() {														/* Run once right before auto period starts */
    	
    	drivetrain.setDrivetrainSpeed(1);												/* Sets max output of the drivetrain to 100% */
    	drivetrain.frontAndCenter();													/* Sets the normal front of the robot */
    	drivetrain.fastTurn();															/* make sure everything should be normal speed */
    	
    	encoderPIDHandler.resetEncoders();												/* Reset the Encoders before auto starts */
        
    	if(oi.getAuto4()) {																/* The same thing as the one in disabledPeriodic, but it */
    		if(oi.getAuto3() && oi.getAuto1() && oi.getAuto2()) {						/* sets the state of autonomousCommand. Note it only does this */
    			autonomousCommand = new AutonomousPassBaseLine();						/* right before auto starts, so changes to the switches made */
    		} else if(oi.getAuto3() && oi.getAuto1() && !oi.getAuto2()) {				/* during auto will not effect the command running during auto */
    			autonomousCommand = new AutonomousGearForRedLeft();						/* This also means that if needed, these switches could be used */
    		} else if(oi.getAuto3() && !oi.getAuto1() && oi.getAuto2()) {				/* to run commands during teleop. */
    			autonomousCommand = new AutonomousLeftGearTrash();
    		} else if(oi.getAuto3() && !oi.getAuto1() && !oi.getAuto2()) {
    			autonomousCommand = new AutnomousTrashGear();
    		} else if(!oi.getAuto3() && oi.getAuto1() && oi.getAuto2()) {
    			autonomousCommand = new AutonomousTrashBlueBoiler();
    		} else if(!oi.getAuto3() && oi.getAuto1() && !oi.getAuto2()) {
    			autonomousCommand = new AutonomousTrashRedBoiler();
    		} else if(!oi.getAuto3() && !oi.getAuto1() && oi.getAuto2()) {
    			autonomousCommand = null;
    		} else if(!oi.getAuto3() && !oi.getAuto1() && !oi.getAuto2()) {
    			autonomousCommand = null;
    		}
    	} else {
    		autonomousCommand = null;
    	}
    	
    	if (autonomousCommand != null) autonomousCommand.start();						/* Run the auto command if it isn't null */
   
    }

    public void autonomousPeriodic() {													/* Runs iteratively during the auto period */
        Scheduler.getInstance().run();
        Timer.delay(0.005);																/* Wait for motors to update or something? Possibly not needed */
    }

    public void teleopInit() {															/* Runs once right before teleop starts */
    	Robot.gyroPIDHandler.disable();													/* Stop any PID loops from auto and reset the PID outputs*/
    	Robot.encoderPIDHandler.disable();
    	Robot.drivetrain.resetAllOutputs();
    	Robot.encoderPIDHandler.resetEncoders();
    	
        if (autonomousCommand != null) autonomousCommand.cancel();						/* Stop the auto command, can be removed if you don't want to stop auto */ 				
        stopAuto.start();
    }

    public void teleopPeriodic() {														/* Runs iteratively during the teleop period */
        Scheduler.getInstance().run();
        
        if(oi.getDriver().getRawButton(5)) {											/* Check the fifth button on first driver, go fast if its pressed and stop */
        	drivetrain.setDrivetrainSpeed(1);											/* compressing to save battery so the robot doesn't die. Not necessarily */
        	drivetrain.fastTurn();														/* needed, we just had battery problems this year because we went sanic fast */
        	drivetrain.compressorOff();													/* Go slow if 8th button is pressed */
        } else if(oi.getDriver().getRawButton(8)) {
        	drivetrain.setDrivetrainSpeed(0.45);
        	drivetrain.slowTurn();
        	drivetrain.compressorOn();
        } else {
        	drivetrain.setDrivetrainSpeed(0.65);
        	drivetrain.slowTurn();
        	drivetrain.compressorOn();
        }
        
        if((oi.getDriver().getRawButton(4)) && !button4IsPressed) {						/* Check the 4th button on first driver and speed up the shooters when */	
        	button4IsPressed = true;													/* it is pressed. This is done by changing the velocity */
        	shooter.shootingSpeedLeft -= 400;											/* set point of all three shooters. Note that the motors are reversed */
        	shooter.shootingSpeedCenter -= 400;											/* so decreasing the set point (getting big in the negative direction) */
        	shooter.shootingSpeedRight -= 400;											/* makes the shooters go faster. The if block statement is the same as */
        } else if(!oi.getDriver().getRawButton(4)) {									/* this one but for slowing down the shooters */
        	button4IsPressed = false;
        }
        
        
        if(oi.getDriver().getRawButton(2) && !button2IsPressed) {						/* These if conditionals use a method for checking when a button is pressed. */
        	button2IsPressed = true;													/* They use a boolean alongside the actual state of the button */
        	shooter.shootingSpeedLeft += 400;											/* it from rapidly pressing the button multiple times even though */
        	shooter.shootingSpeedCenter += 400;											/* the button was only pressed once. This happens because even */
        	shooter.shootingSpeedRight += 400;											/* though a driver thinks they press a button quickly, the press */
        } else if(!oi.getDriver().getRawButton(2)) {									/* is registered over multiple loops, so the boolean prevents the */
        	button2IsPressed = false;													/* conditional from being true more than once over the course of */
        }
        
        if(oi.getDriver().getRawButton(3) && !button3IsPressed) {						/* Reset to the default shooting speeds by resetting the default velocity */
        	button3IsPressed = true;													/* set points */
        	shooter.shootingSpeedLeft = -16200;
        	shooter.shootingSpeedCenter = -16600;
        	shooter.shootingSpeedRight = -16600;
        } else if(!oi.getDriver().getRawButton(3)) {
        	button3IsPressed = false;
        }
        
        Timer.delay(0.005);																/* Wait for motors to update or something? Maybe not needed */       
    }
    
    public void testPeriodic() {														/* Runs iteratively during the test period. Doesn't happen during matches */
        LiveWindow.run();																/* Runs the livewindow */
    }
}
