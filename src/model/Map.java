package model;
import model.commands.GridState;

/**
 * This class creates and contains a map
 * @author Robert Stevens
 *
 */
public class Map {


	/*		Constructors	 */
	/**
	 * Constructor taking an amount of meters.
	 * @param width the width of the map in meters
	 * @param height of the map in meters
	 */
	public Map(double width, double height){
		this(	metersToGridStates(width),
				metersToGridStates(height));
	}

	/**
	 * Create a map initualise it with empty spots, except from the border this is initalised with the outerwall.
	 * Constructor takes an amount of gridstates
	 * @param width the width of the map
	 * @param height the height of the map
	 */
	public Map (int width, int height)
	{
		/*	initialize map with outer wall 	*/
		theMap = new GridState[width][height];
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				if (i == 0 || i == height-1 || j == 0 || j == width-1)
					theMap[i][j] = GridState.OuterWall;
				else
					theMap[i][j] = GridState.Empty;
	}

	/*	 Conversion Methods		*/

	/**
	 * Convenience method for converting any amount of meter values to an array of gridState amounts.
	 * Calls the metersToGridstates method on every value
	 * @param meters
	 * @return integer array of amount of gridStates per meters in the same order as offered.
	 */
	public static int[] metersToGridstates(double... meters){
		int[] gridStates = new int[meters.length];
		for(int i = 0; i < gridStates.length; i ++)
			gridStates[i] = metersToGridStates(meters[i]);
		return gridStates;
	}

	/**
	 * Converts an amount of meters to an amount of gridStates. Amount of gridStates per meter is {@value #GRIDSTATES_PER_METER}.
	 *
	 * This method will round down on the amount of gridStates, e.g. 2.99 gridStates will be truncated to 2 gridStates
	 * @param meters
	 * @return
	 */
	public static int metersToGridStates(double meters){
		return (int) (meters / Constants.CELL_SIZE);
	}

	/**
	 * Convenience method for converting any amount of gridState amounts to an array of meter values
	 * @param Gridstates amount of gridStates
	 * @return double array of meter values in the order as offered
	 */
	public static double[] gridstatesToMeters(int... gridStates){
		double[] meters = new double[gridStates.length];
		for(int i = 0; i < meters.length; i ++)
			meters[i] = gridStatesToMeters(gridStates[i]);
		return meters;
	}

	/**
	 * Converts an amount of gridStates to a meter value. Although the meter is a double, one should pay attention that the amount of
	 * gridStates is discretised.
	 * @param gridstates an amount of gridStates
	 * @return
	 */
	public static double gridStatesToMeters(int gridstates){
		return gridstates * Constants.CELL_SIZE;
	}

	/*	Getters/Setters */

	public GridState[][] getMap(){
		return theMap;
	}

	public int width(){
		return theMap.length;
	}

	public int height(){
		return theMap[0].length;
	}

	/*	Instance Variables	*/
	private GridState[][] theMap;

}
