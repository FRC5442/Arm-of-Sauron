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
    hatchLow = new CommandGroup();
    hatchMiddle = new CommandGroup();
    hatchHigh = new CommandGroup();
    cargoLow = new CommandGroup();
    cargoMiddle = new CommandGroup();
    cargoHigh = new CommandGroup();
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
     // hatchLow.start();
     OI.xboxController2A.whenPressed(hatchLow); 
     System.out.println("hatchLow");
    }
    else if (Robot.arm.heightToggle) {
      //OI.xboxController2B.whenPressed(hatchMiddle);
      //hatchMiddle.start();
      System.out.println("hatchMiddle");
    }
    else if (Robot.arm.heightToggle) {
    //  OI.xboxController2Y.whenPressed(hatchHigh);
      //hatchHigh.start();
      System.out.println("hatchHigh");
    }
    else if (!Robot.arm.heightToggle) {
      //OI.xboxController2Y.whenPressed(cargoLow);
      //cargoLow.start();
      System.out.println("cargoLow");
    }
    else if (!Robot.arm.heightToggle) {
      //OI.xboxController2B.whenPressed(cargoMiddle);
      //cargoMiddle.start();
      System.out.println("cargoMiddle");
    }
    else if (!Robot.arm.heightToggle) {
      //OI.xboxController2Y.whenPressed(cargoHigh);
      //cargoHigh.start();
      System.out.println("cargoHigh");
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
