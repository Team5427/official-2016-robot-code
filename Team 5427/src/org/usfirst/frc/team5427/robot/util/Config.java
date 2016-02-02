package org.usfirst.frc.team5427.robot.util;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

public class Config {
	//MISC
	public static final String NAME = "Team5427RoboCode";
	

	public static final boolean DEBUG_MODE = false; //displays 'Log.debug' in console
	public static final boolean LOGGING = true; //only logs errors, warnings and fatals with this false
	
	//Controls
	public static final int JOYSTICK_MODE = 0;
	public static final int ONE_JOYSTICK = 0;
	public static final int TWO_JOYSTICKS = 1;
	
	//Buttons
	public static final int TOGGLE_INTAKE_BUTTON = 2;
	public static final int TO_TILT_BUTTON=8;
	public static final int SHOOTER_BUTTON=1;
	
	
	//PORTS FOR VARIOUS THINGS
	public static final int FRONT_LEFT_MOTOR = 0;
	public static final int BACK_LEFT_MOTOR = 2;
	public static final int FRONT_RIGHT_MOTOR = 1;
	public static final int BACK_RIGHT_MOTOR = 3;
	public static final int JOYSTICK_PORT = 0;
	public static final int TILTER = 4;
	public static final int TURNER = 5;
	public static final int SHOOTER = 6;
	
	
	public static final int ALT_JOYSTICK_PORT = 0;
	
	//OPTIONS
	public static final double INTAKE_SPEED=0.5;
	public static final double LAUNCH_SPEED=0.5;


	}