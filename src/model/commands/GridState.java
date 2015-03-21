package model.commands;

import java.awt.Color;

/**
 * This stores all the possible states that the playfield can have. Stores colors with the states.
 * @author Robert Stevens, Stan Kerstjens
 *
 */
public enum GridState {
	Empty			(Color.WHITE),
	Guard			(Color.GREEN),
	Intruder		(Color.RED),
	Wall			(Color.BLACK),
	Sentry			(Color.BLUE),
	SentryGuard		(Color.CYAN),
	Shade 			(Color.GRAY),
	ShadeGuard 		(new Color(0,200,0)),
	ShadeIntruder 	(new Color(200,0,0)),
	Window			(Color.YELLOW),
	Door			(new Color(102,51,0)),
	Target			(Color.ORANGE),
	TargetIntruder	(Color.MAGENTA),
	TargetGuard		(new Color(107,142,35)),
	Tree			(new Color(128,128,0)),
	OuterWall		(Color.DARK_GRAY);
	
	
	Color color;
	GridState(Color color){
		this.color = color;
	}
	
	public Color color(){
		return color;
	}
	
	}
