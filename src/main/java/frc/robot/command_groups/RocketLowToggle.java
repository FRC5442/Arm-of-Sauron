/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.command_groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.*;
import frc.robot.subsystems.Arm;

public class RocketLowToggle extends CommandGroup {
  /**
   * Add your docs here.
   */
  public RocketLowToggle() {
    if(Arm.heightToggle) {
      addSequential(new RocketHatchLow());
    }
    else {
      addSequential(new RocketCargoLow());
    }
  }
}
