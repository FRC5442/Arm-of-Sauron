package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.*;

public class PiTable extends Subsystem{
	static NetworkTableEntry entry1;
	static NetworkTableEntry entry2;
	static NetworkTable piTable = RobotMap.table;
	static double X;
	static double X1;
	static double X2;
	
	public static double getX(){
		entry1 = piTable.getEntry("course_correction");
		entry2 = piTable.getEntry("course_correction1");
		X1 = entry1.getDouble(0);
		X2 = entry2.getDouble(0);
		X2 =+ 0.05;
		X = (X2 + X1) / 2;
		return X;
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
}
