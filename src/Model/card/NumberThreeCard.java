package Model.card;
/**
 * This class creates a new number three card.
 * @author George Leventopoulos
 */
public class NumberThreeCard extends NumberCard {
	/**
	 * @param name the name of the card.
	 * @param image the image path of the card.
	 */
	public NumberThreeCard(String name, String image){
		super(name, 3, image);
	}
	/**
	 * Return the description of the card
	 */
	public String toString() {
		return "\nMove your pawn 3 steps forward.";
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
