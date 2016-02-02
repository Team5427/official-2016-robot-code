package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class Tilt extends Command {

	public Tilt() {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.launcher);
    }
	
	// Called just before this Command runs the first time
	protected void initialize() {
        Log.info("initialized tilter");
    }
	
// Called repeatedly when this Command is scheduled to run
    
    protected void execute() {
    	//sets the speed of the turning motor
    	Robot.launcher.setTiltSpeed(-1*Robot.oi.getJoy().getY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.launcher.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

}
