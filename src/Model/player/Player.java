package Model.player;
import Model.pawn.*;
import java.awt.Color;
/**
 * This class creates a new player.
 * @author George Leventopoulos
 */
public class Player {
	private Color color; // the color of the player
	private String name; //the name of the player
	private Pawn pawn1; //pawn1 of the player
	private Pawn pawn2; //pawn2 of the player 
	/**
	 * Constructor
	 * @param color of the player.
	 * @param name of the player.
	 * @param pawn1 the 1st pawn of the player.
	 * @param pawn2 the 2nd pawn of the player.
	 */
	public Player(Color color, String name, Pawn pawn1, Pawn pawn2){
		setColor(color);
		setName(name);
		setPawn1(pawn1);
		setPawn2(pawn2);
	}
	public Color getColor() {
		return color;
	}
	/**
	 * Accessor, return the name of the player.
	 * @return name the name of the player.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Accessor, return the first pawn.
	 * @return the pawn1
	 */
	public Pawn getPawn1() {
		return pawn1;
	}
	/**
	 * Accessor , return the second pawn.
	 * @return the pawn2
	 */
	public Pawn getPawn2() {
		return pawn2;
	}
	/**
	 * Transformer, sets the color of the player 
	 * @param color The color of the player.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * Transformer
	 * @param name the name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Transformer, sets the first player's pawn. 
	 * @param pawn1 the first pawn of the player
	 */
	public void setPawn1(Pawn pawn1) {
		this.pawn1 = pawn1;
	}
	/**
	 * Transformer, sets the second player's pawn. 
	 * @param pawn2
	 */
	public void setPawn2(Pawn pawn2) {
		this.pawn2 = pawn2;
	}	
	/**
	 * Checks if it is players turn .
	 * @param name the name of the player.
	 * @return true if it is the players turn else returns false.
	 */
	public boolean isHisTurn(String name) {
		return true;
	}
}	