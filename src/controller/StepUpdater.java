package controller;

import model.MoveAgents;

/**
 * This class calls all the functions that have to be called when there is a new step
 * @author Robert Stevens
 *
 */
public class StepUpdater {
	
	public StepUpdater(MoveAgents moveAgents)
	{
		m_moveAgents = moveAgents;
	}
	
	/**
	 * Call all the functions that have to be called to generate the next step
	 */
	public void NextStep()
	{
	//TODO: add evrything here that has to be updated
		m_moveAgents.DoMove();
		m_stepNumber++;
	}
	
	public int getStepNumber(){
		return m_stepNumber;
	}
	private MoveAgents m_moveAgents;
	private int m_stepNumber;
}
