/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElevatorUp extends Command {
  public ElevatorUp() {
  }

  @Override
  protected void initialize() {
    Robot.arm.moveElevator(1);
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.arm.moveElevator(0);
  }

  @Override
  protected void interrupted() {
    Robot.arm.moveElevator(0);
  }
}
