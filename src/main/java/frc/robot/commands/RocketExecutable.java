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
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.command_groups.*;
import frc.robot.subsystems.CorkScrew;

public class RocketExecutable extends Command {
  boolean toggle;
  Command screwBackUp, screwFrontUp, screwBothDown;
  Command armUp, armDown, elevatorUp, elevatorDown;
  CommandGroup hatchLow, hatchMiddle, hatchHigh, cargoLow, cargoMiddle, cargoHigh;
  public RocketExecutable() {
    hatchLow = new RocketHatchLow();
    hatchMiddle = new RocketHatchMiddle();
    hatchHigh = new RocketHatchHigh();
    cargoLow = new RocketCargoLow();
    cargoMiddle = new RocketCargoMiddle();
    cargoHigh = new RocketCargoHigh();
    armUp = new ArmUp();
    armDown = new ArmDown();
    elevatorUp = new ElevatorUp();
    elevatorDown = new ElevatorDown();
    screwBackUp = new ScrewBackCom(0.85);
    screwFrontUp = new ScrewFrontCom(0.85);
    screwBothDown = new ScrewBothDown();
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.arm.heightToggle && Robot.arm.automationToggle && !Robot.corkScrew.climbMode) {
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
    
    if (!Robot.arm.heightToggle && Robot.arm.automationToggle && !Robot.corkScrew.climbMode) {
      if (OI.getAButton() && !cargoLow.isRunning()) {
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
    if (!Robot.arm.automationToggle && !Robot.corkScrew.climbMode) {
      if (!OI.getAButton() && armUp.isRunning()) {
        armUp.cancel();
      }
      else if (!OI.getBButton() && armDown.isRunning()) {
        armDown.cancel();
      }
      else if (!OI.getYButton() && elevatorUp.isRunning()) {
        elevatorUp.cancel();
      }
      else if (!OI.getXButton() && elevatorDown.isRunning()) {
        elevatorDown.cancel();
      }
      else if (OI.getAButton() && !armUp.isRunning()) {
        armDown.cancel();
        armUp.start();
      }
      else if (OI.getBButton() && !armDown.isRunning()) {
        armUp.cancel();
        armDown.start();
      }
      else if (OI.getYButton() && !elevatorUp.isRunning()) {
        elevatorDown.cancel();
        elevatorUp.start();
      }
      else if (OI.getXButton() && !elevatorDown.isRunning()) {
        elevatorUp.cancel();
        elevatorDown.start();
      }
    }

    SmartDashboard.putBoolean("Exe Climb-Mode", Robot.corkScrew.climbMode);

    if(Robot.corkScrew.climbMode) {
      if (!OI.getAButton() && screwBackUp.isRunning()) {
        screwBackUp.cancel();
      }
      else if (!OI.getBButton() && screwFrontUp.isRunning()) {
        screwFrontUp.cancel();
      }
      else if (!OI.getYButton() && screwBothDown.isRunning()) {
        screwBothDown.cancel();
      }
      else if (OI.getAButton() && !screwBackUp.isRunning()) {
        screwBackUp.start();
      }
      else if (OI.getBButton() && !screwFrontUp.isRunning()) {
        screwFrontUp.start();
      }
      else if (OI.getYButton() && !screwBothDown.isRunning()) {
        screwBothDown.start();
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
