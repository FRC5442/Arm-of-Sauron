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
    //addParallel(new _ElevatorUp(7.6));

    //if(RobotMap.encoderArm.getDistance() > 1.5) {
     //addParallel(new _ArmDown(1.5));
    //}
    //else {
     addParallel(new _ArmUp(3.5));
    //}
  }
}
