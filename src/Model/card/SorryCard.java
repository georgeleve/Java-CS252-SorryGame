package Model.card;
import Model.pawn.Pawn;
/**
 * This class creates a new Sorry Card.
 * @author George Leventopoulos
 */
public class SorryCard extends Card {
	 /**
	 * Constructor
	 * @param name the name of the card
	 * @param image the image of the card
	 */
	public SorryCard(String name, String image){
		super(name, image);
	}
	/**
	 * Checks if the player can switch his pawn 
	 * with the enemy's pawn and returns true if it does
	 * or false if it does not.
	 * @return true or false 
	 */
	public boolean canSwitch(Pawn playerPawn, Pawn enemyPawn) {
		return true;
		//else return false
	}
	/**
	 * Returns the string representation of a card
	 * Postcondition: The string representation f the card is returned. 
	 * @return The string representation of a card 
	 */
	@Override
	public String toString() {
		return "If you are in start position replace\nyour pawn with an enemie's\npawn"
				+ " and put the enemie's\npawn in start position.";
	}
	/*
	public void movePawn(Pawn playerPawn,Pawn enemyPawn){
		
		
	}*/
	/*
	@Override
	public void movePawn() {
		// TODO Auto-generated method stub
		
	}
	@Override
	boolean canMoves() {
		// TODO Auto-generated method stub
		return false;
	}*/
}
