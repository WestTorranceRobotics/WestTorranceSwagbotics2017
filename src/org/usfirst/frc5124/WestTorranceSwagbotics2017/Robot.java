package org.usfirst.frc5124.WestTorranceSwagbotics2017;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousFuelForBlue;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousFuelForRed;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousGearBasicStraight;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousGearForBlueRight;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousGearForRedLeft;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.commands.AutonomousPassBaseLine;
import org.usfirst.frc5124.WestTorranceSwagbotics2017.subsystems.*;

public class Robot extends IterativeRobot {

    Command autonomousCommand;															/* command run in auto */	

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
    public static boolean povUpIsPressed;
    public static boolean povDownIsPressed;

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
        
       CameraServer.getInstance().startAutomaticCapture();								/* Start usb camera on RoboRio */
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
		  	                               
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  %%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    %%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%      %%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%       %%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%       %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%         %%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%         %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%          %%%@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%/          (%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%          %%%@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%            #%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*          %@@@@@@@@@@@@@@@@@@@@@@@@@%%%%,            %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%          %@@@@@@@@@@@@@@@@@@@@@@@@%%%             %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%          @@@@@@@@@@@@@@@@@@@@@@@@%             %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%         @@@@@@@@@@@@@@@@@@@@@@%           /%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%        ,@@@@@@@@@@@@@@@,,,,           %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%     ,,,,,,,,,,,,,,,,,,,        %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@    ,,,,,,,,,,,,,,,*@     @@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@@%@@@@@@@@@@@@@@@@@.@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%  @@@@@@@@@@@@@@@@@@@@@@@  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   .&&&&&,@@@@@@@@@&&&&&&&   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   &&     &&       &&      &   (%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   &&    @@ &&&&&&&&& /@    &&   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#   #&    .@ &&      &  @    &&   ,%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%     ,&&   &&&        &&(  &    .%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                                 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                                %%%%%%%%%%%%%****%%%%%%%%**%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                             %%%%%%%%%%%%%%*****%%%%%******%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                        %%%%%%%%%**%%%%%%****************%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#,..,/#%%%%%%%%%%%%%%%%%#************************%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%**********%%%%%%%%%%(****%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%((((((((%%%((((%%%(((((#((%((((((((((((((((((%(((((((,,,,/((***%%%%%%%%%%%%**********%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%      %%%    (%%      %%%                  %%%              **%%%%%%%%(***%********%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   ,%%%%%%%%%%    %%********%%%%%%%***%%%%%****%%%%*****%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% /%%%%%%%%%%%%%%  %%*******%%%%%%%%%***%%****%%%%%%%,..%%%%%%,%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%%    *%%%,    %%*(%/(%%%%%%%%%...........%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%%             ***%%%**(%%#.......**.,**...%%(%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%%            %%%%**%%*****....%****.,**%%.....%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%%    **%%,   %%%***%%%%%%**..******.***%%%(.(%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%*    ***%,   ,%%***%%%%.....%*....,./.....%...*%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%*    ****.   ,%%**%%%%%....,****%%,%.%%%%%%....,%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%     %%%    (%%    (%%%%%%%%%%     %%%%%%%%%%%    %%**    ,%(**%%%%%%%%..****..%%..%%%%/.%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                   /%%%%%%%%%%     %%%%%%%%%%%    %%%*     ****%%%****,...*,.***%%..%%....%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%                  %%%%%%%%%%/      %%%%%%%%%     %%(*     **********,......***%%%%........%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%(              #%%%%%%%%%%          %%%%%.      %%**       %%*******%%%%%.........,%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#%%%%%%%%%******%%%%#...%%%...(%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%/#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		  	                               
		  	                               
		  	                               
        */
    }

    public void disabledInit(){															/* Runs once before the robot is disabled */
    }

    public void disabledPeriodic() {													/* Run iteratively when the robot is diabled */
        
    	Scheduler.getInstance().run();													/* This is at the start of every mode. The scheduler is the man behind the */
        																				/* curtain that runs commands off buttons and default commands */
        
        if(oi.getAuto4()) {																/* Check if this switch is on before checking the other ones */
    		if(oi.getAuto3() && oi.getAuto1() && oi.getAuto2()) {						/* This giant monstrosity just checks all possible combinations */
    			SmartDashboard.putString("Auto", "Base Line");							/* of the switches for setting different autos on the fly by the */
    		} else if(oi.getAuto3() && oi.getAuto1() && !oi.getAuto2()) {				/* drivertstation. It is nested becuase if the 4th switch is not flipped */
    			SmartDashboard.putString("Auto", "Gear Left");							/* auto is not run so it is set to null. Note that this only displays */
    		} else if(oi.getAuto3() && !oi.getAuto1() && oi.getAuto2()) {				/* the state to the SmartDashboard, and doesn't actually set the state */
    			SmartDashboard.putString("Auto", "Gear Right");							/* of autonomousCammand */
    		} else if(oi.getAuto3() && !oi.getAuto1() && !oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Gear Straight");
    		} else if(!oi.getAuto3() && oi.getAuto1() && oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Fuel For Blue");
    		} else if(!oi.getAuto3() && oi.getAuto1() && !oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Fuel For Red");
    		} else if(!oi.getAuto3() && !oi.getAuto1() && oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Null");
    		} else if(!oi.getAuto3() && !oi.getAuto1() && !oi.getAuto2()) {
    			SmartDashboard.putString("Auto", "Null");
    		}
    	} else {
    		SmartDashboard.putString("Auto", "Null");
    	}    
    }

