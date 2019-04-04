/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class _WristAuto extends Command {
  private double enc_distance;
  Command wristUp, wristDown;

  public _WristAuto(double distance) {
    enc_distance = distance;
    wristUp = new _WristUp(enc_distance);
    wristDown = new _WristDown(enc_distance);
  }

  @Override
	protected void execute() {
    if (RobotMap.encoderWrist.getDistance() > enc_distance) {
      wristUp.cancel();
      wristDown.start();
    }
    else if (RobotMap.encoderWrist.getDistance() < enc_distance) {
      wristDown.cancel();
      wristUp.start();
    }
    else {
      wristDown.cancel();
      wristUp.cancel();
    }
  }
	
	@Override
	protected boolean isFinished() {
    return RobotMap.encoderWrist.getDistance() < enc_distance - 0.05 || RobotMap.encoderWrist.getDistance() > enc_distance + 0.05;
    //Might need a conditional to finish this 
	}
	
	@Override
	protected void end() {
		Robot.arm.rotateWrist(0);
	}
}
