package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.*;

public class PiTable extends Subsystem{
    static NetworkTableEntry entry;
	static NetworkTable piTable = RobotMap.table;
    static double defaultvalue = 0;
    static double X;
	
	public static double getX(){
        entry = piTable.getEntry("course_correction");
        entry.setDouble(X);
        System.out.println(X);
        
		return X;
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
}
