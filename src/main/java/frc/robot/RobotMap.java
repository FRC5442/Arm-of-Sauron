/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.networktables.*;

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

  public static SpeedController leftController1, leftController2, leftController3;
	public static SpeedController rightController1, rightController2, rightController3;
  public static SpeedController corkController1, corkController2;
  public static SpeedController verticalController, wristController, armController;
  
  public static SpeedControllerGroup leftMotorControllers, rightMotorControllers, corkMotorControllers;
  
  public static Encoder EncoderLeft; 
  public static Encoder EncoderRight; 

  public static Compressor compressor;
  public static DoubleSolenoid gearShift;
  public static NetworkTable table;
  public static NetworkTableInstance inst;

  public RobotMap() {
    leftController1 = new WPI_VictorSPX(2);
    leftController2 = new WPI_VictorSPX(3);
  //  leftController3 = new WPI_VictorSPX(3);
    rightController1 = new WPI_VictorSPX(0);
    rightController2 = new WPI_VictorSPX(1);
   // rightController3 = new WPI_VictorSPX(2);
    corkController1 = new Spark(4);
    corkController2 = new Spark(5);
    verticalController = new Spark(6);
    wristController = new Spark(10);
    armController = new Spark(12);

    EncoderLeft = new Encoder(3, 4, false, Encoder.EncodingType.k4X);
    EncoderRight = new Encoder(5, 6, false, Encoder.EncodingType.k4X);


    leftMotorControllers = new SpeedControllerGroup(leftController1, leftController2/*, leftController3*/);
    rightMotorControllers = new SpeedControllerGroup(rightController1, rightController2/*, rightController3*/);
    corkMotorControllers = new SpeedControllerGroup(corkController1, corkController2);

    driveTrain = new DifferentialDrive(leftMotorControllers, rightMotorControllers);

    compressor = new Compressor();
    gearShift = new DoubleSolenoid(0, 1);
  }

}
