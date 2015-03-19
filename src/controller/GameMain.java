package controller;

import view.MainFrame;
import model.Agent;
import model.Map;
import model.commands.Move;
import java.util.List;

import model.*;
/**
 *  This class contains the main method
 * @author Robert Stevens
 *
 */
public class GameMain {
	private boolean m_debug = false;

	/**
	 * First it initializes the system, and than it runs the steps.
	 * @param args
	 */
	public static void main(String[] args) {
		MapBuilder mapbuild = new MapBuilder();
		Map gamemap = mapbuild.buildDefaultMap(0);
		MainFrame frame = new MainFrame(gamemap);
		if (gamemap == null)
			new Exception("the map is not generated correctly");
		AgentIndex agentIndex = new AgentIndex(map);
		
		/* add all initialistations before this point */
		MoveAgents moveAgents = new MoveAgents(agentIndex.getGuardList());
		StepUpdater updater = new StepUpdater(moveAgents);
		
		
		/*Run the steps */
		
		//TODO: THIS SHOULD BE DONE ONE A BETTER WAY
		while(true)
			updater.NextStep();
	}
}
