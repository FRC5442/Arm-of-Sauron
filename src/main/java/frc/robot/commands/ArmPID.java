/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.*;

public class ArmPID extends PIDCommand {
  public ArmPID() {
    super(0.5, 10.0, 0);
    
    //requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setSetpointRelative(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    setSetpoint(Robot.arm.armThreshold);
    SmartDashboard.putNumber("Arm Threshold", Robot.arm.armThreshold);
  }

  @Override
  public void usePIDOutput(double output) {
    RobotMap.armController.set(-output);
    SmartDashboard.putNumber("PID Output", output);
  }

  @Override
  public double returnPIDInput() {
    return RobotMap.encoderArm.getDistance();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return ((Math.abs(Robot.arm.armThreshold - RobotMap.encoderArm.getDistance())) <= 0.01);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.armController.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    RobotMap.armController.set(0);
  }
}
