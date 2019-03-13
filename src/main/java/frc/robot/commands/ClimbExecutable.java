/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Command;

public class ClimbExecutable extends Command{

	Command up1, up2;
	Command down1, down2;
	Command driveFor, driveBack;

	public ClimbExecutable() {
		this.up1 = new ScrewFrontCom(0.5);
		this.down1 = new ScrewFrontCom(-0.5);

		this.up2 = new ScrewBackCom(0.5);
		this.down2 = new ScrewBackCom(-0.5);

		this.driveFor = new ClimbDrive(0.5);
		this.driveBack = new ClimbDrive(-0.5);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if(OI.xboxController2.getRawAxis(1) > 0) {
			if(down1.isRunning())
				down1.cancel();
			else if (!up1.isRunning()) {
				up1.start();
			}
		}
		else if (OI.xboxController2.getRawAxis(1) < 0) {
			if(up1.isRunning()) 
				up1.cancel();
			else if (!down1.isRunning()) {
				down1.start();				
			}
		}
		else {
			up1.cancel();
			down1.cancel();
		}

		if (OI.xboxController2.getRawAxis(5) > 0) {
			if(down2.isRunning())
				down2.cancel();
			else if (!up2.isRunning()) {
				up2.start();
			}
		}
		else if (OI.xboxController2.getRawAxis(5) < 0) {
			if(up2.isRunning()) 
				up2.cancel();
			else if (!down2.isRunning()) {
				down2.start();				
			}
		}
		else {
			up2.cancel();
			down2.cancel();
		}

		if (OI.xboxController2.getRawAxis(2) > 0) {
			driveFor.start();
		}
		else {
			driveFor.cancel();
		}

		if (OI.xboxController2.getRawAxis(3) > 0) {
			driveBack.start();
		}
		else {
			driveBack.cancel();
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		if(down1.isRunning())
			down1.cancel();
		if(up1.isRunning()) 
			up1.cancel();
		if(down2.isRunning())
			down2.cancel();
		if(up2.isRunning()) 
			up2.cancel();
		if(driveFor.isRunning())
			driveFor.cancel();
		if(driveBack.isRunning()) 
			driveBack.cancel();
	}
	
	@Override
	protected void interrupted() {
		if(down1.isRunning())
			down1.cancel();
		if(up1.isRunning()) 
			up1.cancel();
		if(down2.isRunning())
			down2.cancel();
		if(up2.isRunning()) 
			up2.cancel();
		if(driveFor.isRunning())
			driveFor.cancel();
		if(driveBack.isRunning()) 
			driveBack.cancel();
	}
}