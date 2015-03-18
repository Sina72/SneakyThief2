package model;

import model.commands.Coordinates;
import model.commands.Move;

public class Agent {
	protected boolean m_debug = false;
	
	public Agent(Coordinates coord) {
		// TODO Auto-generated constructor stub
		coord = m_coords;
	}
	
	public Move getMove()
	{
		return null;
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
