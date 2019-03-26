/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.OI;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class ClimbExecutable extends Command{

	Command upFront, upBack;
	Command downFront, downBack;
	Command driveFor, driveBack;

	public ClimbExecutable() {
		this.upFront = new ScrewFrontCom(0.5);
		this.downFront = new ScrewFrontCom(-0.5);

		this.upBack = new ScrewBackCom(0.5);
		this.downBack = new ScrewBackCom(-0.5);

		this.driveFor = new IntakeDrive(1);
		this.driveBack = new IntakeDrive(-1);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if(OI.xboxController2.getRawAxis(1) > 0) {
			if(downFront.isRunning())
				downFront.cancel();
			else if (!upFront.isRunning()) {
				upFront.start();
			}
		}
		else if (OI.xboxController2.getRawAxis(1) < 0) {
			if(upFront.isRunning()) 
				upFront.cancel();
			else if (!downFront.isRunning()) {
				downFront.start();				
			}
		}
		else {
			upFront.cancel();
			downFront.cancel();
		}

		if (OI.xboxController2.getRawAxis(5) > 0) {
			if(downBack.isRunning())
				downBack.cancel();
			else if (!upBack.isRunning()) {
				upBack.start();
			}
		}
		else if (OI.xboxController2.getRawAxis(5) < 0) {
			if(upBack.isRunning()) 
				upBack.cancel();
			else if (!downBack.isRunning()) {
				downBack.start();				
			}
		}
		else {
			upBack.cancel();
			downBack.cancel();
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

		//---
		double joystickError = OI.xboxController2.getRawAxis(1) - OI.xboxController2.getRawAxis(5);
		double encoderError = RobotMap.encoderScrewFront.getDistance() - RobotMap.encoderScrewBack.getDistance();

		if (Math.abs(joystickError) <= 0.1) {
			if (encoderError > 0.05) {
				upFront = new ScrewFrontCom(0.5);
				downFront = new ScrewFrontCom(-0.5);
				upBack = new ScrewBackCom(0.55);
				downBack = new ScrewBackCom(-0.45);
			}
			else if (encoderError < -0.05) {
				upFront = new ScrewBackCom(0.55);
				downFront = new ScrewBackCom(-0.45);
				upBack = new ScrewBackCom(0.5);
				downBack = new ScrewBackCom(-0.5);
			}
			else {
				upFront = new ScrewFrontCom(0.5);
				downFront = new ScrewFrontCom(-0.5);
				upBack = new ScrewBackCom(0.5);
				downBack = new ScrewBackCom(-0.5);
			}
		}
		else {
			upFront = new ScrewFrontCom(0.5);
			downFront = new ScrewFrontCom(-0.5);
			upBack = new ScrewBackCom(0.5);
			downBack = new ScrewBackCom(-0.5);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		if(downFront.isRunning())
			downFront.cancel();
		if(upFront.isRunning()) 
			upFront.cancel();
		if(downBack.isRunning())
			downBack.cancel();
		if(upBack.isRunning()) 
			upBack.cancel();
		if(driveFor.isRunning())
			driveFor.cancel();
		if(driveBack.isRunning()) 
			driveBack.cancel();
	}
	
	@Override
	protected void interrupted() {
		if(downFront.isRunning())
			downFront.cancel();
		if(upFront.isRunning()) 
			upFront.cancel();
		if(downBack.isRunning())
			downBack.cancel();
		if(upBack.isRunning()) 
			upBack.cancel();
		if(driveFor.isRunning())
			driveFor.cancel();
		if(driveBack.isRunning()) 
			driveBack.cancel();
	}
}