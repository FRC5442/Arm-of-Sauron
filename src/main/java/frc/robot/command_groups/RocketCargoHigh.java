/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.command_groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.*;

public class RocketCargoHigh extends CommandGroup {
  
  public RocketCargoHigh() {
  //  int travelDistance = Math.abs(3 - Robot.currentRocketMode.getLevel());
    addParallel(new _ElevatorUp(7.6));
    addParallel(new _ArmUp(4.5));

 //   Robot.currentRocketMode = Robot.RocketMode.HIGH;
  }
}