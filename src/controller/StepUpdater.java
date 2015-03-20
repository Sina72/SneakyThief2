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
	
	
	public StepUpdater(MoveAgents moveAgents, MainFrame frame)
	{
		setFrame(frame);
		m_moveAgents = moveAgents;
		
		//TODO: Do things to the map
	}
	
	/**
	 * Call all the functions that have to be called to generate the next step
	 */
	public void NextStep()
	{
	//TODO: add everything here that has to be updated
		m_moveAgents.DoMove();
		
		
		//map panel redraw
		m_frame.updateMap();
		
		m_stepNumber++;
	}
	
	public int getStepNumber(){
		return m_stepNumber;
	}
	
	public void setFrame(MainFrame frame){
		m_frame = frame;
	}
	private MainFrame m_frame;
	private MoveAgents m_moveAgents;
	private int m_stepNumber;
}
