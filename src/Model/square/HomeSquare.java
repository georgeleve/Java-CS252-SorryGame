package Model.square;
/**
 * This class represents one of the home squares, that belong to a specific player 
 * and the enemy has no access to them.
 * @author George Leventopoulos
 */
public class HomeSquare extends Square {
	/**
	 * Constructor
	 * @param position the position of the square
	 * @param color the color of the square
	 */
	public HomeSquare(int position,String name) {
		super(position,name);
	}
}
