package org.usfirst.frc.team4814.robot.commands;

import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class UpdateDashboard extends Command {
	public UpdateDashboard() {
		
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		System.out.println("Initialize");
	}

	@Override
	protected void execute() {
		System.out.println("Execute");
		Robot.smartDashboard.update();
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		System.out.println("Interrupted");
	}
	
}
