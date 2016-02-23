package org.usfirst.frc.team4814.robot;


import org.usfirst.frc.team4814.robot.autoCommands.MoveForward;
import org.usfirst.frc.team4814.robot.commands.IntakeDown;
import org.usfirst.frc.team4814.robot.commands.IntakeIn;
import org.usfirst.frc.team4814.robot.commands.IntakeOut;
import org.usfirst.frc.team4814.robot.commands.IntakeUp;
import org.usfirst.frc.team4814.robot.commands.UpdateDashboard;
import org.usfirst.frc.team4814.robot.dashboard.Dashboard;
import org.usfirst.frc.team4814.robot.subsystems.DriveBase;
import org.usfirst.frc.team4814.robot.subsystems.GhettoEncoder;
import org.usfirst.frc.team4814.robot.subsystems.Intake;
import org.usfirst.frc.team4814.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically it 

 * contains the code necessary to operate a robot with tank drive.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're inexperienced,
 * don't. Unless you know what you are doing, complex code will be much more difficult under
 * this system. Use IterativeRobot or Command-Based instead if you're new.
 */

public class Robot extends IterativeRobot {
    
    public static  DriveBase base;// = new DriveBase();
    public static  Pneumatics lift;// = new Pneumatics();
    public static  Intake intake;// = new Intake();
    public static  GhettoEncoder leftEncoder;// = new GhettoEncoder();
    public static  GhettoEncoder rightEncoder;// = new GhettoEncoder();
    public static UpdateDashboard updateDashboard;
    public static Dashboard smartDashboard;// = new Dashboard();
    public static OI oi;
	public Command autonomousCommand;
	
	public void robotInit() {
		try {
			oi = new OI();
			base = new DriveBase();
			lift = new Pneumatics();
			intake = new Intake();
			leftEncoder = new GhettoEncoder(0,1, false);
			rightEncoder = new GhettoEncoder(2,3, true);
			smartDashboard = new Dashboard();
			updateDashboard = new UpdateDashboard();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
    	oi.liftLeft.whileHeld(new IntakeUp());
    	oi.liftRight.whileHeld(new IntakeDown());
    	oi.intakeIn.whileHeld(new IntakeIn());
    	oi.intakeOut.whileHeld(new IntakeOut());
	}
    /**
     * This function is called periodically during operator control
     */
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        autonomousCommand = new MoveForward(.5,115);
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) {
        	autonomousCommand.cancel();
        	autonomousCommand = null;
        }
    	leftEncoder.enc.reset();
    	rightEncoder.enc.reset();
    	updateDashboard.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

}
