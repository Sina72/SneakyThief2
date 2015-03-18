package model.commands;

public class Coordinates {
	public Coordinates(int x, int y)
	{
		setCoordinates(x, y);
	}
	public void setCoordinates(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	
	private int x;
	private int y;
}
