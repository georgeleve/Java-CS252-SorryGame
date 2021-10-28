package Model.deck;
import java.util.ArrayList;
import java.util.Collections;
import Model.card.Card;
import Model.card.NumberEightCard;
import Model.card.NumberElevenCard;
import Model.card.NumberFiveCard;
import Model.card.NumberFourCard;
import Model.card.NumberOneCard;
import Model.card.NumberSevenCard;
import Model.card.NumberTenCard;
import Model.card.NumberThreeCard;
import Model.card.NumberTwelveCard;
import Model.card.NumberTwoCard;
import Model.card.SorryCard;
/**
 * This class creates a new deck of cards.
 * @author George Leventopoulos
 */
public class Deck {
	int element = -1;
	ArrayList<Card> gameCards = new ArrayList<Card>();  
	/**
	 * Constructor
	 */
	public Deck() {
		initCards();
	}
	/**
	 * Returns the list of card.
	 * @return the list of cards.
	 */
	public ArrayList<Card> getGameCards() {
		return gameCards;
	}
	/**
	 * Sets the game Cards
	 * @param gameCards sets the cars of the game.
	 */
	public void setGameCards(ArrayList<Card> gameCards) {
		this.gameCards = gameCards;
	}
	/**
	 * Initialize all the cards in the deck of cards.
	 */
	public void initCards() {
		for(int i = 0; i < 4; i++) {
			gameCards.add(new NumberOneCard("NumberOneCard", "images/cards/card1.png"));
			gameCards.add(new NumberTwoCard("NumberTwoCard", "images/cards/card2.png"));
			gameCards.add(new NumberThreeCard("NumberThreeCard", "images/cards/card3.png"));
			gameCards.add(new NumberFourCard("NumberFourCard", "images/cards/card4.png"));
			gameCards.add(new NumberFiveCard("NumberFiveCard", "images/cards/card5.png"));
			gameCards.add(new NumberSevenCard("NumberSevenCard", "images/cards/card7.png"));
			gameCards.add(new NumberEightCard("NumberEightCard", "images/cards/card8.png"));
			gameCards.add(new NumberTenCard("NumberTenCard", "images/cards/card10.png"));
			gameCards.add(new NumberElevenCard("NumberElevenCard", "images/cards/card11.png"));
			gameCards.add(new NumberTwelveCard("NumberTwelveCard", "images/cards/card12.png"));
			gameCards.add(new SorryCard("SorryCard", "images/cards/cardSorry.png"));
		}
		Collections.shuffle(gameCards); //Suffle the list of cards.
		setGameCards(gameCards);
	}	
	/**
     * Let the user take a new card.
	 * @return a new card
	 */
	public Card getNewCard(){
		element++;
		return gameCards.get(element);
	}
	/**
	 * Checks if there are cards left. If not the we need to shuffle them again.
	 * @return true or false depending if the list has cards left.
	 */
	public boolean hasCardsLeft() {
		if(gameCards.isEmpty())
			return false;
		return true;
	}
	/**
	 * Checks if the player can press the fold button
	 * @return true or false
	 */
	public boolean canFold() {		
		return true;
		//return false;
	}
}
