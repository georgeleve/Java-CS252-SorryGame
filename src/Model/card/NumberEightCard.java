package Model.card;
/**
 * This class creates a new number 8 card.
 * @author George Leventopoulos
 */
public class NumberEightCard extends NumberCard {
	/**
	 * 
	 * @param name the name of the card
	 * @param image the image of the card
	 */
	public NumberEightCard(String name, String image) {
		super(name, 8, image);
	}
	/**
	 * Return the description of the card
	 */
	public String toString() {
		return "\nMove your pawn 8 steps forward.";
	}
	/*
	public void movePawn() {
		
	}
	@Override
	boolean canMoves() {
		return false;
	}*/
}
