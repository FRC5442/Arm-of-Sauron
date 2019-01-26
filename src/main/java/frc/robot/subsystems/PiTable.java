package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.*;

public class PiTable extends Subsystem{
    static NetworkTableEntry entry;
	static NetworkTable piTable = RobotMap.table;
    static double X;
	
	public static double getX(){
		entry = piTable.getEntry("course_correction");
		X = entry.getDouble(0);
		System.out.println(X);
		return X;
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
