package org.usfirst.frc.team4814.robot.dashboard;

import org.usfirst.frc.team4814.robot.Auto;
import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	public Dashboard() {
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
        SmartDashboard.putNumber("Left Encoder",Robot.leftEncoder.enc.getDistance());
        SmartDashboard.putNumber("Right Encoder",Robot.rightEncoder.enc.getDistance());
	}
	public void update() {
		 System.out.println(Robot.leftEncoder.enc.getDistance() + " " + Robot.rightEncoder.enc.getDistance());
		 SmartDashboard.putNumber("Left Encoder",Robot.leftEncoder.enc.getDistance());
		 SmartDashboard.putNumber("Right Encoder",Robot.rightEncoder.enc.getDistance());
	}
}
