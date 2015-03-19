package controller;

import model.Map;
import model.commands.Coordinates;
import model.commands.GridState;

/**
 * This Class holds the basic tools to build a new map and it also contains some default maps
 * @author Robert Stevens
 *
 */
public class MapBuilder {

	/**
	 * This function crates an random map 
	 * @param width the width of the map
	 * @param height the height of the map
	 * @return a map
	 */
	public Map buildMap(int width, int height) {
		//TODO: Implement this
		return null;
	}

	/**
	 * This function returns a default map
	 * @return a defailt map
	 */
	public Map buildDefaultMap()
	{
		return buildDefaultMap(0);
	}
	
	/**
	 * This function contains the default maps for now
	 * @param number the number of the default map you want
	 * @return a map
	 */
	public Map buildDefaultMap(int number)
	{
		Map map = null;
		switch(number){

			case 0: map = new Map(200, 200);
				
					map.getMap()[0][0] = GridState.OuterWall;
					createWall(map,new Coordinates(5,1), new Coordinates(5,100));
					break;
			case 1: map = new Map(200, 200);
					for(int j = 0; j < 15; j++){
						int startx = (int)Math.random()*200;
						int starty = (int)Math.random()*200;
						for(int i = 0; i < 5; i++){
							if(map.getMap()[startx+i][starty] != GridState.Empty){	
								map.getMap()[startx+i][starty] = GridState.Wall;
							}
						}
						startx = (int)Math.random()*200;
						starty = (int)Math.random()*200;
						for(int i = 0; i < 5; i++){
							if(map.getMap()[startx][starty+i] != GridState.Empty){	
								map.getMap()[startx][starty+i] = GridState.Wall;
							}
						}
					}
					
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
		//TODO: optimise this and add to option to draw walls diagonal
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
