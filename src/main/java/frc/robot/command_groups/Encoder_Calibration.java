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
import edu.wpi.first.wpilibj.smartdashboard.*;

public class Encoder_Calibration extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Encoder_Calibration() {
    addSequential(new ElevatorDown());
    double encoderValue0 = RobotMap.encoderVertical.getDistance();
    addSequential(new ElevatorUp());
    double encoderValue1 = RobotMap.encoderVertical.getDistance();

    SmartDashboard.putNumber("Mast encoder range", (encoderValue1 - encoderValue0));
  }
}
