package org.usfirst.frc.team4814.robot.subsystems;

import org.usfirst.frc.team4814.robot.MultiSpeedController;
import org.usfirst.frc.team4814.robot.Robot;
import org.usfirst.frc.team4814.robot.RobotMap;
import org.usfirst.frc.team4814.robot.commands.HaloDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem {
	
	RobotDrive myRobot;
	
	public DriveBase(){    	
		MultiSpeedController leftDrive = new MultiSpeedController(new Victor(RobotMap.LEFT_MOTORS[0]), new Victor(RobotMap.LEFT_MOTORS[1]), new Victor(RobotMap.LEFT_MOTORS[2]));
		MultiSpeedController rightDrive = new MultiSpeedController(new Victor(RobotMap.RIGHT_MOTORS[0]), new Victor(RobotMap.RIGHT_MOTORS[1]), new Victor(RobotMap.RIGHT_MOTORS[2]));
		myRobot = new RobotDrive(leftDrive, rightDrive);
	}
	public void initDefaultCommand() { 	
	    // Set the default command for a subsystem here.
        setDefaultCommand(new HaloDrive());
    }
    public void haloDrive(double x, double y){ //HALO DRIVE
    	//System.out.println(Robot.leftEncoder.enc.getDistance() + " " + (Robot.rightEncoder.enc.getDistance()*-1));
    	myRobot.setLeftRightMotorOutputs(-y-x,-y+x);
  	}
    public void drive (double left, double right) {
    	myRobot.setLeftRightMotorOutputs(left, right);
    }
	 
}
