package org.usfirst.frc.team4814.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.team4814.robot.commands.ShiftUp;
import org.usfirst.frc.team4814.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
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
public class Robot extends SampleRobot {
    RobotDrive myRobot;// class that handles basic drive operations
    Joystick joystick;
    public static final Pneumatics pneumatics = new Pneumatics();
    public static OI oi;
    DoubleSolenoid leftShifter;
	 DoubleSolenoid rightShifter;
	 DoubleSolenoid shifter2;
	 DoubleSolenoid shifter3;
	 
    public Robot() {
    	MultiSpeedController leftDrive = new MultiSpeedController(new Victor(1), new Victor(2), new Victor(3));
    	MultiSpeedController rightDrive = new MultiSpeedController(new Victor(4), new Victor(5), new Victor(0));
        myRobot = new RobotDrive(leftDrive, rightDrive);
        myRobot.setExpiration(0.1);
        joystick = new Joystick(1);
        //oi = new OI();
        leftShifter = new DoubleSolenoid(2, 3);
        rightShifter = new DoubleSolenoid(0, 1);
        shifter2 = new DoubleSolenoid(4, 5);
        shifter3 = new DoubleSolenoid(6, 7);    
    }

    
    /**
     * Runs the motors with tank steering.
     */
    public void operatorControl() {
        myRobot.setSafetyEnabled(true);
        
        
        while (isOperatorControl() && isEnabled()) {
        	if (joystick.getRawButton(1)) {
        		leftShifter.set(DoubleSolenoid.Value.kReverse);
        		rightShifter.set(DoubleSolenoid.Value.kReverse);
        		shifter2.set(DoubleSolenoid.Value.kReverse);
        		shifter3.set(DoubleSolenoid.Value.kReverse);
        		System.out.println("test");
        	}
        	if (joystick.getRawButton(3)) {
        		leftShifter.set(DoubleSolenoid.Value.kForward);
        		rightShifter.set(DoubleSolenoid.Value.kForward);
        		shifter2.set(DoubleSolenoid.Value.kForward);
        		shifter3.set(DoubleSolenoid.Value.kForward);
        		System.out.println("test");
        	}
        	double x, y;
        	x = joystick.getRawAxis(2);
        	y = joystick.getRawAxis(1);
        	myRobot.setLeftRightMotorOutputs(y-x, y+x);
            Timer.delay(0.005);	// wait for a motor update time
        }
    }
    

}
