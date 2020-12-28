package Model.pawn;
import java.awt.Color;
/**
 * This class creates a new pawn.
 * @author George Leventopoulos
 */
public class Pawn {
	private Color color; // the color of the pawn.
	int position = -1; //the position of the pawn.
	/**
	 * Constructor
	 * @param color the color of the pawn.
	 * @param position the position of the pawn.
	 */
	public Pawn(Color color, int position) {
		setColor(color);
		setPosition(position);
	}
	/**
	 * Accessor : gets color of the pawn.
	 * @return the color of the pawn.
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * Transformer: sets the color.
	 * @param of the pawn
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * Accessor: gets the position of the pawn.
	 * @return the position of the pawn.
	 */
	public int getPosition() {
		return position;
	}
	/**
	 * Transformer: sets the position.
	 * @param positionX
	 */
	public void setPosition(int position) {
		this.position = position;
	}
}
