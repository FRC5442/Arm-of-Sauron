/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.command_groups;

import frc.robot.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RocketMiddleToggle extends CommandGroup {
  /**
   * Add your docs here.
   */
  public RocketMiddleToggle() {
    if(Robot.arm.heightToggle) {
      addSequential(new RocketHatchMiddle());
    }
    else {
      addSequential(new RocketCargoMiddle());
    }
  }
}
