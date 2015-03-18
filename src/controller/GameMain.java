package controller;

import model.*;

public class GameMain {

	public static void main(String[] args) {
		/* initialise the systems */ 
		Map map = new MapBuilder().buildDefaultMap();
		if (map == null)
			new Exception("the map is not generated correctly");
		AgentIndex agentIndex = new AgentIndex(map);
		
		/* add all initialistations before this point */
		StepUpdater updater = new StepUpdater(0.1);
		
		
		// TODO Auto-generated method stub

	}
	

	
}
