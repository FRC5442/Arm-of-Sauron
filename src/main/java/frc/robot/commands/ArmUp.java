package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmUp extends Command {

	public ArmUp() {
	}
	
	@Override
	protected void execute() {
		Robot.arm.rotateArm(1) ;
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		Robot.arm.rotateArm(0);
	}

}
