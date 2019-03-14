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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  public static DifferentialDrive driveTrain;
  public static boolean driveMode;
  public static double course_correction;
  public static double m_speed;



  public DriveTrain() {
    driveTrain = RobotMap.driveTrain;
    driveMode = true;
  }

  public static void drive(double leftSpeed, double rightSpeed) {
    course_correction = PiTable.getX();
    SmartDashboard.putNumber("Encoder for Wrist", course_correction);
    m_speed = 0.5;
    if(driveMode) {
      driveTrain.tankDrive(leftSpeed, rightSpeed);
    }
    else{
      driveTrain.curvatureDrive(0.25, course_correction, false);
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
