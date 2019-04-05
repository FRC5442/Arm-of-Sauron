/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.command_groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.*;

public class RocketHatchMiddle extends CommandGroup {
  
  public RocketHatchMiddle() {
    if (RobotMap.encoderVertical.getDistance() < 7.8) {
      addParallel(new _ElevatorUp(7.8));
    }
    else {
      addParallel(new _ElevatorDown(7.8));
    }
  }
}
