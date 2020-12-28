package Model.card;
/**
 * This class create a new number five card.
 * @author George Leventopoulos
 */
public class NumberFiveCard extends NumberCard {
	/**
	 * @param name the name of the card
	 * @param image the image path of the card
	 */
	public NumberFiveCard(String name, String image){
		super(name, 5, image);
	}
	/**
	 * Return the description of the card
	 */
	public String toString() {
		return "\nMove your pawn 5 steps forward.";
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
