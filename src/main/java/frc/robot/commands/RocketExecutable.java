/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.OI;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.command_groups.*;

public class RocketExecutable extends Command {
  boolean toggle;
  CommandGroup hatchLow, hatchMiddle, hatchHigh, cargoLow, cargoMiddle, cargoHigh;
  public RocketExecutable() {
    toggle = true;
    hatchLow = new RocketHatchLow();
    hatchMiddle = new RocketHatchMiddle();
    hatchHigh = new RocketHatchHigh();
    cargoLow = new RocketCargoLow();
    cargoMiddle = new RocketCargoMiddle();
    cargoHigh = new RocketCargoHigh();
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.arm.heightToggle) {
      if (OI.getAButton() && !hatchLow.isRunning()) {
        hatchMiddle.cancel();
        hatchHigh.cancel();
        cargoLow.cancel();
        cargoMiddle.cancel();
        cargoHigh.cancel();
        hatchLow.start();
      }
      else if (OI.getBButton() && !hatchMiddle.isRunning()) {
        hatchLow.cancel();
        hatchHigh.cancel();
        cargoLow.cancel();
        cargoMiddle.cancel();
        cargoHigh.cancel();
        hatchMiddle.start();
      }
      else if (OI.getYButton()  && !hatchHigh.isRunning()) {
        hatchLow.cancel();
        hatchMiddle.cancel();
        cargoLow.cancel();
        cargoMiddle.cancel();
        cargoHigh.cancel();
        hatchHigh.start();
      }
    }
    
    if (!Robot.arm.heightToggle  && !cargoLow.isRunning()) {
      if (OI.getAButton()) {
        cargoMiddle.cancel();
        cargoHigh.cancel();
        hatchHigh.cancel();
        hatchLow.cancel();
        hatchMiddle.cancel();
        cargoLow.start();
      }
      else if (OI.getBButton() && !cargoMiddle.isRunning()) {
        cargoLow.cancel();
        cargoHigh.cancel();
        hatchHigh.cancel();
        hatchLow.cancel();
        hatchMiddle.cancel();
        cargoMiddle.start();
      }
      else if (OI.getYButton() && !cargoHigh.isRunning()) {
        cargoLow.cancel();
        cargoMiddle.cancel();
        hatchHigh.cancel();
        hatchLow.cancel();
        hatchMiddle.cancel();
        cargoHigh.start();
      }
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
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
