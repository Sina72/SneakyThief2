package model.commands;

import java.awt.Color;

/**
 * This stores all the possible states that the playfield can have. Stores colors with the states.
 * @author Robert Stevens, Stan Kerstjens
 *
 */
public enum GridState {
	//					Color					Moveable
	Empty			(	Color.WHITE, 			true		),
	Guard			(	Color.GREEN, 			false		),
	Intruder		(	Color.RED,				false		),
	Wall			(	Color.BLACK, 			false		),
	Sentry			(	Color.BLUE,				false		),
	SentryGuard		(	Color.CYAN,				false		),
	Shade 			(	Color.GRAY,				true		),
	ShadeGuard 		(	new Color(0,200,0),		false		),
	ShadeIntruder 	(	new Color(200,0,0),		false		),
	Window			(	Color.YELLOW,			false		),
	Door			(	new Color(102,51,0),	false		),
	Target			(	Color.ORANGE,			true		),
	TargetIntruder	(	Color.MAGENTA,			false		),
	TargetGuard		(	new Color(107,142,35),	false		),
	Tree			(	new Color(128,128,0),	false		),
	OuterWall		(	Color.DARK_GRAY,		false		);



	GridState(Color color, boolean moveable){
		this.color = color;
		m_moveable = moveable;
	}

	public Color color(){
		return color;
	}

	public boolean moveable(){
		return m_moveable;
	}

	Color color;
	private boolean m_moveable;
}
