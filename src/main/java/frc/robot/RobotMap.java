/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.VictorSP;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  public static DifferentialDrive driveTrain;
  public static VictorSPX leftController1;
	public static VictorSPX leftController2;
	public static VictorSPX leftController3;
	public static VictorSPX rightController1;
	public static VictorSPX rightController2;
  public static VictorSPX rightController3;

  public RobotMap() {
    leftController1 = new VictorSPX(1);
    leftController2 = new VictorSPX(2);
    leftController3 = new VictorSPX(3);
    rightController1 = new VictorSPX(4);
    rightController2 = new VictorSPX(5);
    rightController3 = new VictorSPX(6);

    SpeedControllerGroup leftMotorControllers = new SpeedControllerGroup((SpeedController) leftController1, (SpeedController) leftController2, (SpeedController) leftController3);
    SpeedControllerGroup rightMotorControllers = new SpeedControllerGroup((SpeedController) rightController1, (SpeedController) rightController2, (SpeedController) rightController3);

    driveTrain = new DifferentialDrive(leftMotorControllers, rightMotorControllers);


  }

}
