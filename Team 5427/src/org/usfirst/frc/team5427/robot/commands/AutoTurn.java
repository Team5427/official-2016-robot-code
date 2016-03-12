//this command is given a distance(in meters) and uses full speed to travel the distance
package org.usfirst.frc.team5427.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

/**
 * this class constantly inputs the Joystick axis into the driveTrain file, causing the robot to move.
 */
public class AutoTurn extends Command {

	private boolean right;
	
	public AutoTurn(double degrees, boolean right) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		if(right)
			super.setTimeout(degrees*Config.FULL_TURN_SPEED_RIGHT/360);
		else
			super.setTimeout(degrees*Config.FULL_TURN_SPEED_LEFT/360);
		this.right=right;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized Drive");
	}

	// Called repeatedly when this Command is scheduled to run

	@SuppressWarnings("all")
	protected void execute() {
		if(right)
		{
				Robot.driveTrain.setLeftSpeed(1);
				Robot.driveTrain.setRightSpeed(-1);
		}	
		else
		{
			Robot.driveTrain.setLeftSpeed(-1);
			Robot.driveTrain.setRightSpeed(1);
		}
			
			
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(isTimedOut())
			return true;
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
