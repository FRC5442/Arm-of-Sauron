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
public class Arm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Arm() {
    
  }

  public void rotateArm(double speed) {
		RobotMap.armController.set(.4*speed);
  }
  
  public void moveElevator(double speed) {
    RobotMap.verticalController.set(.4*speed);
  }

  public void rotateWrist(double speed) {
    RobotMap.wristController.set(.4*speed);
  }

  @Override
  public void initDefaultCommand() {
 //   setDefaultCommand(new ArmExecutable());
  }
}