    public void autonomousInit() {														/* Run once right before auto period starts */
    	
    	drivetrain.setDrivetrainSpeed(1);												/* Sets max output of the drivetrain to 100% */
    	drivetrain.frontAndCenter();													/* Sets the normal front of the robot */
    	
    	encoderPIDHandler.resetEncoders();												/* Reset the Encoders */
        
    	if(oi.getAuto4()) {																/* The same thing as the one in disabledPeriodic, but it */
    		if(oi.getAuto3() && oi.getAuto1() && oi.getAuto2()) {						/* sets the state of autonomousCommand. Note it only does this */
    			autonomousCommand = new AutonomousPassBaseLine();						/* right before auto starts, so changes to the switches made */
    		} else if(oi.getAuto3() && oi.getAuto1() && !oi.getAuto2()) {				/* during auto will not effect the command running during auto */
    			autonomousCommand = new AutonomousGearForRedLeft();						/* This also means that if needed, these switches could be used */
    		} else if(oi.getAuto3() && !oi.getAuto1() && oi.getAuto2()) {				/* to run commands during teleop. */
    			autonomousCommand = new AutonomousGearForBlueRight();
    		} else if(oi.getAuto3() && !oi.getAuto1() && !oi.getAuto2()) {
    			autonomousCommand = new AutonomousGearBasicStraight();
    		} else if(!oi.getAuto3() && oi.getAuto1() && oi.getAuto2()) {
    			autonomousCommand = new AutonomousFuelForBlue();
    		} else if(!oi.getAuto3() && oi.getAuto1() && !oi.getAuto2()) {
    			autonomousCommand = new AutonomousFuelForRed();
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
    	
        if (autonomousCommand != null) autonomousCommand.cancel();						/* Stop the auto command, can be removed if you don't want to stop auto */ 				
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        if(oi.getDriver().getRawButton(5)) {											/* Check the fifth button on first driver, go fast if its pressed and stop */
        	drivetrain.setDrivetrainSpeed(1);											/* compressing to save battery so the robot doesn't die. Not necessarily */
        	drivetrain.fastTurn();														/* needed, we just had battery problems this year becuase we went sanic fast */
        	drivetrain.compressorOff();													/* Go slow if 4th button is pressed */
        } else if(oi.getDriver().getRawButton(8)) {
        	drivetrain.setDrivetrainSpeed(0.45);
        	drivetrain.slowTurn();
        } else {
        	drivetrain.setDrivetrainSpeed(0.65);
        	drivetrain.slowTurn();
        	drivetrain.compressorOn();
        }
        
        if((oi.getDriver().getPOV(0) == 0) && !povUpIsPressed) {						/* Check the POV on first driver (D-Pad). It is measured in degrees */	
        	povUpIsPressed = true;														/* so 0 is up and 180 is down. Speed up the shooters when up is pressed */
        	povDownIsPressed = false;													/* and slow it when down is pressed. This is done by changing the velocity */
        	shooter.shootingSpeedLeft -= 200;											/* set point. */
        	shooter.shootingSpeedCenter -= 200;
        	shooter.shootingSpeedRight -= 200;
        } else if((oi.getDriver().getPOV(0) == 180) && !povDownIsPressed) {				/* These if conditionals use a method for checking when a button is pressed. */
        	povDownIsPressed = true;													/* They use a boolean alongside the actual state of the button */
        	povUpIsPressed = false;														/* The boolean is used to "de-bounce" the button, which means to stop */
        	shooter.shootingSpeedLeft += 200;											/* it from rapidly pressing the button multiple times even though */
        	shooter.shootingSpeedCenter += 200;											/* the button was only pressed once. This happens because even */
        	shooter.shootingSpeedRight += 200;											/* though a driver thinks they press a button quickly, the press */
        } else if(oi.getDriver().getPOV(0) == -1) {										/* is registered over multiple loops, so the boolean prevents the */
        	povUpIsPressed = false;														/* conditional from being true more than once over the course of */
        	povDownIsPressed = false;													/* a single button press, and is reset when the button is released */
        }
        
        if(oi.getDriver().getRawButton(3) && !button3IsPressed) {						/* Reset to the default shooting speeds by resetting the velocity set points */
        	button3IsPressed = true;
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
