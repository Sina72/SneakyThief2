package controller;

import model.Map;
import model.commands.Coordinates;
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
	
	/**
	 * This function contains the default maps for now
	 * @param number
	 * @return
	 */
	public Map buildDefaultMap(int number)
	{
		 Map map = null;
		switch(number){
			case 0: map = new Map(200, 200);
					map.getMap()[0][0] = GridState.OuterWall;
					createWall(map,new Coordinates(5,1), new Coordinates(5,100));
					break;
			default: map = null;
					break;
		}
		return map;
	}
	
	/**
	 * This function can create walls
	 * @param map the map
	 * @param start the start coordinates
	 * @param stop the end coordinates
	 */
	private void createWall(Map map,Coordinates start, Coordinates stop)
	{
		//TODO: optimise this and add to option to draw walls diagnal
		if (start.getX() == stop.getX())
		{
			if (start.getY() <= stop.getY())
				for (int i = start.getY(); i <= stop.getY(); i++)
					map.getMap()[start.getX()][i] = GridState.Wall;
			
			else
				for (int i = stop.getY(); i <= start.getY(); i++)
					map.getMap()[start.getX()][i] = GridState.Wall;
		}
		if (start.getY() == stop.getY())
		{
			if (start.getX() <= stop.getX())
				for (int i = start.getX(); i <= stop.getX(); i++)
					map.getMap()[i][start.getY()] = GridState.Wall;
			
			else
				for (int i = stop.getX(); i <= start.getX(); i++)
					map.getMap()[i][start.getY()] = GridState.Wall;
		}
	}
	
	
}
