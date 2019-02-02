/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Command;

public class ArmExecutable extends Command{

	Command up;
	Command down;

	public ArmExecutable() {
		this.up = new ArmUp();
		this.down = new ArmDown();
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if(OI.joystickController2.getRawAxis(1) > 0) {
			if(down.isRunning())
				down.cancel();
			else if (!up.isRunning()) {
				up.start();
			}
		}
		else if (OI.joystickController2.getRawAxis(1) < 0) {
			if(up.isRunning()) 
				up.cancel();
			else if (!down.isRunning()) {
				down.start();				
			}
		}
		else {
			up.cancel();
			down.cancel();
		}

		if (OI.joystickController2.getRawAxis(1) > 0 && OI.joystickController2.getRawButtonPressed(1)) {
			
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		if(down.isRunning())
			down.cancel();
		if(up.isRunning()) 
			up.cancel();
	}
	
	@Override
	protected void interrupted() {
		if(down.isRunning())
			down.cancel();
		if(up.isRunning()) 
			up.cancel();
	}
}