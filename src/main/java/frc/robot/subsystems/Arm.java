/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Add your docs here.
 */
public class Arm extends PIDSubsystem {
  public static boolean heightToggle;
  public static double armThreshold;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Arm() {
    super(1, 1, 1);
    heightToggle = true;
    armThreshold = 0;
  }

  public void rotateArm(double speed) {
    RobotMap.armController.set(.4*speed);
    armThreshold = RobotMap.encoderArm.getDistance();
  }
  
  public void moveElevator(double speed) {
    RobotMap.verticalController.set(speed);
  }

  public void rotateWrist(double speed) {
    RobotMap.wristController.set(.4*speed);
  }

  public void SwitchHeight() {
		heightToggle = !heightToggle;
	}

  public boolean getHeight() {
    return heightToggle;
  }

  public void usePIDOutput(double output) {
    RobotMap.armController.set(output);
  }

  public double returnPIDInput() {
    return armThreshold;  
  }

  @Override
  public void initDefaultCommand() {
 //   setDefaultCommand(new ArmExecutable());
  }
}
