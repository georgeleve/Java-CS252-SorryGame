package Model.card;
/**
 * This class creates a new number 12 card.
 * @author George Leventopoulos
 */
public class NumberTwelveCard extends NumberCard {
	/**
	 * @param name the name of the card
	 * @param image the imgae path of the card
	 */
	public NumberTwelveCard(String name, String image) {
		super(name, 12, image);
	}
	/**
	 * A string representation of the card.
	 */
	public String toString() {
		return "\nMove your pawn 12 steps\nforward.";
	}
	/*
	public void movePawn() {
		
	}
	@Override
	boolean canMoves() {
		// TODO Auto-generated method stub
		return false;
	}*/
}
