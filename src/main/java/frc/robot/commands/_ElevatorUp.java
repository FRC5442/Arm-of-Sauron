/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class _ElevatorUp extends Command {
	private double enc_distance;

  public _ElevatorUp(double distance) {
		enc_distance = distance;
  }

  @Override
	protected void execute() {
		Robot.arm.moveElevator(1) ;
	}
	
	@Override
	protected boolean isFinished() {
		return (Math.abs(RobotMap.encoderVertical.getDistance()) >= enc_distance);
	}
	
	@Override
	protected void end() {
		Robot.arm.moveElevator(0);
	}
}
