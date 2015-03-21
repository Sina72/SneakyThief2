package controller;

import java.util.List;

import model.Agent;
import model.Constants;
import model.Guard;
import model.Map;
import model.commands.Coordinates;
import model.commands.GridState;
import model.commands.Move;

public class MoveAgents {
	private boolean m_debug = true;
	public MoveAgents(List<Guard> guards, Map map)
	{
		ml_guards = guards;
		m_map = map;
	}

	public void DoMove()
	{
		for (int i = 0; i < ml_guards.size(); i++)
		{
			Agent agent = ml_guards.get(i);
			Coordinates newcoords = CalcMove(agent);
			ExecMove(agent, newcoords);

		}
	}

	private Coordinates CalcMove(Agent agent){
		Move move = agent.getMove();
		Coordinates coords = new Coordinates(
				agent.getCoordinates().getX(),
				agent.getCoordinates().getY(),
				agent.getCoordinates().getAngle());
		double distance = move.getSpeed()*Constants.STEP_LENGTH;
		int tiles = (int)(float)(distance/Constants.CELL_SIZE);

		double angle = (coords.getAngle() + move.getAngle()) % (2*Math.PI);

		int x = coords.getX() + move.right();
		int y = coords.getY() + move.top();

		if(m_debug){
			System.out.println("Relative move right: " + move.right());
			System.out.println("Relative move top: " + move.top());
			System.out.println("new x: " + x);
			System.out.println("new y: " + y);
		}

		coords.setCoordinates(x, y, angle);

		if(m_debug) reportMove(agent, distance, tiles, coords, angle);

		return coords;
	}

	private void reportMove(Agent agent, double distance, int tiles, Coordinates coords, double angle){
		System.out.println("");
		System.out.println("Base Coords " + agent.getCoordinates().getX() + ", " + agent.getCoordinates().getY() + ", " + agent.getCoordinates().getAngle());
		System.out.println("angle " + angle + ", distance "+ distance + " tiles " + tiles);
		System.out.println("New Coords " + coords.getX() + ", " + coords.getY() + ", " + coords.getAngle());
	}

	/**
	 * Move the agent to its new position
	 * @param agent The agent witch has to move
	 * @param newcoords The new position
	 */
	private void ExecMove(Agent agent, Coordinates newcoords) {
		agent.getCoordinates().setAngle(newcoords.getAngle());

		/* if the agent also moved to a other position move him there */
		if (isPathFree(agent.getCoordinates(), newcoords)
				&&
				setPosition(agent, newcoords)){
			freePosition(agent.getCoordinates());
			agent.getCoordinates().setCoordinates(
					newcoords.getX(),
					newcoords.getY(),
					newcoords.getAngle());
		}
	}

	/**
	 * Check if a position is free
	 * @param coords the coordinates of the position
	 * @return true is free else false
	 */
	private boolean isPositionFree(Coordinates coords){
		GridState state = m_map.getMap()[coords.getX()][coords.getY()];
		return state.moveable();
	}


	private boolean isPathFree(Coordinates begin, Coordinates end){

		int xtrack = begin.getX(), ytrack = begin.getY();

		int xdir = Integer.signum(end.getX() - begin.getX()),		//X move direction
				ydir =	Integer.signum(end.getY() - begin.getY());	//Y move direction

		while(xtrack != end.getX() || ytrack != end.getY()){
			if(xtrack != end.getX()) xtrack += xdir;
			if(ytrack != end.getY()) ytrack += ydir;
			if(!isPositionFree(new Coordinates(xtrack, ytrack)))
				return false;
		}

		return true;
	}

	/**
	 * Remove an agent from a position
	 * @param coords the coordinates of the position
	 */
	private void freePosition(Coordinates coords){
		GridState state = m_map.getMap()[coords.getX()][coords.getY()];
		GridState newState = state.stateWhenFreed();

		if(newState == null)
			System.err.println("Cannot free an empty GridState");

		m_map.getMap()[coords.getX()][coords.getY()] = newState;
	}

	/**
	 * Put an agent on a tile
	 * @param agent the agent
	 * @param coords the new coordinates
	 * @return true on success else false
	 */
	private boolean setPosition(Agent agent, Coordinates coords){
		boolean isGuard = agent instanceof Guard;
		GridState state = m_map.getMap()[coords.getX()][coords.getY()];
		GridState newState = GridState.Empty;

		//TODO: add all other relevant cases
		if (isGuard)
			switch (state){
			case Empty: newState = GridState.Guard;
			break;
			case Target: newState = GridState.TargetGuard;
			break;
			case Sentry: newState = GridState.SentryGuard;
			break;
			default: System.err.println("The input for freePosition is incorrect");
			return false;
			}
		else
			switch (state){
			case Empty: newState = GridState.Intruder;
			break;
			case Target: newState = GridState.TargetIntruder;
			break;
			case Sentry: System.err.println("An intruder cant enter a sentry");
			return false;
			default: System.err.println("The input for setPosition is incorrect");
			return false;
			}

		m_map.getMap()[coords.getX()][coords.getY()] = newState;
		return true;

	}

	private List<Guard> ml_guards;
	private Map m_map;
}
