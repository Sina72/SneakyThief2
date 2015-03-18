package controller;

import model.MoveAgents;

public class StepUpdater {
	public StepUpdater(MoveAgents moveAgents)
	{
		m_moveAgents = moveAgents;
	}
	
	public void NextStep()
	{
	//TODO: add evrything here that has to be updated
		m_moveAgents.DoMove();
	}
	
	private MoveAgents m_moveAgents;
	private int m_stepNumber;
}
