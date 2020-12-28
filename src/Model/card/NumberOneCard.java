package Model.card;
/**
 * This class creates a new number one card.
 * @author George Leventopoulos
 */
public class NumberOneCard extends NumberCard {
    /**
     * Constructor: Constructs a new instance of NumberOneCard and via the
     * parent class NumberCard sets with the command super,
     * name,value = 1 and its image.
     * @param name
     * @param image
     */
	public NumberOneCard(String name, String image){
		super(name, 1, image);
	}
	/**
	 * Returns the description of the card.
	 */
	public String toString() {
		return "\nMove your pawn 1 step forward\n" 
				+ "or put it in start position.";
	}
	/*
	@Override
	boolean canMoves() {
		// TODO Auto-generated method stub
		return false;
	}*/
}
