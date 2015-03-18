package controller;

import model.Map;
import model.commands.GridState;

public class MapBuilder {

	public Map buildMap(int width, int height) {
		return null;
	}

		//BuildMap
	public Map buildDefaultMap()
	{
		return buildDefaultMap(0);
	}
	public Map buildDefaultMap(int number)
	{
		//TODO: create a function like createWall(start coords, end coords) to make walls in a more efficent way
		 Map map = null;
		switch(number){
			case 0: map = new Map(200, 200);
					map.getMap()[0][0] = GridState.OuterWall;
					map.getMap()[10][10] = GridState.Wall;
					break;
			default: map = null;
					break;
		}
		return map;
	}
	
	
}
