package model.commands;

public class Move {
	private double speed;
	private double angle;
	Move (double speed, double angle)
	{
		this.speed = speed;
		this.angle = angle;
	}
	public double getSpeed()
	{
		return speed;
	}
	public double getAngle()
	{
		return angle;
	}
}
