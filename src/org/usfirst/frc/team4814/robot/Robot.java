package org.usfirst.frc.team4814.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.team4814.robot.commands.ShiftUp;
import org.usfirst.frc.team4814.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	DoubleSolenoid shifter2;
	DoubleSolenoid shifter3;
	Talon intakeMotor;
	 //Encoder enc;
	 DigitalInput D;
	 
    public Robot() {
    	MultiSpeedController leftDrive = new MultiSpeedController(new Victor(1), new Victor(2), new Victor(3));
    	MultiSpeedController rightDrive = new MultiSpeedController(new Victor(4), new Victor(5), new Victor(0));
   	 	//enc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
   	 	D = new DigitalInput(0);
   	 	//enc.setMaxPeriod(.1);
   	 	//enc.setMinRate(10);
   	 	//enc.setDistancePerPulse(5);
 		//enc.setReverseDirection(true);
 		//enc.setSamplesToAverage(7);
    	intakeMotor = new Talon(6);
        myRobot = new RobotDrive(leftDrive, rightDrive);
        myRobot.setExpiration(0.1);
        joystick = new Joystick(1);
        shifter2 = new DoubleSolenoid(4, 5);
        shifter3 = new DoubleSolenoid(6, 7);    
    }

    
    /**
     * Runs the motors with tank steering.
     */
    public void operatorControl() {
        myRobot.setSafetyEnabled(true);
        
        while (isOperatorControl() && isEnabled()) {
        	if (joystick.getRawButton(5)) {
        		shifter2.set(DoubleSolenoid.Value.kReverse);
        		shifter3.set(DoubleSolenoid.Value.kReverse);
        	}
        	if (joystick.getRawButton(6)) {
        		shifter2.set(DoubleSolenoid.Value.kForward);
        		shifter3.set(DoubleSolenoid.Value.kForward);
        	}
        	
        	runIntake();
        	
        	double x, y;        	
        	x = Math.pow(joystick.getRawAxis(2), 3);
        	y = Math.pow(joystick.getRawAxis(1), 3);
        	
        	/*
        	if (joystick.getRawButton(8)) {
        		myRobot.setLeftRightMotorOutputs(-y/5-x/3,-y/5+x/3);
        	}
        	else {*/
        		myRobot.setLeftRightMotorOutputs(-y-x,-y+x);
        	//}
        	System.out.println(System.currentTimeMillis() + "\t" + D.get());
        	
        	SendableChooser position = new SendableChooser();
        	position.addDefault("Position 1", new Auto());
        	position.addObject("Position 2", new Auto());
        	position.addObject("Position 3", new Auto());
        	position.addObject("Position 4", new Auto());
        	position.addObject("Position 5", new Auto());
            SmartDashboard.putData("Position", position);
            
            SendableChooser obstacle = new SendableChooser();
            obstacle.addDefault("Cheval", new Auto());
            obstacle.addObject("Rock Wall", new Auto());
            obstacle.addObject("Ramparts", new Auto());
            SmartDashboard.putData("Obstacle", obstacle);
            
            Timer.delay(0.005);	// wait for a motor update time
        }
    }
    
    public void runIntake() {
    	if (joystick.getRawButton(7)) {
    		intakeMotor.set(1);
    	}
    	else if (joystick.getRawButton(8)) {
			intakeMotor.set(-1);
    	}
    	else {
    		intakeMotor.set(0);
    	}
    }
    

}
