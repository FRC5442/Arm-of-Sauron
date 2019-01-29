package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmDown extends Command {

	public ArmDown() {
	}
	
	@Override
	protected void execute() {
		Robot.arm.doArm(-OI.joystickController2.getRawAxis(1)) ;
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.arm.doArm(0);
	}

}
