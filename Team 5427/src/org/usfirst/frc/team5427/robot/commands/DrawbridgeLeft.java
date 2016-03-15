//This should automatically move the arm to grab the door.  
//I do not know if we want the wheels to move automatically 
//to get around this obstacle, but I do not think so
package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class DrawbridgeLeft extends Command {

	public DrawbridgeLeft() {
		requires(Robot.leftArm);

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized DrawbridgeLeft");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		new DrawbridgeLeftReset();
		new DrawbridgeLeftGo();

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.leftArm.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
