/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
public class WristDown extends Command {
  public WristDown() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  @Override
	protected void execute() {
		Robot.arm.rotateWrist(-0.3);
	}
	
  @Override
  
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.arm.rotateWrist(0);
	}
}
