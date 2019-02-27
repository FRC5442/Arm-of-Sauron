/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ElevatorUp extends Command {
  public ElevatorUp() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  @Override
	protected void execute() {
		Robot.arm.moveElevator(0.5) ;
	}
	
	@Override
	protected boolean isFinished() {
		return !RobotMap.highElevatorSwitch.get();
	}
	
	@Override
	protected void end() {
		Robot.arm.moveElevator(0);
	}
}
