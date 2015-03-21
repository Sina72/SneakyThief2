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

	public int right(){
		System.out.println(m_speed + ", " + m_time + ", " + m_angle);
		return Map.metersToGridStates(cos(m_angle) * m_speed * m_time);
	}

	public int top(){
		return Map.metersToGridStates(sin(m_angle) * m_speed * m_time);
	}

	public int left(){
		return -right();
	}

	public int bottom(){
		return -top();
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
