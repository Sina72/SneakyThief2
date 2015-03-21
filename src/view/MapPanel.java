package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Map;
import model.commands.GridState;

/**
 * Draws a map on a JPanel
 */
public class MapPanel extends JPanel implements Observer {

	// THIS PANEL PLACED IN THE CENTER OF THE BORDER LAYOUT

	
	
	/*		Constants		*/
	private static int pxPerGridState = 0;

	
	/*	Constructors	*/
	public MapPanel(final Map map) {
		this.map = map;
		this.setSize(getMaximumSize());
		this.setBackground(Color.BLACK);
		this.setOpaque(true);
		
		this.addComponentListener(new ComponentListener(){

			private int calculatePxPerGridState(){
				int width = getSize().width, height = getSize().height;
				return Math.min(
						width / map.width(), 
						height / map.height())
						;
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				MapPanel.pxPerGridState = calculatePxPerGridState();
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				MapPanel.pxPerGridState = calculatePxPerGridState();
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	/*		Conversion Methods		*/
	
	/**
	 * Converts from amount of gridstates to amount of pixels
	 * @param gridstates amount of gridstates
	 * @return amount of pixels representing the gridstates
	 */
	public static int gridStatesToPx(int gridstates){
		return gridstates * pxPerGridState;
	}
	
	/**
	 * Converts from amount of pixels to amount of gridstates
	 * @param pixels amount of pixels
	 * @return amount of gridstates in a pixel (rounded down)
	 */
	public static int pxToGridStates(int pixels){
		return pixels / pxPerGridState;
	}

	/* 			Painting Methods			*/
	
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
				g2.setColor(currentstate.color());
				g2.fill3DRect(i*pxPerGridState, j*pxPerGridState, pxPerGridState, pxPerGridState, false);
				
			}
		}

	}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// TODO: Get the map and the placements
		// TODO: Finish draw methods
		drawMap(g);

	}
	
	/*		Getters/Setters		*/
	public Map getMap(){
		return map;
	}
	
	
	/* 		Instance Variables	*/
	private Map map;
}
