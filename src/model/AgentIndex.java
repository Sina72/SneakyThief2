package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.commands.Coordinates;

public class AgentIndex {
	public void AddGuard(Coordinates coord){
		Guard guard = new Guard(coord);
		guard.LoadSettingsXML("./settings/settings.xml");
		ml_guards.add(guard);
	}
	
	public List<Guard> getGuardList()
	{
		return ml_guards;
	}
	
	private List<Guard> ml_guards = new ArrayList<Guard>();
}
