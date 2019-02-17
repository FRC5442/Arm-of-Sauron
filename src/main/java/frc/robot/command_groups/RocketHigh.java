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

public class RocketHigh extends CommandGroup {
  
  public RocketHigh() {
    int travelDistance = 3 - Robot.currentRocketMode.getLevel();
    addParallel(new _ElevatorUp(3.535 * Math.abs(travelDistance)));
    addParallel(new _ArmUp(0.25));

    Robot.currentRocketMode = Robot.RocketMode.HIGH;
  }
}