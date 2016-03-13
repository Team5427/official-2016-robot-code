package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.SteelTalon;
import org.usfirst.frc.team5427.robot.util.Config;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This Subsystem will be responsible for managing all four SIM motors that are
 * responsible for controlling the wheels. //TODO expand on this description
 * once more is known about the robot.
 * 
 * @author Andrew Kennedy, Bo Corman
 */
public class DriveTrain extends Subsystem {

	SpeedController motorPWM_FrontLeft;
	SpeedController motorPWM_RearLeft;
	SpeedController motorPWM_FrontRight;
	SpeedController MOTOR_PWM_BackRight;

	/**
	 * Drivetrain constructor -- as parameters takes each motor to initialise.
	 * 
	 * @param motorPWM_FrontLeft
	 * @param motorPWM_RearLeft
	 * @param motorPWM_FrontRight
	 * @param motorPWM_BackRight
	 */
	public DriveTrain(SpeedController motorPWM_FrontLeft, SpeedController motorPWM_RearLeft,
			SpeedController motorPWM_FrontRight, SpeedController motorPWM_BackRight) {
		this.motorPWM_FrontLeft = motorPWM_FrontLeft;
		this.motorPWM_RearLeft = motorPWM_RearLeft;
		this.motorPWM_FrontRight = motorPWM_FrontRight;
		this.MOTOR_PWM_BackRight = motorPWM_BackRight;
	}

	@Override
	protected void initDefaultCommand() {

	}

	/**
	 * Sets the speed of the left motors on the drive train.
	 * 
	 * @param speed
	 *            - the speed you want to set
	 */
	public void setLeftSpeed(double speed) {
		motorPWM_FrontLeft.set(speed);
		motorPWM_RearLeft.set(speed);
	}

	/**
	 * Sets the speed of the right motors on the drive train.
	 * 
	 * @param speed
	 *            - the speed you want to set
	 */
	public void setRightSpeed(double speed) {
		motorPWM_FrontRight.set(speed);
		MOTOR_PWM_BackRight.set(speed);
	}

	/**
	 * Sets the speed of all motors to 0
	 */
	public void stop() {
		setLeftSpeed(0);
		setRightSpeed(0);
	}

	/**
	 * sets the left and right stick in occordance with the joystick inputs for
	 * a single joystick
	 * 
	 * @param joyX
	 *            - X axis of joystick
	 * @param joyY
	 *            - Y axis of joystick
	 */
	public void driveJoystick(double joyX, double joyY) {

		double leftSpeed = (-1 * joyY) + joyX;
		double rightSpeed = (-1 * joyY) - joyX;

		rightSpeed = 0 - rightSpeed;
		double max = Math.abs(leftSpeed);
		if (max < Math.abs(rightSpeed))
			max = Math.abs(rightSpeed);
		if (max > 1) {
			leftSpeed = leftSpeed / max;
			rightSpeed = rightSpeed / max;
		}
		Robot.driveTrain.setLeftSpeed(leftSpeed);
		Robot.driveTrain.setRightSpeed(rightSpeed);

	}

	/**
	 * sets the left and right stick in occordance with the joystick inputs for
	 * dual joysticks
	 * 
	 * @param y
	 *            - Y axis of left joystick
	 * @param y2
	 *            - Y axis of right joystick
	 */
	public void driveDualJoystick(double y, double y2) {

		double leftSpeed = y;
		double rightSpeed = y2;
		Robot.driveTrain.setLeftSpeed(leftSpeed);
		Robot.driveTrain.setRightSpeed(rightSpeed);

	}

}
