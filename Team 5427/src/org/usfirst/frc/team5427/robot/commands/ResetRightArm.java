//This should reset the arms to the zero position
package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class ResetRightArm extends Command {

	public ResetRightArm() {
		requires(Robot.doorOpener);

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized ResetArms");
	}

	// The correct current positions of the left and right arms
	// is used to determine how far the arms need to go back
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		Robot.doorOpener.setRightSpeed(-.5);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Robot.rightArmPot.get() > Config.ARM_START)
			return false;
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.doorOpener.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
