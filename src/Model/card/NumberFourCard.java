package Model.card;
/**
 * This class creates a new number four card.
 * @author George Leventopoulos
 */
public class NumberFourCard extends NumberCard {
	/**
	 * Constructor: Constructs a new instance of NumberFourCard and via the
     * parent class NumberCard sets with the command super,
     * name,value = 4 and its image.
	 * @param name the name of the card.
	 * @param image the image of the card.
	 */
	public NumberFourCard(String name, String image){
		super(name, 4, image);
	}
	/*
	 * Returns the string representation of a card.
	 */
	public String toString() {
		return "\nMove your pawn 4 steps\nbackwards.";
	}
	public void movePawn() {
		
	}
	/*
	@Override
	boolean canMoves() {
		// TODO Auto-generated method stub
		return false;
	}*/
}
