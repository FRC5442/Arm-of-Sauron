/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.TankDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  public static DifferentialDrive driveTrain;

  public DriveTrain() {
    if (RobotMap.driveTrain != null) driveTrain = RobotMap.driveTrain;
  }

  public static void drive(double leftSpeed, double rightSpeed) {
    System.out.println(leftSpeed);
    driveTrain.tankDrive(leftSpeed, rightSpeed);
  }
 
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }
}
