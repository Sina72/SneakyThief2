package controller;

import view.MainFrame;
import model.Agent;
import model.Map;
import model.commands.Move;

public class GameMain {

	public static void main(String[] args) {
		MapBuilder mapbuild = new MapBuilder();
		Map gamemap = mapbuild.buildDefaultMap(0);
		MainFrame frame = new MainFrame(gamemap);
		Map map = new MapBuilder().buildDefaultMap();
		// TODO Auto-generated method stub

	}
	

	
}
