package org.usfirst.frc.team4814.robot.subsystems;

import org.usfirst.frc.team4814.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	Talon intakeMotor;
	
	public Intake() {
		intakeMotor = new Talon(RobotMap.INTAKE_MOTOR);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void spinMotor(float power) {
		intakeMotor.set(power);
	}

}
