package Model.card;
/*
 * This class creates a new Number ten Card.
 * @author George Leventopoulos
 */
public class NumberTenCard extends NumberCard {
	// A with number 10 card the player can move front or backwards	
	/*
	 * Constructor : Constructs a new instance of NumberTenCard and via the
     * parent class NumberCard sets with the command super,
     * name,value = 10 and its image.
	 */
	public NumberTenCard(String name, String image){
		super(name, 10, image);
	}
	/**
	 * Description of NumberTenCard card. 
	 */
	public String toString() {
		return "\nMove your pawn 10 steps\nforward or 1 step backwards.";
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
