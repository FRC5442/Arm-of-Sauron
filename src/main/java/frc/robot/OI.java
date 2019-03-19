/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.command_groups.*;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static Joystick xboxController1;
  public static Joystick xboxController2;
  public static JoystickButton xboxController1A, xboxController1B, xboxController1X, xboxController1Y;
  public static JoystickButton xboxController1LBumper, xboxController1RBumper;
  public static JoystickButton xboxController1LStickBtn, xboxController1RStickBtn;
  public static JoystickButton xboxController2A, xboxController2B, xboxController2X, xboxController2Y, xboxController2LBumper, xboxController2RBumper;
  public static JoystickButton xboxController2LStickBtn, xboxController2RStickBtn;
  public static JoystickButton xboxController2Start;

  public OI() {
//    Xbox Controller 1
    xboxController1 = new Joystick(0);
    xboxController1A = new JoystickButton(xboxController1, 1);
    xboxController1B = new JoystickButton(xboxController1, 2);
    xboxController1X = new JoystickButton(xboxController1, 3);
    xboxController1Y = new JoystickButton(xboxController1, 4);
    xboxController1LBumper = new JoystickButton(xboxController1, 5);
    xboxController1RBumper = new JoystickButton(xboxController1, 6);
    xboxController1LStickBtn = new JoystickButton(xboxController1, 9);
    xboxController1RStickBtn = new JoystickButton(xboxController1, 10);

//    Xbox Controller 2
    xboxController2 = new Joystick(1);
    xboxController2A = new JoystickButton(xboxController2, 1);
    xboxController2B = new JoystickButton(xboxController2, 2);
    xboxController2X = new JoystickButton(xboxController2, 3);
    xboxController2Y = new JoystickButton(xboxController2, 4);
    xboxController2LBumper = new JoystickButton(xboxController2, 5);
    xboxController2RBumper = new JoystickButton(xboxController2, 6);
    xboxController2Start = new JoystickButton(xboxController2, 8);
    xboxController2LStickBtn = new JoystickButton(xboxController2, 9);
    xboxController2RStickBtn = new JoystickButton(xboxController2, 10);

//    Xbox Controller 1

    xboxController1X.whenPressed(new ToggleCompressor());
    //xboxController1Y.whileHeld(new ElevatorDown());
    xboxController1LBumper.whileHeld(new ClimbDrive(1));
    xboxController1RBumper.whileHeld(new ClimbDrive(-1));

    xboxController1LStickBtn.whenPressed(new LowGear());
    xboxController1RStickBtn.whenPressed(new HighGear());

//    Xbox Controller 2
    xboxController2LBumper.whenPressed(new ToggleWristSolenoid());
    xboxController2RBumper.whenPressed(new ToggleChopstickSolenoid());
    xboxController2Start.whenPressed(new ToggleAutomation());
/*
    xboxController2A.whileHeld(new ElevatorUp());
    xboxController2B.whileHeld(new ElevatorDown());

    xboxController2X.whileHeld(new WristUp());
    xboxController2Y.whileHeld(new WristDown());

    xboxController2LStickBtn.whileHeld(new ArmUp());
    xboxController2RStickBtn.whileHeld(new ArmDown()); 
*/
    
    //xboxController2Start.whenPressed(new ClimbExecutable());
    xboxController2X.whenPressed(new RocketHeightToggle());
    xboxController2RStickBtn.whileHeld(new WristDown());
    xboxController2LStickBtn.whileHeld(new WristUp());
  }


  public static boolean getAButton() {
    return xboxController2.getRawButton(1);
  }
  public static boolean getBButton() {
    return xboxController2.getRawButton(2);
  }
  public static boolean getYButton() {
    return xboxController2.getRawButton(4);
  }
  public static boolean getXButton() {
    return xboxController2.getRawButton(3);
  }
}
