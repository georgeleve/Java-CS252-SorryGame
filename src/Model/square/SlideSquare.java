package Model.square;
/**
 * This class represents one square of a slide and can be divided into 3 subclasses:
 * StratSlideSquare, InternalSlideSquare, EndSlideSquare.
 * @author George Leventopoulos
 */
abstract public class SlideSquare extends Square {
	/**
	 * @param position the position of the square
	 * @param color the color of the square
	 */
	SlideSquare(int position,String name) {
		super(position,name);
	}
}
