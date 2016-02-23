package org.usfirst.frc.team4814.robot.subsystems;

import org.usfirst.frc.team4814.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{
	
	DoubleSolenoid leftLift;
	DoubleSolenoid rightLift;
	
	public Pneumatics() {
        leftLift = new DoubleSolenoid(RobotMap.LEFT_LIFT[0], RobotMap.LEFT_LIFT[1]);
        rightLift = new DoubleSolenoid(RobotMap.RIGHT_LIFT[0], RobotMap.RIGHT_LIFT[1]);   
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	/*Moves the pnumatic actuators
	 * 
	 */
	public void lift (int power) {
		if (power == -1) {
			leftLift.set(DoubleSolenoid.Value.kReverse);
    		rightLift.set(DoubleSolenoid.Value.kReverse);
		}
		else if (power == 1) {
			leftLift.set(DoubleSolenoid.Value.kForward);
    		rightLift.set(DoubleSolenoid.Value.kForward);
		}
	}

}
