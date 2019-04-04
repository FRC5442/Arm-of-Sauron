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
  public static boolean climbMode;

  public CorkScrew() {
    climbMode = false;
  }

  public void ScrewFront(double speedFront){
    RobotMap.corkControllerFront.set(speedFront);
  }

  public void ScrewBack(double speedBack){
    RobotMap.corkControllerBack.set(speedBack);
  }

  public void moveWheel(double speed){
    RobotMap.climbWheel.set(speed);
  }

  public void resetStuff() {
    RobotMap.encoderScrewFront.reset();
    RobotMap.encoderScrewBack.reset();
  }

  
  public void ClimbMode() {
    climbMode = !climbMode;
  }

  public void ClimbModeFalse() {
    climbMode = false;
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
