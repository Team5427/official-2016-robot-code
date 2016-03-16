package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.network.Client;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class AutoShoot extends Command{

	/**
	 * automatically launches a boulder if there is a goal in sight
	 */
	public AutoShoot() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.launcher);
	}

	@Override
	protected void initialize() {
		Log.init("initialized Shoot");
		Robot.launcher.setShootSpeed(Config.LAUNCH_SPEED);		
	}

	@Override
	protected void execute() {
		new Turn_Programmed(Client.lastRecievedGoal.getHorizontalAngle());
		new GetStuffIn();
		Robot.launcher.setShootSpeed(Config.LAUNCH_SPEED);
		
	}

	@Override
	protected boolean isFinished() {
		if(!Robot.oi.getJoy().getRawButton(Config.SHOOT_BUTTON)) return true;
		else return false;
	}

	@Override
	protected void end() {
		Robot.launcher.stopShoot();	
		Robot.intake.stop();
		new Turn_Programmed(0);
	}

	@Override
	protected void interrupted() {
		
	}
	
}
