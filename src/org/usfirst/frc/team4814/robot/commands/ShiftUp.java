package org.usfirst.frc.team4814.robot.commands;

import org.usfirst.frc.team4814.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ShiftUp extends Command{
	
	public ShiftUp() {
		System.out.println("ShiftUp1");
		requires(Robot.pneumatics);
		//execute();
	}
	
	@Override
	protected void initialize() {
		System.out.println("ShiftUp2");
		
	}

	@Override
	protected void execute() {
		System.out.println("execute");
		Robot.pneumatics.shiftUp();
		
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
		
	}

}
