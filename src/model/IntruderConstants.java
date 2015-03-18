package model;

public class IntruderConstants extends AgentConstants{

	public IntruderConstants(){
		m_isInitIntruder = false;
	}
	
	public void InitGuard(	double maxMovingSpeed, 
			double maxTurningSpeed,
			double minimalVisionRange, 
			double maximalVisionRange,
			double visionAngle,
			double sentryVisableRange,
			double structureVisableRange,
			double sprintMaxSpeed,
			double sprintMaxTurnAngle,
			double sprintMaxTime,
			double sprintRestTime)
			{
				if (m_isInitIntruder)
					return;
				m_isInitIntruder = true;
				InitAgent(	maxMovingSpeed, 
							maxTurningSpeed,
							minimalVisionRange, 
							maximalVisionRange,
							visionAngle,
							sentryVisableRange,
							structureVisableRange);
				m_maxSprintSpeed = sprintMaxSpeed;
				m_maxSprintAngle = sprintMaxTurnAngle;
				m_maxSprintTime = sprintMaxTime;
				m_sprintRest = sprintRestTime;
				
			}
	
	public double getSprintMaxSpeed()
	{
		return m_maxSprintSpeed;
	}
	public double getSprintMaxTurnAngle()
	{
		return m_maxSprintAngle;
	}
	public double getSprintMaxTime()
	{
		return m_maxSprintTime;
	}
	public double getSprintRestTime()
	{
		return m_sprintRest;
	}
	
	
	private boolean m_isInitIntruder;
	private double m_maxSprintSpeed;
	private double m_maxSprintAngle;
	private double m_maxSprintTime;
	private double m_sprintRest;
}
