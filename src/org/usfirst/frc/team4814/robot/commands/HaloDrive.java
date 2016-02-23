package org.usfirst.frc.team4814.robot.commands;

import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HaloDrive extends Command {
	
	public HaloDrive() {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.base);
    }
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
    protected void execute() {
		double x, y;   
    	x = Math.pow(Robot.oi.joystick.getRawAxis(2), 3);
    	y = Math.pow(Robot.oi.joystick.getRawAxis(1), 3);
    	Robot.base.haloDrive(x,y);
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
