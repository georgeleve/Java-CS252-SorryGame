package Model.card;
import Model.pawn.Pawn;
/*
 * This class creates a new number seven card.
 * @author George Leventopoulos
 */
public class NumberSevenCard extends NumberCard {
	/*
	 * Constructor: Constructs a new instance of NumberSevenCard and via the
     * parent class NumberCard sets with the command super,
     * name,value = 7 and its image.
	 */
	public NumberSevenCard(String name, String image){
		super(name, 7, image);
	}
	/**
	 * The string representation of a card is returned.
	 */
	public String toString() {
		return "Move your pawn 7 steps forward\n or move both"
				+ " of your pawns 7\n steps in total.";
	}
	/**
	 * Checks if the player can play the with card number 7.
	 * @return true or false 
	 */
	public boolean canPlay(Pawn pawn1, Pawn pawn2, int number1, int number2) {
		return true;
		//else return false;
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
