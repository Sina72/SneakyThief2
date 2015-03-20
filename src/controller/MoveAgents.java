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
		Coordinates coords = new Coordinates(agent.getCoordinates().getX(),agent.getCoordinates().getY(),agent.getCoordinates().getAngle());
		double distance = move.getSpeed()*Constants.STEP_LENGTH;
		//TODO: calculate the new coordinates
		double angle = (coords.getAngle() + move.getAngle()) % (2*Math.PI);
		
		coords.setCoordinates(coords.getX()+1, coords.getY(), coords.getAngle());
		
		if(m_debug) System.out.println("");
		if(m_debug) System.out.println("Base Coords " + agent.getCoordinates().getX() + ", " + agent.getCoordinates().getY() + ", " + agent.getCoordinates().getAngle());
		if(m_debug) System.out.println("angle " + angle + ", distence "+ distance);
		if(m_debug) System.out.println("New Coords " + coords.getX() + ", " + coords.getY() + ", " + coords.getAngle());
		
		return coords;
		//return null;
	}
	
	
	/**
	 * Move the agent to its new position
	 * @param agent The agent witch has to move
	 * @param newcoords The new position
	 */
	private void ExecMove(Agent agent, Coordinates newcoords) {
		if (isPositionFree(newcoords) && setPosition(agent, newcoords)){
			freePosition(agent.getCoordinates());
			agent.getCoordinates().setCoordinates(newcoords.getX(), newcoords.getY(), newcoords.getAngle());
		}
		
		
	}
	
	/**
	 * Check if a position is free
	 * @param coords the coordinates of the position
	 * @return true is free else false
	 */
	private boolean isPositionFree(Coordinates coords){
		GridState state = m_map.getMap()[coords.getX()][coords.getY()];
		
		//TODO: add all options witch apply here
		if (state == GridState.Empty || state == GridState.Sentry || state == GridState.Shade)
			return true;
		return false;
	}
	
	/**
	 * Remove an agent from a position
	 * @param coords the coordinates of the position
	 */
	private void freePosition(Coordinates coords){
		GridState state = m_map.getMap()[coords.getX()][coords.getY()];
		GridState newState = GridState.Empty;
		
		//TODO: add all other relevant cases
		switch (state){
		case Empty: System.err.println("you cant empty an empty spot");
			break;
		case Guard:
		case Intruder: newState = GridState.Empty;
			break;
		case TargetGuard:
		case TargetIntruder: newState = GridState.Target;
			break;
		case SentryGuard: newState = GridState.Sentry;
			break;
		default: System.err.println("The input for freePosition is incorrect");
			break;
		}
		
		m_map.getMap()[coords.getX()][coords.getY()] = newState;
	}
	
	/**
	 * Put an agent on a tile
	 * @param agent the agent
	 * @param coords the new coordinates
	 * @return true on success else false
	 */
	private boolean setPosition(Agent agent, Coordinates coords){
		 boolean isGuard = true; //TODO: get this from the agent
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
