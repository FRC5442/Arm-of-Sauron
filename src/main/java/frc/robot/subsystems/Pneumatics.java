/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {
  
  static Compressor compressor;
  DoubleSolenoid gearShift;
  DoubleSolenoid wristSolenoid;
  DoubleSolenoid chopstick1Solenoid;

  public Pneumatics() {
    RobotMap.compressor.start();
    gearShift = RobotMap.gearShift;
    compressor = RobotMap.compressor;
  }

  public void toggleWristSolenoid(Value position) {
    RobotMap.wristSolenoid.set(position);
  }
  public void toggleChopstickSolenoid(Value position) {
    RobotMap.chopstickSolenoid.set(position);
  }

  public void toggleCompressor(){
    if (compressor.enabled()) {
      compressor.stop();
    }
    else {
      compressor.start();
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
