/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem {
  public static boolean automationToggle;
  public static boolean heightToggle;
  public static double armThreshold;
  public static double wristThreshold;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Arm() {
    automationToggle = true;
    heightToggle = true;
    armThreshold = 0;
    wristThreshold = 0;
  }

  public void rotateArm(double speed) {
    RobotMap.armController.set(speed);
    armThreshold = RobotMap.encoderArm.getDistance();
  }
  
  public void moveElevator(double speed) {
    RobotMap.verticalController.set(speed);
  }

  public void rotateWrist(double speed) {
    RobotMap.wristController.set(-speed);
    wristThreshold = RobotMap.encoderWrist.getDistance();
  }

  public void SwitchHeight() {
		heightToggle = !heightToggle;
  }
  
  public void SwitchAutomation() {
		automationToggle = !automationToggle;
  }
  
  public void resetStuff() {
    armThreshold = 0;
    wristThreshold = 0;
    RobotMap.encoderArm.reset();
    RobotMap.encoderWrist.reset();
    RobotMap.encoderVertical.reset();
  }

  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new ArmPID());
    setDefaultCommand(new RocketExecutable());
  }
}
