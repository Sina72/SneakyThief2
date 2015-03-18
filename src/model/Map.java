package model;
import model.commands.*;

public class Map {
	public Map (int width, int height)
	{
		theMap = new GridState[width][height];
	}
	
	public GridState[][] getMap()
	{
		return theMap;
	}
	
	private GridState[][] theMap;

}
