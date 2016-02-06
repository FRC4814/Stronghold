package org.usfirst.frc.team4814.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{
	 DoubleSolenoid leftShifter;
	 DoubleSolenoid rightShifter;
	 DoubleSolenoid shifter2;
	 DoubleSolenoid shifter3;
	 
	public Pneumatics() {
        //leftShifter = new DoubleSolenoid(2, 3);
       // rightShifter = new DoubleSolenoid(0, 1);
       // shifter2 = new DoubleSolenoid(4, 5);
      //  shifter3 = new DoubleSolenoid(6, 7);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void shiftUp() {
		// TODO Auto-generated method stub
		leftShifter.set(DoubleSolenoid.Value.kReverse);
		rightShifter.set(DoubleSolenoid.Value.kReverse);
		shifter2.set(DoubleSolenoid.Value.kReverse);
		shifter3.set(DoubleSolenoid.Value.kReverse);
		System.out.println("test");
	}
	
}
