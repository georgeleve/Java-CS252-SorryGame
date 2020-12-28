package Model.card;
/**
 * This class creates a new number card.
 * @author George Leventopoulos
 */
abstract public class NumberCard extends Card {
	private int number; // The number of the card
	/**
	 * Constructor: Constructs a new instance of NumberCard and via the
     * parent class Card sets with the command super,
     * name,and image.
	 * @param name The name of the card.
	 * @param number The number of the card. 
	 * @param image The image of the card.
	 */
	public NumberCard(String name,int number,String image){
		super(name,image);
		setValue(number);
	}
	/**
	 * Transformer : sets the number of the card. 
	 * @param number The number of the card.
	 */
	public void setValue(int number) {
		this.number = number;
	}
	/**
	 * Accessor : get the number of the card.
	 * @return the number of the card
	 */
	public int getValue() {
		return this.number;
	}
	/*
	public void movePawn() {
		
	}*/
}