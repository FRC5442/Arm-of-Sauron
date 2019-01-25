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

/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {
  
  Compressor compressor;
  DoubleSolenoid gearShift;

  public Pneumatics() {
    compressor = RobotMap.compressor;
    compressor.start();
    gearShift = RobotMap.gearShift;
  }

  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
