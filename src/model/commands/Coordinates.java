package model.commands;

/**
 * This class functions as a container to store the coordinates
 * @author Robert Stevens
 *
 */
public class Coordinates {
	public Coordinates(int x, int y)
	{
		setCoordinates(x, y);
	}
	
	public Coordinates(int x, int y, double angle)
	{
		setCoordinates(x, y, angle);
	}

	public void setCoordinates(int x, int y)
	{
		setCoordinates(x, y, 0);
	}
	public void setCoordinates(int x, int y, double angle)
	{
		this.x = x;
		this.y = y;
		this.angle = angle;
	}
	public void setAngle(double angle){
		this.angle = angle;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	
	public double getAngle()
	{
		return this.angle;
	}
	
	private int x;
	private int y;
	private double angle;
}
