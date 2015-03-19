package model;

import model.commands.Coordinates;

/**
 * The intruder is an extension all code witch is specific for the intruder should go here
 * @author Robert Stevens
 *
 */
public class Intruder extends Agent{

	public Intruder(Coordinates coord) {
		super(coord);
	}
	
	public int LoadSettingsXML(String string) {
		return 0;
		// TODO implement this
	}

}
