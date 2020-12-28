package Model.square;
/**
 * This class represents a square in the game.
 * @author George Leventopoulos
 */
abstract public class Square {
	public int position;
	public String name;
	/**
	 * Constructor square
	 * @param position the position  of the square
	 * @param color the color of the square
	 */
	public Square(int position,String name) {
		setPosition(position);
		setName(name);
	}
	/**
	 * (Accessor) returns the position of the pawn.
	 * @return the position of the pawn
	 */
	public int getPosition() {
		return position;
	}
	/**
	 * Transformer(Observer) Sets the position of the card
	 * @param position sets the position of the card
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	/**
	 * Transformer(Observer) Sets the name of the square. 
	 * @param name sets the name of the square.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * (Accessor) returns the name of the square.
	 * @return name the name of the square. 
	 */
	public String getName() {
		return name;
	}
	/*
	public boolean hasPawnOnTop(int position){
		return true;
	}*/
}
