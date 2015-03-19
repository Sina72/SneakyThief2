package controller;

import java.util.Observable;

import view.MainFrame;
import view.MapPanel;
import model.Map;

/**
 * This class calls all the functions that have to be called when there is a new step
 * @author Robert Stevens
 *
 */
public class StepUpdater{
	
	Map map;
	
	public Map getNewMap(){
		return map;
	}
	
	public StepUpdater(MoveAgents moveAgents, MainFrame frame)
	{
		this.map = frame.getMap();
		m_moveAgents = moveAgents;
		
		//TODO: Do things to the map
	}
	
	/**
	 * Call all the functions that have to be called to generate the next step
	 */
	public void NextStep(MainFrame frame)
	{
	//TODO: add everything here that has to be updated
		m_moveAgents.DoMove();
		m_stepNumber++;
		//map panel redraw
		frame.updateMap(map);
	}
	
	public int getStepNumber(){
		return m_stepNumber;
	}
	private MoveAgents m_moveAgents;
	private int m_stepNumber;
}
