/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */

public class CorkScrew extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public CorkScrew() {
  }

  public void ScrewFront(double speedFront){
    RobotMap.corkControllerFront.set(speedFront);
  }

  public void ScrewBack(double speedBack){
    RobotMap.corkControllerBack.set(speedBack);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
