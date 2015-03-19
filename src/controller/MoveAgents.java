package controller;

import java.util.List;

import model.Agent;
import model.Constants;
import model.Guard;
import model.commands.Coordinates;
import model.commands.Move;

public class MoveAgents {
	public MoveAgents(List<Guard> guards)
	{
		ml_guards = guards;
	}
	
	public void DoMove()
	{
		for (int i = 0; i < ml_guards.size(); i++)
		{
			Agent agent = ml_guards.get(i);
			CalcMove(agent);
			
		}
	}
	
	private Coordinates CalcMove(Agent agent){
		Move move = agent.getMove();
		Coordinates coords = agent.getCoordinates();
		double distance = move.getSpeed()*Constants.STEP_LENGTH;
		//TODO: calculate the new coordinates
		double angle = (coords.getAngle() + move.getAngle()) % (2*Math.PI);
		return null;
	}
	
	private List<Guard> ml_guards;
}
