package org.usfirst.frc.team4814.robot.autoCommands;

import org.usfirst.frc.team4814.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveForward extends Command {
	
	private double power;
	private double distance;
	private double leftEncoder;
	private double rightEncoder;
	private double averageDistance;

	public MoveForward(double power, double distance) {
		requires(Robot.base);
		this.power = power;
		this.distance = distance;
	}
	@Override
	protected void initialize() {
		leftEncoder = Robot.leftEncoder.getDistance();
		rightEncoder = Robot.rightEncoder.getDistance();
	}

	@Override
	protected void execute() {
		Robot.base.drive(power,power);
		averageDistance = (( Robot.leftEncoder.getDistance() - leftEncoder) + (Robot.rightEncoder.getDistance()-rightEncoder)) / 2;
	}

	@Override
	protected boolean isFinished() {
		if (distance - averageDistance  <= 0) {
			return true;
		}
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.base.drive(0,0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

}
