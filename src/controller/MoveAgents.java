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
	
	
	private void ExecMove(Agent agent, Coordinates newcoords) {
		//TODO: this function should be rewritten it doesn't check anything and it frees up the fields instead of returning them to there original state
		if (m_map.getMap()[newcoords.getX()][newcoords.getY()] == GridState.Empty){
			m_map.getMap()[agent.getCoordinates().getX()][agent.getCoordinates().getY()] = GridState.Empty;
			agent.getCoordinates().setCoordinates(newcoords.getX(), newcoords.getY(), newcoords.getAngle());
			m_map.getMap()[agent.getCoordinates().getX()][agent.getCoordinates().getY()] = GridState.Guard;
		}
		
		
	}
	
	private List<Guard> ml_guards;
	private Map m_map;
}
