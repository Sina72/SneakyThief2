package model;

import model.commands.Coordinates;
import model.commands.Move;

public class Agent {
	protected boolean m_debug = false;
	
	public Agent(Coordinates coord) {
		// TODO Auto-generated constructor stub
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
	
	private AgentVariable m_vars;
	private AgentConstants m_const;

}
