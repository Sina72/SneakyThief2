package model;
import model.commands.*;

/**
 * This class creates and contains a map
 * @author Robert Stevens
 *
 */
public class Map {
	/**
	 * Create a map initualise it with empty spots, except from the border this is initalised with the outerwall
	 * @param width the width of the map
	 * @param height the height of the map
	 */
	public Map (int width, int height)
	{
		theMap = new GridState[width][height];
		for (int i = 0; i < theMap.length; i++)
			for (int j = 0; j <theMap[0].length; j++)
				if (i == 0 || i == theMap.length-1 || j == 0 || j == theMap[0].length-1)
					theMap[i][j] = GridState.OuterWall;
				else
					theMap[i][j] = GridState.Empty;
	}
	
	public GridState[][] getMap()
	{
		return theMap;
	}
	
	private GridState[][] theMap;

}
