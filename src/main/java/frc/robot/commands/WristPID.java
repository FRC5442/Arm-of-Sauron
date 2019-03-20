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

public class WristPID extends PIDCommand {
  public WristPID() {
    super(0.5, 0.004, 0.001);

    /* How P,I, and D values are calculated
      P = (1.2 * T) / (K * d)
      I = (2.0 * d)
      D = (0.5 * d)

      Where:
        d = dead time - how long the PID loop takes to react to a change
        K = constant (process variable) - how drastically the loop responds to a change
        T = time constant - duration of the loop's reaction
    */
  }

  
  @Override
  protected void initialize() {
    setSetpointRelative(0);
  }

  
  @Override
  protected void execute() {
    setSetpoint(Robot.arm.wristThreshold);
    SmartDashboard.putNumber("Wrist Threshold", Robot.arm.wristThreshold);
  }

  @Override
  public void usePIDOutput(double output) {
    RobotMap.wristController.set(output);
    SmartDashboard.putNumber("PID Output Wrist", output);
  }

  @Override
  public double returnPIDInput() {
    return RobotMap.encoderWrist.getDistance();
  }
  
  @Override
  protected boolean isFinished() {
    return ((Math.abs(Robot.arm.wristThreshold) - Math.abs(RobotMap.encoderWrist.getDistance())) <= 0.01);
  }

  
  @Override
  protected void end() {
    RobotMap.wristController.set(0);
  }

  
  @Override
  protected void interrupted() {
    RobotMap.wristController.set(0);
  }
}
