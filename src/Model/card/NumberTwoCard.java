package Model.card;
/*
 * This class creates a new number 2 card.
 * @author George Leventopoulos
 */
public class NumberTwoCard extends NumberCard {
	/**
	 * Constructor: Constructs a new instance of NumberTwoCard and via the
     * parent class NumberCard sets with the command super,
     * name,value = 2 and its image.
	 */
	public NumberTwoCard(String name, String image){
		super(name, 2, image);
	}
	/**
	 * Return the description of the card
	 */
	public String toString() {
		return "Move your pawn 2 steps forward\n" + 
				"or move away from start square.\nAlso play again.\n";
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
