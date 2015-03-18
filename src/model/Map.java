package model;
import model.commands.*;

public class Map {
	public Map (int width, int height)
	{
		theMap = new GridState[width][height];
		for (int i = 0; i < theMap.length; i++)
			for (int j = 0; j <theMap[0].length; j++)
				theMap[i][j] = GridState.Empty;
	}
	
	public GridState[][] getMap()
	{
		return theMap;
	}
	
	private GridState[][] theMap;

}
