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

public class RocketCargoLow extends CommandGroup {
  
  public RocketCargoLow() {
    if(RobotMap.encoderVertical.getDistance() > 2.2) {
      addSequential(new _ElevatorDown(2.2));
    }
    else{
      addSequential(new _ElevatorUp(2.2));
    }
  }
}