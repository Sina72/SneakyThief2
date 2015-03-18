package controller;

import model.*;

public class GameMain {

	public static void main(String[] args) {
		Map map = new MapBuilder().buildDefaultMap();
		if (map == null)
			new Exception("the map is not generated correctly");
		AgentIndex agentIndex = new AgentIndex();
		// TODO Auto-generated method stub

	}
	

	
}
