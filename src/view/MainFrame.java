package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Map;


public class MainFrame extends JFrame {
	
	private Map map;
	public MainFrame(Map map){
		this.map = map;
		initFrame();
	}

	private void initFrame() {
		//TODO: Color legend
		this.setLayout(new BorderLayout());
		setSize(700,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Create Panels
		EditorPanel editPanel = new EditorPanel();
		ControllerPanel controlPanel = new ControllerPanel();
		MapPanel mapPanel = new MapPanel(this.map);
		this.add(editPanel, BorderLayout.WEST);
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(mapPanel,BorderLayout.CENTER);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setVisible(true);
	}
	
//	public void connectGameController(GameController controller){
//		MapPanel mapPanel = new MapPanel(controller.getMap());
//		controller.addObserver(mapPanel);
//		this.add(mapPanel, BorderLayout.CENTER);
//	}
	
	/**
	 * Get the input values from the editor panel
	 * @param panel
	 * @return ArrayList with inputs
	 */
	public ArrayList<Integer> giveValues(EditorPanel panel)
	{
		return panel.getValues();
	}
}
