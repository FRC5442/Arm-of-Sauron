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
import com.kauailabs.navx.frc.AHRS;


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
  public static SpeedController corkControllerFront, corkControllerBack;
  public static SpeedController climbWheel;
  public static SpeedController verticalController, wristController, armController;
  
  public static SpeedControllerGroup leftMotorControllers, rightMotorControllers, corkMotorControllers;
  
  public static Encoder encoderArm, encoderVertical, encoderWrist, encoderScrewBack, encoderScrewFront;
  public static DigitalInput lowElevatorSwitch, highElevatorSwitch;
  public static AHRS navx;
 // public static PowerDistributionPanel pdp;


  public static Compressor compressor;
  public static DoubleSolenoid wristSolenoid;
  public static DoubleSolenoid chopstickSolenoid;
  public static DoubleSolenoid gearShift;
  public static NetworkTable table;
  public static NetworkTableInstance inst;

  public RobotMap() {
    leftController1 = new WPI_VictorSPX(10);
    leftController2 = new WPI_VictorSPX(11);
    leftController3 = new WPI_VictorSPX(12);
    rightController1 = new WPI_VictorSPX(7);
    rightController2 = new WPI_VictorSPX(8);
    rightController3 = new WPI_VictorSPX(9);
    corkControllerFront = new WPI_VictorSPX(2);
    corkControllerBack = new WPI_VictorSPX(3);
    climbWheel = new WPI_VictorSPX(1);
    verticalController = new WPI_VictorSPX(0);
    wristController = new WPI_VictorSPX(4);
    armController = new WPI_VictorSPX(6);


    encoderVertical = new Encoder(6, 7 ,true, Encoder.EncodingType.k4X);
    encoderVertical.setSamplesToAverage(5);
		encoderVertical.setDistancePerPulse(1.0/360);
    encoderArm = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    encoderArm.setSamplesToAverage(5);
		encoderArm.setDistancePerPulse(1.0/360);
    encoderWrist = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
    encoderWrist.setSamplesToAverage(5);
    encoderWrist.setDistancePerPulse(1.0/360);
    encoderScrewBack = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
    encoderWrist.setSamplesToAverage(5);
    encoderWrist.setDistancePerPulse(1.0/360);
    encoderScrewFront = new Encoder(8, 9, false, Encoder.EncodingType.k4X);
    encoderWrist.setSamplesToAverage(5);
    encoderWrist.setDistancePerPulse(1.0/360);

		navx = new AHRS(SerialPort.Port.kMXP);
		//pdp = new PowerDistributionPanel(1);

    lowElevatorSwitch = new DigitalInput(10);
    highElevatorSwitch = new DigitalInput(11);

    leftMotorControllers = new SpeedControllerGroup(leftController1, leftController2, leftController3);
    rightMotorControllers = new SpeedControllerGroup(rightController1, rightController2, rightController3);

    driveTrain = new DifferentialDrive(leftMotorControllers, rightMotorControllers);

    compressor = new Compressor();
    gearShift = new DoubleSolenoid(0, 1);
    wristSolenoid = new DoubleSolenoid(2,3);
    chopstickSolenoid = new DoubleSolenoid(4,5);
  }

}
