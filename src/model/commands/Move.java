package model.commands;

/**
 * The move command (twist) is stored in this container
 * @author Robert Stevens
 *
 */
public class Move {
	private double speed;
	private double angle;
	public Move (double speed, double angle)
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
