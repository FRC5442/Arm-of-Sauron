/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  public static Joystick xboxController1;
  public static Joystick xboxController2;
  public static JoystickButton xboxController1A, xboxController1B, xboxController1X, xboxController1Y;
  public static JoystickButton xboxController1LBumper, xboxController1RBumper;
  public static JoystickButton xboxController2A, xboxController2B, xboxController2X, xboxController2Y, xboxController2LBumper, xboxController2RBumper;


  public OI() {
    //Xbox Controller 1
    xboxController1 = new Joystick(0);
    xboxController1A = new JoystickButton(xboxController1, 1);
    xboxController1B = new JoystickButton(xboxController1, 2);
    xboxController1X = new JoystickButton(xboxController1, 3);
    xboxController1Y = new JoystickButton(xboxController1, 4);
    xboxController1LBumper = new JoystickButton(xboxController1, 5);
    xboxController1RBumper = new JoystickButton(xboxController1, 6);

    //Xbox Controller 2
    xboxController2 = new Joystick(1);
    xboxController2A = new JoystickButton(xboxController2, 1);
    xboxController2B = new JoystickButton(xboxController2, 2);
    xboxController2X = new JoystickButton(xboxController2, 3);
    xboxController2Y = new JoystickButton(xboxController2, 4);
    xboxController2LBumper = new JoystickButton(xboxController2, 5);
    xboxController2RBumper = new JoystickButton(xboxController2, 6);

    //Xbox Controller 1
    xboxController1RBumper.whileHeld(new ScrewFrontCom(0.5)); //+ means bring front or back up
    xboxController1LBumper.whileHeld(new ScrewBackCom(0.5));
    xboxController1X.whileHeld(new ArmDown());
    xboxController1Y.whileHeld(new ArmUp());

//    xboxController1X.whenPressed(new ToggleCompressor());

    //Xbox Controller 1
    xboxController2LBumper.whenPressed(new ToggleChopstickSolenoid());
    xboxController2RBumper.whenPressed(new ToggleWristSolenoid());

    xboxController2A.whileHeld(new ElevatorUp());
    xboxController2B.whileHeld(new ElevatorDown());

    xboxController2X.whileHeld(new WristUp());
    xboxController2Y.whileHeld(new WristDown());

    
  }

}
