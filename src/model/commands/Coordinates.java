package model.commands;

public class Coordinates {
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