package controller;

import model.Map;
import view.MainFrame;
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
		Map gamemap = mapbuild.buildDefaultMap();
		if (gamemap == null){
			System.err.print("the map is not generated correctly");
			return;
		}
		AgentIndex agentIndex = new AgentIndex(gamemap);
		agentIndex.placeDefaultAgents();
		MainFrame frame = new MainFrame(gamemap);

		/* add all initialistations before this point */
		MoveAgents moveAgents = new MoveAgents(agentIndex.getGuardList(), gamemap);
		StepUpdater updater = new StepUpdater(moveAgents, frame);


		/*Run the steps */

		//TODO: THIS SHOULD BE DONE ONE A BETTER WAY
		//while(true)
		//updater.NextStep(frame);
		new Scheduler(updater).Start();
	}
}

