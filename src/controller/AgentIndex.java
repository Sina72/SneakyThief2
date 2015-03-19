import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * Add a guard to the map
	 * @param coord the coordinates where the guard should be placed
	 */
	
	public void addAllGuards(ArrayList<Coordinates> coords){
		for(Coordinates c:coords){
			addGuard(c);
		}
	}
	public void addGuard(Coordinates coord){
		/* init the guard */
		Guard guard = new Guard(coord);
		guard.LoadSettingsXML("./settings/settings.xml");
		ml_guards.add(guard);
		
		/* place the guard on the map */
		if(m_map.getMap()[coord.getX()][coord.getY()] == GridState.Empty)
			m_map.getMap()[coord.getX()][coord.getY()] = GridState.Guard;
		else 
			new Exception("This field is not empty");
	}
	
	public List<Guard> getGuardList()
	{
		return ml_guards;
	}
	
	private List<Guard> ml_guards = new ArrayList<Guard>();
	private Map m_map;
}
