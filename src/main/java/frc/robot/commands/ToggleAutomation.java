/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class ToggleAutomation extends Command {
  public ToggleAutomation() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
	protected void initialize() {
		Robot.switchAutonomous();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
