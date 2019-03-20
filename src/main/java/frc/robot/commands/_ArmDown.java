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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class _ArmDown extends Command {
	private double enc_distance;

  public _ArmDown(double distance) {
		enc_distance = distance;
  }

  @Override
  protected void execute() {
	Robot.arm.rotateArm(0.4) ;
	}

	@Override
	protected boolean isFinished() {
		return (RobotMap.encoderArm.getDistance()) <= enc_distance;
	}
	@Override
	protected void interrupted() {
		Robot.arm.rotateArm(0);
	}

	@Override
	protected void end() {
		Robot.arm.rotateArm(0);
	}
}
