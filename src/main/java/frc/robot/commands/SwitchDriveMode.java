package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SwitchDriveMode extends Command {
	
	@Override
	protected void initialize() {
		Robot.SwitchDriveMode();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}