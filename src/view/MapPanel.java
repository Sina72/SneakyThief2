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

	private static double scale = 1 / 10000.0;

	public MapPanel(Map map) {
		// TODO: Make scale dependent on screen size, i.e. make map grow with
		// screen size
		// scale = Math.max(map.getMapWidth(),map.getMapHeight()) /
		// Math.min(super.getWidth(), super.getHeight());
		this.map = map;
		this.setSize(getMaximumSize());
		this.setBackground(Color.BLACK);
		this.setOpaque(true);
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

		GridState currentstate = null;

		// TODO: Get the map and the placements
		// TODO: Finish draw methods
		for(int i = 0;i<map.getMap().length;i++)
		{
			for(int j = 0; j<map.getMap()[0].length;j++)
			{	
				currentstate = map.getMap()[i][j];
				//CHANGE COLOR DEPENDING ON THE GRIDSTATE
				switch(currentstate)
				{
					case Wall:
					{
						g2.setColor(Color.black);
					}
					case Guard:
					{
						g2.setColor(Color.green);
					}
					case Intruder:
					{
						g2.setColor(Color.red);
					}
					case Sentry:
					{
						g2.setColor(Color.blue);
					}
					case SentryGuard:
					{
						g2.setColor(Color.cyan);
					}
					case Shade:
					{
						g2.setColor(Color.gray);
					}
					case ShadeGuard:
					{
						g2.setColor(new Color(0,200,0));
					}
					case ShadeIntruder:
					{
						g2.setColor(new Color(200,0,0));
					}
					case Window:
					{
						g2.setColor(Color.yellow);
					}
					case Door:
					{
						g2.setColor(new Color(102,51,0));//Brown
					}
					case Target:
					{
						g2.setColor(Color.orange);
					}
					case TargetGuard:
					{
						g2.setColor(new Color(107,142,35));
					}
					case TargetIntruder:
					{
						g2.setColor(Color.magenta);
					}
					case Tree:
					{
						g2.setColor(new Color(128,128,0));
					}
					case OuterWall:
					{
						g2.setColor(Color.DARK_GRAY);
					}
					case Empty:
					{
						g2.setColor(Color.white);
					}
					
				default:
					break;
				}
				
				g2.drawRect(i*10, j*10, 5, 5);
				
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
