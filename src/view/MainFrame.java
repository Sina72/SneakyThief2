package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Map;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private Map map;
	public MainFrame(Map map){
		this.map = map;
		initFrame();
	}

	private void initFrame() {
		//TODO: Color legend
		setLayout(new BorderLayout());
		setSize(700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Create Panels
		//EditorPanel editPanel = new EditorPanel();
		ControllerPanel controlPanel = new ControllerPanel();
		MapPanel mapPanel = new MapPanel(map);
		BlockPanel blockPanel = new BlockPanel();

		//this.add(editPanel, BorderLayout.WEST);
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(mapPanel,BorderLayout.CENTER);
		this.add(blockPanel, BorderLayout.EAST);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
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

	public Map getMap() {
		return map;
	}

	public void updateMap(){
		this.repaint();

	}
}
