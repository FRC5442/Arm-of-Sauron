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
  public static boolean driveMode;
  public static double course_correction;


  public DriveTrain() {
    if (RobotMap.driveTrain != null) driveTrain = RobotMap.driveTrain;
 //   course_correction = PiTable.getX();
    driveMode = true;
  }

  public static void drive(double leftSpeed, double rightSpeed) {
    if(driveMode) {
      driveTrain.tankDrive(leftSpeed, rightSpeed);
    }
    else{
      driveTrain.arcadeDrive(leftSpeed, course_correction);
    }
  }
 
  public void SwitchDriveMode() {
		driveMode = !driveMode;
	}

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }
}
