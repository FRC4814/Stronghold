package org.usfirst.frc.team4814.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GhettoEncoder extends Encoder{
	public GhettoEncoder(int aChannel, int bChannel, boolean reverseDirection) {
		super(aChannel, bChannel, reverseDirection);
		setMaxPeriod(.1);
	 	setMinRate(10);
	 	setDistancePerPulse(0.38583);
		setSamplesToAverage(7);
	}

	public Encoder enc;
	
	/*
	public GhettoEncoder(int aChannel, int bChannel, boolean reverseDirection ) {
		enc = new Encoder(aChannel, bChannel, false, Encoder.EncodingType.k4X);
	 	enc.setMaxPeriod(.1);
	 	enc.setMinRate(10);
	 	enc.setDistancePerPulse(0.38583);
		enc.setReverseDirection(reverseDirection);
		enc.setSamplesToAverage(7);
	}
	*/
}
