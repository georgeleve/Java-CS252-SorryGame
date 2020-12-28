package Model.card;
/**
 * Contains the methods needed for 
 * creating a number card or a sorry card.
 * @author George Leventopoulos
 */
abstract public class Card {
	public String image; //String for the image path.
	public String name; //String for the name of the card.
	/**
	 * Constructor for Card
	 * @param name of the card.
	 * @param image of the card.
	 */
	public Card(String name, String image){
		setName(name);
		setImage(image);
	}
	/**
	 * Transformer: Sets the card's name.
	 * Postcondition : The card's name has been set.
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Transformer: Sets the card's image.
	 * Postcondition : the card's image has been set.
	 * @param String image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * Accessor: returns the card name.
	 * @return the name of the card
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Accessor: returns the card image.
	 * @return the image path of the card
	 */
	public String getImage() {
		return this.image;
	}
	//abstract public void movePawn();
	//abstract boolean canMoves();
}
