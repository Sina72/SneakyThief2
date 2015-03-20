package controller;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This class calls the stepUpdater when its needed
 * @author Robert Stevens
 *
 */
public class Scheduler {
	public Scheduler(StepUpdater updater){
		m_updater = updater;
	}
	public void Start() {
		schedule();
		
	}
	private void schedule(){
		timer = new Timer();
		timer.scheduleAtFixedRate(
				new TimerTask(){
					public void run() {
						m_updater.NextStep();
					}
				}, 
				1, 
				(long) (1000));
	}
	private StepUpdater m_updater;
	private Timer timer;
}
