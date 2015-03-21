package model.commands;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import model.Constants;
import model.Map;

/**
 * The move command (twist) is stored in this container
 * @author Robert Stevens
 *
 */
public class Move {

	private double m_speed, m_angle, m_time;

	public Move (double speed, double angle, double time)
	{
		m_speed = speed;
		m_angle = angle;
		m_time = time;
	}

	public Move (double speed, double angle){
		this(
				speed,
				angle,
				Constants.STEP_LENGTH
				);
	}

	public int right(double angle){
		return Map.metersToGridStates(cos(angle) * m_speed * m_time);
	}

	public int top(double angle){
		return Map.metersToGridStates(sin(angle) * m_speed * m_time);
	}

	public int left(double angle){
		return -right(angle);
	}

	public int bottom(double angle){
		return -top(angle);
	}

	public double getSpeed()
	{
		return m_speed;
	}

	public double getAngle()
	{
		return m_angle;
	}
}
