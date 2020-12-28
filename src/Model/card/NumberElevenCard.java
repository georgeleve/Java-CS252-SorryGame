package Model.card;
import Model.pawn.Pawn;

/**
 * This class creates a new number eleven card.
 * @author leven
 */
public class NumberElevenCard extends NumberCard {
	/**
	 * Constructor: Constructs a new instance of NumberElevenCard and via the
     * parent class NumberCard sets with the command super,
     * name,value = 11 and its image.
	 * @param name the name of the card
	 * @param image the image path of the card
	 */
	public NumberElevenCard(String name, String image){
		super(name, 11, image);
	}
	/**
	 * Check if the player's pawn can be switched. 
	 * @param playersPawn
	 * @param enemysPawn
	 * @return true or false depending if the pawn can be switched or not.
	 */
	public boolean canSwitch(Pawn playersPawn, Pawn enemysPawn) {
		return true;
	}
	/**
	 * Returns the description of the card.
	 */
	public String toString() {
		return "Move your pawn 11 steps\n"
				+ "forward or switch positions\nwith an enemy's pawn.";
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
