package model.commands;

import java.awt.Color;

/**
 * This stores all the possible states that the playfield can have. Stores colors with the states.
 * @author Robert Stevens, Stan Kerstjens
 *
 */
public enum GridState {
	//					Color				|	Moveable	|	State when Freed
	Empty			(	Color.WHITE, 			true,			null	),
	Guard			(	Color.GREEN, 			false,			Empty	),
	Intruder		(	Color.RED,				false,			Empty	),
	Wall			(	Color.BLACK, 			false,			Empty	),
	Sentry			(	Color.BLUE,				false,			Empty	),
	SentryGuard		(	Color.CYAN,				false,			Sentry	),
	Shade 			(	Color.GRAY,				true,			Empty	),
	ShadeGuard 		(	new Color(0,200,0),		false,			Shade	),
	ShadeIntruder 	(	new Color(200,0,0),		false,			Shade	),
	Window			(	Color.YELLOW,			false,			Empty	),
	Door			(	new Color(102,51,0),	false,			Empty	),
	Target			(	Color.ORANGE,			true,			Empty	),
	TargetIntruder	(	Color.MAGENTA,			false,			Target	),
	TargetGuard		(	new Color(107,142,35),	false,			Target	),
	Tree			(	new Color(128,128,0),	false,			Empty	),
	OuterWall		(	Color.DARK_GRAY,		false,			null	);



	GridState(Color color, boolean moveable, GridState freedState){
		this(color,moveable,freedState, null, null);
	}
	GridState(Color color, boolean moveable, GridState freedState, GridState enterGuard, GridState enterIntruder){
		this.color = color;
		m_moveable = moveable;
		m_freedState = freedState;
		m_guardState = enterGuard;
		m_intruderState = enterIntruder;
	}

	public Color color(){
		return color;
	}

	public boolean moveable(){
		return m_moveable;
	}

	public GridState stateWhenFreed(){
		return m_freedState;
	}

	Color color;
	private boolean m_moveable;
	private GridState m_freedState;
	private GridState m_guardState;
	private GridState m_intruderState;
}
