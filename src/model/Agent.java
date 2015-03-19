package model;

import model.commands.Coordinates;
import model.commands.Move;

/**
 * The baseclass for both the guards and the intruders
 * @author Robert Stevens
 *
 */
public class Agent {
	protected boolean m_debug = false;
	
	public Agent(Coordinates coord) {
		m_coords = coord;
	}
	
	/**
	 * This function is called once evry step and should return the move that the agent has to make
	 * @return the move that the agent has to make
	 */
	public Move getMove()
	{
		//TODO: implement some better move here
		return new Move(1.0, 0);
	}
	
	/**
	 * Overwrite this method
	 * @param string
	 * @return
	 */
	public int LoadSettingsXML(String string) {
		return -1;
		
	}
	
	public Coordinates getCoordinates()
	{
		return m_coords;
	}
	
	private AgentVariable m_vars;
	private AgentConstants m_const;
	private Coordinates m_coords;

}
