package controller;

import java.util.ArrayList;
import java.util.List;

import com.sun.prism.image.Coords;

import model.Guard;
import model.Map;
import model.commands.Coordinates;
import model.commands.GridState;

/**
 * This class holds a list with all the agents and allows you to add new ones
 * @author Robert Stevens
 *
 */
public class AgentIndex {
	/**
	 * The class needs the map so it can place agents on it
	 * @param map
	 */
	public AgentIndex(Map map)
	{
		m_map = map;
	}
	
	public void placeDefaultAgents(){
		placeDefaultAgents(0);
	}
	public void placeDefaultAgents(int number){
		ArrayList<Coordinates> coords = new ArrayList<Coordinates>();
		switch (number){
		case 0: coords.add(new Coordinates(5,5));
				coords.add(new Coordinates(10,10));
		}
		addAllGuards(coords);
	}
	/**
	 * Adds multiple guards at the same time by there coordinates
	 * @param coords a list of coordinates
	 */
	public void addAllGuards(ArrayList<Coordinates> coords){
		for(Coordinates c:coords){
			addGuard(c);
		}
	}
	
	/**
	 * Add a guard to the map
	 * @param coord the coordinates where the guard should be placed
	 */
	public void addGuard(Coordinates coord){
		/* init the guard */
		Guard guard = new Guard(coord);
		guard.LoadSettingsXML("./settings/settings.xml");
		
		/* place the guard on the map */
		if(m_map.getMap()[coord.getX()][coord.getY()] == GridState.Empty){
			m_map.getMap()[coord.getX()][coord.getY()] = GridState.Guard;
			ml_guards.add(guard);
		}
		else 
			System.out.print("The agent can't be placed at "+ coord.getX() + ", " + coord.getY());
	}
	
	public List<Guard> getGuardList()
	{
		return ml_guards;
	}
	
	private List<Guard> ml_guards = new ArrayList<Guard>();
	private Map m_map;
}
