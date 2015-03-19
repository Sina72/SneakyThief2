package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import com.sun.corba.se.spi.orbutil.fsm.Guard;

import model.Intruder;
import model.Map;
import model.commands.GridState;

/**
 * Draws a map on a JPanel
 */
public class MapPanel extends JPanel implements Observer {

	// THIS PANEL PLACED ON THE RIGHT OF THE BORDER LAYOUT
	private Map map;

	private final static double PX_PER_M = 3779.527559055;

	private static int scale = 4;

	public MapPanel(Map map) {
		// TODO: Make scale dependent on screen size, i.e. make map grow with
		// screen size
		// scale = Math.max(map.getMapWidth(),map.getMapHeight()) /
		// Math.min(super.getWidth(), super.getHeight());
		this.map = map;
		this.setSize(getMaximumSize());
		this.setBackground(Color.BLACK);
		this.setOpaque(true);
//		if(this.WIDTH>this.HEIGHT)
//		{
//			scale = map.getMap().length/this.HEIGHT;
//		}
//		else
//		{
//			scale = map.getMap().length/this.WIDTH;
//		}
		
	}

	/**
	 * Scales from meters to pixels
	 * 
	 * @return
	 */
//	private double scale(double meters) {
//		double widthPanel = this.getWidth();
//		double heightPanel = this.getHeight();
//		double scaleHeight = widthPanel/map.getMapHeight();
//		double scaleWidth = heightPanel/map.getMapWidth();
//		this.scale = Math.min(scaleHeight, scaleWidth)/4000;
//		return meters * PX_PER_M * scale;
//	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	public void paint(Graphics g, int x, int y)// x/y are end points of line
	{
		g.setColor(Color.BLACK);
		g.drawLine(10, 10, 50, 50);
	}

	public void drawMap(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		GridState currentstate;

		// TODO: Get the map and the placements
		// TODO: Finish draw methods
		for(int i = 0;i<map.getMap().length;i++)
		{
			for(int j = 0; j<map.getMap()[0].length;j++)
			{	
				currentstate = map.getMap()[i][j];
				//CHANGE COLOR DEPENDING ON THE GRIDSTATE
				if(currentstate == GridState.Wall){
						g2.setColor(Color.BLACK);
				}
				else if(currentstate == GridState.Guard){
					g2.setColor(Color.green);
				}
				else if(currentstate == GridState.Intruder){
					g2.setColor(Color.red);
				}
				else if(currentstate == GridState.Sentry){
					g2.setColor(Color.blue);
				}
				else if(currentstate == GridState.SentryGuard){
					g2.setColor(Color.cyan);
				}
				else if(currentstate == GridState.Shade){
					g2.setColor(Color.gray);
				}
				else if(currentstate == GridState.ShadeGuard){
					g2.setColor(new Color(0,200,0));
				}
				else if(currentstate == GridState.ShadeIntruder){
					g2.setColor(new Color(200,0,0));
				}
				else if(currentstate == GridState.Window){
					g2.setColor(Color.yellow);
				}
				else if(currentstate == GridState.Door){
					g2.setColor(new Color(102,51,0));
				}
				else if(currentstate == GridState.Target){
					g2.setColor(Color.orange);
				}
				else if(currentstate == GridState.TargetGuard){
					g2.setColor(new Color(107,142,35));
				}
				else if(currentstate == GridState.TargetIntruder){
					g2.setColor(Color.magenta);
				}
				else if(currentstate == GridState.Tree){
					g2.setColor(new Color(128,128,0));
				}
				else if(currentstate == GridState.OuterWall){
					g2.setColor(Color.DARK_GRAY);
				}
				else if(currentstate == GridState.Empty){
					g2.setColor(Color.white);
				}
				g2.fill3DRect(i*scale, j*scale, scale, scale, false);
				
			}
		}

	}
	

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// TODO: Get the map and the placements
		// TODO: Finish draw methods
		drawMap(g);

	}
}
