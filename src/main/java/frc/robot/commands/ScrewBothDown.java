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

public class ScrewBothDown extends Command {
  public ScrewBothDown() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Math.abs(RobotMap.encoderScrewBack.getDistance()) - Math.abs(RobotMap.encoderScrewFront.getDistance()) > 100) {
      Robot.corkScrew.ScrewBack(0.5);
      Robot.corkScrew.ScrewFront(0.9);
    }
    else if(Math.abs(RobotMap.encoderScrewFront.getDistance()) - Math.abs(RobotMap.encoderScrewBack.getDistance()) > 100) {
      Robot.corkScrew.ScrewBack(0.9);
      Robot.corkScrew.ScrewFront(0.5);
    }
    else {
      Robot.corkScrew.ScrewBack(0.9);
      Robot.corkScrew.ScrewFront(0.9);
    }

  
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.corkScrew.ScrewFront(0);
    Robot.corkScrew.ScrewBack(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.corkScrew.ScrewFront(0);
    Robot.corkScrew.ScrewBack(0);
  }
}
