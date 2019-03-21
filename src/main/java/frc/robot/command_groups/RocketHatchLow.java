/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.command_groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class RocketHatchLow extends CommandGroup {
  
  public RocketHatchLow() {
    addSequential(new _ElevatorDown(0.1));
    addSequential(new _ArmDown(0.2));
    addSequential(new ResetEncoders());
  }
}
