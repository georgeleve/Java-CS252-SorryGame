package Controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.card.Card;
import Model.card.NumberCard;
import Model.deck.Deck;
import Model.pawn.Pawn;
import Model.player.Player;
import Model.square.EndSlideSquare;
import Model.square.HomeSquare;
import Model.square.InternalSlideSquare;
import Model.square.SafetyZoneSquare;
import Model.square.SimpleSquare;
import Model.square.Square;
import Model.square.StartSlideSquare;
import Model.square.StartSquare;
import view.View;
/**
 * This class is the master of the game and
 * controls all the operations. It provides communication between model and view.
 * @author George Leventopoulos
 */
public class Controller {
	public View view;
	public Deck deck;
	public Player player1; 
	public Player player2;
	public Pawn [] pawns = new Pawn[4]; //the array that holds the pawns
	public Square [] squares = new Square[78]; //the array that holds the squares of the game.
	int dialogButton = JOptionPane.YES_NO_OPTION;
	int dialogResult; 
	private int turn = 1;
	private int cardscounter = 44;
	private Card card;
	private NumberCard c;
	int card7 = 0; //counter for steps in card7
	int count = 0;
	int k0 = -1; //position of pawns[0]
	int k1 = -1; //position of pawns[1]
	int k2 = -1;//position of pawns[2]
	int k3 = -1;//position of pawns[3]
	int temp;
	/**
	 * The main method
	 * @param args
	 */
	public static void main(String[] args) {
		Controller c = new Controller();
		c.initialize();
	}
	/**
	 * Initialize what is needed.
	 */
	public void initialize() {
		deck = new Deck();
		view = new View();
		initPawns();
		initSquares();
		initListeners();
	}
	/**
	 * Transformer, initialize all the listeners.
	 */
	public void initListeners() {
		view.getExitButton().addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		view.getCardButton().addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAndReplaceCard(count);
				count++;
			}
		});
		view.getPawn0().addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(turn == 1) {
					if(canMove0() && canStart0()) {
							if(k0 == -1) {
								if(c.getValue() == 1 || (c.getValue() == 2)) 
									k0 = 3; 
								else if(card.getName() == "SorryCard") {
									if(canBeSwitched(k2)) {
										k0 = k2;
										view.updateInfobox("Your pawns can be switched.");
									}else {
										view.updateInfobox("You pawn can't be switched.");
									}
								}
							} 
							else if(c.getValue() == 4){
								k0 = k0-4;
								card7 = 0;
							}else if(c.getValue() ==7) {
								if(card7 ==7) {	
									view.updateInfobox("Your pawns moved 7 \nsteps successfully");
								}else {
									k0++;
									card7++;
								}
							}else if(c.getValue() ==10) {
								view.showMessage("Select yes for 10 steps forward "
										+ "\nSelect no for 1 step backwards.");
								if(view.returnMessage() == 0) {
									k0 = k0+c.getValue();
								}else {
									k0--;
								}
							}else if(c.getValue() == 11){
									view.showMessage("Select yes for 11 steps forward "
											+ "\nSelect no for switching pawn with enemy");
									if(view.returnMessage() == 0) {
										k0 = k0+c.getValue();
									}else {
										if(canBeSwitched(k2)) {
											temp = k0;
											k0 = k2;
											k2 = temp;
											view.updatePawn(k2, 2);
											view.updateInfobox("Your pawns can be switched.");
										}else {
											view.updateInfobox("You pawn can't be switched.");
										}
									}
							}else {	
								card7 =0;
								k0 = k0 + c.getValue();
							}
							
							if(k0 <= -1)k0 = 59; //special case for card4.
							if(k0 == 60) k0 = 0;
							if(k0 == 2) k0 = 60;
							
							if(k0>-1)view.updatePawn(k0, 0); //update pawn in view
							
							if((k0==66 && k1==65) || (k0==65 && k1==66)) {
								view.getInfobox().setBackground(Color.red);
								view.getPawn0().setEnabled(false);
								view.getPawn1().setEnabled(false);
								view.getPawn2().setEnabled(false);
								view.getPawn3().setEnabled(false);
								view.getCardButton().setEnabled(false);
								view.updateInfobox("Congratulations!\n\n\nRED pawns win!!!");
							}
							//view.updateInfobox(Integer.toString(k0));
							
							//Slides
							if(k0==23 || k0==38 || k0==53) {
								view.updateInfobox("Slide....");
								k0 =k0+4;
								view.updatePawn(k0,0);
							}
							if(k0 ==15 || k0==30 || k0==45) {
								view.updateInfobox("Slide....");
								k0 = k0+3;
								view.updatePawn(k0,0);
							}
							
							//Pawns in the same position
							if(k0==k1 && k0!=-1 && k1!=-1) {
								k1 = -1;
								view.updatePawn(75,1);
							}else if(k0==k2 && k0!=-1 && k2!=-1) {
								k2 =-1;
								view.updatePawn(76,2);
							}else if(k0==k3 && k0 !=-1 && k3!=-1) {
								k3 =-1;
								view.updatePawn(77,3);
							}
					}
				}else { //Turn
					view.updateInfobox("It's Player's 2 turn.");
				}
			}
		});
		view.getPawn1().addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent arg0) {
				if(turn == 1) {
					if(canMove1() && canStart1()) {	
							if(k1 == -1) {
								if(c.getValue() == 1 || (c.getValue() == 2)) 
									k1 = 3; 
								else if(card.getName() == "SorryCard") {
									if(canBeSwitched(k3)) {
										k1 = k3;
										view.updateInfobox("Your pawns can be switched.");
									}else {
										view.updateInfobox("You pawn can't be switched.");
									}
								}
							} 
							else if(c.getValue() == 4){
									k1 = k1-4;
									card7 = 0;
							}else if(c.getValue() ==7) {
								if(card7 ==7) {	
									view.updateInfobox("Your pawns moved 7 \nsteps successfully");
								}else {
									k1++;
									card7++;
								}	
							}else if(c.getValue() ==10) {
								view.showMessage("Select yes for 10 steps forward "
										+ "\nSelect no for 1 step backwards.");
								if(view.returnMessage() == 0) {
									k1 = k1+c.getValue();
								}else {
									k1--;
								}
							}else if(c.getValue() == 11) {
								view.showMessage("Select yes for 11 steps forward "
										+ "\nSelect no for switching pawn with enemy");
								if(view.returnMessage() == 0) {
									k1 = k1+c.getValue();
								}else {
									if(canBeSwitched(k3)) {
										temp = k1;
										k1 = k3;
										k3 = temp;
										view.updatePawn(k3, 3);
										view.updateInfobox("Your pawns can be switched.");
									}else {
										view.updateInfobox("You pawn can't be switched.");
									}
								}
							}else {
								card7 =0;
								k1 = k1 + c.getValue();
							}
							
							if(k1 <= -1)k1 = 59; //special case for card4.
							if(k1 == 2) k1 = 60;
							
							if(k1>-1)view.updatePawn(k1, 1); //update pawn in view
							
							if((k0==66 && k1==65) || (k0==65 && k1==66)) {
								view.getInfobox().setBackground(Color.red);
								view.getPawn0().setEnabled(false);
								view.getPawn1().setEnabled(false);
								view.getPawn2().setEnabled(false);
								view.getPawn3().setEnabled(false);
								view.getCardButton().setEnabled(false);
								view.updateInfobox("Congratulations!\n\n\nRED pawns win!!!");
							}
							//view.updateInfobox(Integer.toString(k1));
							
							//Slides
							if(k1==23 || k1==38 || k1==53) {
								k1 =k1+4;
								view.updatePawn(k1,1);
								view.updateInfobox("Slide....");
							}
							if(k1==15 || k1==30 || k1==45) {
								k1 = k1+3;
								view.updatePawn(k1,1);
								view.updateInfobox("Slide....");
							}
							//Pawns in the same position
							if(k1==k0 && k0!=-1 && k1!=-1) {
								k0 = -1;
								view.updatePawn(74,0);
							}else if(k1==k2 && k1!=-1 && k2!=-1) {
								k2 = -1;
								view.updatePawn(76,2);
							}else if(k1==k3 && k1!=-1 && k3!=-1) {
								k3 =-1;
								view.updatePawn(77,3);
							}
					}
				}else {
					view.updateInfobox("It's Player's 2 turn.");
				}
			}
		});
		view.getPawn2().addActionListener(new ActionListener(){		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(turn == 2) {
				if(canMove2() && canStart2()) {
						if(k2 == -1) {
							if(c.getValue() == 1 || (c.getValue() == 2)) 
								k2 = 33; 
							else if(card.getName() == "SorryCard") {
								if(canBeSwitched(k0)) {
									k2 = k0;
									view.updateInfobox("Your pawn can be switched.");
								}else {
									view.updateInfobox("You pawn can't be switched.");
								}
							}
						} 
						else if(c.getValue() == 4) {
							card7 =0;
							if(k2-4>=0){
								k2 = k2-4;
							}else {
								k2=59;
							}
						}else {
							if(k2 + c.getValue()>31 && k2<31 && k2>21) {
								k2 = 68;
							}else if(k2+c.getValue() > 60 && k2 < 67){ 
								k2 = 1;
							}else if(c.getValue()==7) {
								if(card7 ==7) {	
									view.updateInfobox("Your pawns moved 7 \nsteps successfully");
								}else {
									k2++;
									card7++;
								}	
							}else if(c.getValue() ==10) {
								view.showMessage("Select yes for 10 steps forward "
										+ "\nSelect no for 1 step backwards.");
								if(view.returnMessage() == 0) {
									k2 = k2+c.getValue();
								}else {
									k2--;
								}	
							}else if(c.getValue() == 11) {
								view.showMessage("Select yes for 11 steps forward "
										+ "\nSelect no for switching pawns with enemy");
								if(view.returnMessage() == 0) {
									k2 = k2+c.getValue();
								}else {
									if(canBeSwitched(k0)) {
										temp = k2;
										k2 = k0;
										k0 = temp;
										view.updatePawn(k0, 0);
										view.updateInfobox("Your pawns can be switched.");
									}else {
										view.updateInfobox("You pawn can't be switched.");
									}
								}
							}else{
								card7 = 0;
								k2 = k2 + c.getValue();
							}						
						}
						//Slide
						if(k2 == 60) {
							k2 = 3;
							view.updateInfobox("Slide....");
						}
						if(k2 == 31 && c.getValue()!=4) {
							k2=67;
						}
						if(k2 ==30) {
							k2=29;
						}
						//if(k2 == 31 || k2 ==30) k2 = 67;
						
						if(k2>-1)view.updatePawn(k2, 2); //update pawn
						
						//Check if there is a winner.
						if((k2 == 73 && k3==72) ||(k2==72 && k3==73)) {
							view.getInfobox().setBackground(Color.yellow);
							view.getPawn0().setEnabled(false);
							view.getPawn1().setEnabled(false);
							view.getPawn2().setEnabled(false);
							view.getPawn3().setEnabled(false);
							view.getCardButton().setEnabled(false);
							view.updateInfobox("Congratulations!\nYELLOW pawns win!");
						}
					  //view.updateInfobox(Integer.toString(k2));
						if(k2==8 || k2==23 || k2==53) {
							k2 =k2+4;
							view.updatePawn(k2,2);
							view.updateInfobox("Slide....");
						}
						if(k2 ==15 || k2==45) {
							k2 = k2+3;
							view.updatePawn(k2,2);
							view.updateInfobox("Slide....");
						}
						
						//Pawns in the same position
						if(k2 == k0 && k2!=-1 && k0!=-1) {
							k0 = -1;
							view.updatePawn(74,0);
						}else if(k2 == k1 && k2!= -1 && k1!=-1) {
							k1 = -1;
							view.updatePawn(75,1);
						}else if(k2 == k3 && k2!=-1 && k3!=-1) {
							k3 =-1;
							view.updatePawn(77,3);
						}
				} 
			}else {
				view.updateInfobox("It's Player's 1 turn.");
			}
		}
		});
		view.getPawn3().addActionListener(new ActionListener(){		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(turn == 2) {
				if(canMove3() && canStart3()) {
						if(k3 == -1) {
							if(c.getValue() == 1 || (c.getValue() == 2)) 
								k3 = 33; 
							else if(card.getName() == "SorryCard") {
								if(canBeSwitched(k1) && k3 ==-1) {
									k3 = k1;
									view.updateInfobox("Your pawns can be switched.");
								}else {
									view.updateInfobox("You pawn can't be switched.");
								}
							}
						} 
						else if(c.getValue() == 4) {
							card7 = 0;
							if(k3-4>=0){
								k3 = k3-4;
							}else {
								k3 =59;
							}
						}else {
							if(k3 + c.getValue()>31 && k3<31 && k3>21) {
								k3 = 67;
							}else if(k3+c.getValue() > 60 && k3 < 67){ 
								k3 = 1;
							}else if(c.getValue()==7) {
								if(card7 ==7) {	
									view.updateInfobox("Your pawns moved 7 \nsteps successfully");
								}else {
									k3++;
									card7++;
								}
							}else if(c.getValue() ==10) {
								view.showMessage("Select yes for 10 steps forward "
										+ "\nSelect no for 1 step backwards.");
								if(view.returnMessage() == 0) {
									k3 = k3+c.getValue();
								}else {
									k3--;
								}		
							}else if(c.getValue() == 11) {
								view.showMessage("Select yes for 11 steps forward "
										+ "\nSelect no for switching pawns with enemy");
								if(view.returnMessage() == 0) {
									k3 = k3+c.getValue();
								}else {
									if(canBeSwitched(k1)) {
										temp = k3;
										k3 = k1;
										k1 = k3;
										view.updatePawn(k1, 1);
										view.updateInfobox("Your pawns can be switched.");
									}else {
										view.updateInfobox("You pawn can't be switched.");
									}
								}
							}else {
								card7 = 0;
								k3 = k3 + c.getValue();
							}						
						}
						
						if(k3 == 60) {
							k3 = 3;
							view.updateInfobox("Slide....");
						}
						if(k3 == 31 && c.getValue()!=4) {
							k3=67;
						}
						if(k3 == 30) {
							k3 =29;
						}
						
						if(k3>-1)view.updatePawn(k3, 3); //update the view.
						
						//Check for a winner.
						if((k2 == 73 && k3==72) ||(k2==72 && k3==73)) {
							view.getInfobox().setBackground(Color.yellow);
							view.getPawn0().setEnabled(false);
							view.getPawn1().setEnabled(false);
							view.getPawn2().setEnabled(false);
							view.getPawn3().setEnabled(false);
							view.getCardButton().setEnabled(false);
							view.updateInfobox("Congratulations!\n\n\nYELLOW pawns win!");
						}
						//view.updateInfobox(Integer.toString(k3));
						
						//Slides..
						if(k3==8 || k3==23 || k3==53) {
							k3 =k3+4;
							view.updatePawn(k3,3);
							view.updateInfobox("Slide....");
						}
						if(k3==15 || k3==45) {
							k3 = k3+3;
							view.updatePawn(k3,3);
							view.updateInfobox("Slide....");
						}
						
						//Pawns in the same position
						if(k3 == k0 && k3!=-1 && k0!=-1) {
							k0 = -1;
							view.updatePawn(74,0);
						}else if(k3 == k1 && k3!=-1 && k1!=-1) {
							k1 = -1;
							view.updatePawn(75,1);
						}else if(k3 == k2 && k3!=-1 && k2!=-1) {
							k2 = -1;
							view.updatePawn(76,2);
						}
				}	
			}else {
				view.updateInfobox("It's Player's 1 turn.");
			}
		}
		});
		
		view.getFoldbutton().addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent arg0) {
				view.updateInfobox("Fold Button, next player.");
			}
		});	
	}
	
	public boolean canBeSwitched(int i) {
		if(i <= -1)return false;
		if(squares[i].getName() == "SafetyZoneSquare" || squares[i].getName() == "HomeSquare"||
		squares[i].getName() == "StartSquare") {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * Check if the player can start.
	 */
	public boolean canStart0() {
		if(k0 == -1) { // check if player has start
			if(c.getValue() == 1 || c.getValue() == 2 || card.getName() =="SorryCard"){ //if pawn can start
				return true;
			}else {
				view.updateInfobox("You can't move from start \nposition with this card."
						+ "\nPlease select fold.");
				return false; //else it doesn't start
			}	
		}else {
			return true;
		}
	}	

		
	public boolean canStart1() {
		if(k1 == -1) {
			if(c.getValue() == 1 || c.getValue() == 2 || card.getName() =="SorryCard"){
				return true;
			}else {
				view.updateInfobox("You can't move from start \nposition with this card."
						+ "\nPlease select fold.");
				return false; 
			}	
		}else {
			return true;
		}
	}
	
	public boolean canStart2() {
		if(k2 == -1) { 
			if(c.getValue() == 1 || c.getValue() == 2 || card.getName() =="SorryCard"){
				return true;
			}else {
				view.updateInfobox("You can't move from start \nposition with this card."
						+ "\nPlease select fold.");
				return false;
			}	
		}else {
			return true;
		}
	}

	public boolean canStart3() {
		if(k3 == -1) {
			if(c.getValue() == 1 || c.getValue() == 2 || card.getName() =="SorryCard"){
				return true;
			}else {
				view.updateInfobox("You can't move from start \nposition with this card."
						+ "\nPlease select fold.");
				return false;
			}	
		}else {
			return true;
		}
	}

	public boolean canMove0() {
		if(card.getName() != "SorryCard") {
			if(k0+c.getValue() > 66){
				view.updateInfobox("You can't move pawn with\nthis card,please select fold.");
				return false;
			}
		}
		return true;
	}

	public boolean canMove1() {
		//if(card.getName() != "SorryCard") {
			if(k1+c.getValue() > 66) {
				view.updateInfobox("You can't move pawn with\nthis card, please select fold.");
				return false;
			}
		//}
		return true;
	}

	public boolean canMove2() {
		if(card.getName() != "SorryCard") {
			if(k2+c.getValue()>=74) {
				view.updateInfobox("You can't move pawn with\nthis card,please select fold.");
				return false;
			}
		}
		return true;
	}

	public boolean canMove3() {
		if(card.getName() != "SorryCard") {
			if(k3+c.getValue()>=74) {
				view.updateInfobox("You can't move pawn with\nthis card,please select fold.");
				return false;
			}
		}
		return true;
	}
	/**
	 * Transformer , Initialize all the pawns.
	 */
	public void initPawns() {
		pawns[0] = new Pawn(Color.red,-1);
		pawns[1] = new Pawn(Color.red,-1);
		pawns[2] = new Pawn(Color.yellow,-1);
		pawns[3] = new Pawn(Color.yellow,-1);
		player1 = new Player(Color.red, "Player1", pawns[0], pawns[1]);
		player2 =  new Player(Color.yellow, "Player2", pawns[2], pawns[3]);
	}
	/**
	 * Transformer , Initialize all the squares.
	 */
	public void initSquares() {
		for(int i  = 0; i < 78;i++) {	
			if(i==0||i == 8||i==15||i==23||i==30|| i==38 || i==45 || i==53) { 
				squares[i] = new StartSlideSquare(i,"StartSlideSquare");
			
			}else if(i==1||i == 2||i==9||i==10||i==11|| i==16 ||
					i==17||i == 24||i==25||i==26||i==31|| i==32 || i==39|| i==40
					||i==41||i==46||i==47||i==54||i==55||i==56) {
				squares[i] = new InternalSlideSquare(i,"InternalSlideSquare");
			
			}else if(i==3||i == 12||i==18||i==27||i==33||i==42||i==48||i==57) {
				squares[i] = new EndSlideSquare(i,"EndSlideSquare");
					
			}else if(i == 60||i==61||i==62||i==63||i==64||i==67||
					i==68||i==69||i==70||i==71) {
				squares[i] = new SafetyZoneSquare(i,"SafetyZoneSquare");
			
			}else if(i==65||i==66||i==72|| i==73) { 
				squares[i] = new HomeSquare(i,"HomeSquare");
			}else if(i==74||i==75||i==76||i==77) {
				squares[i] = new StartSquare(i,"StartSquare");
			}else //the white squares
				squares[i] = new SimpleSquare(i,"SimpleSquare");
		}
	}
	/**
	 * Removes and replace a card.
	 * @param positionOfCard the position that we want to replace
	 */
	public void removeAndReplaceCard(int positionOfCard) {
		if(deck.getGameCards().isEmpty()) {
			deck.initCards(); //shuffle  the cards again.
		}else {
			deck.getGameCards().remove(positionOfCard);
			
			card = deck.getGameCards().get(positionOfCard+1);
			if(card.getName() != "SorryCard") {
				c = (NumberCard) deck.getGameCards().get(positionOfCard+1);
			}
			view.updateCard(card);
			if(c.getValue() != 2) {
				if(turn % 2 == 0) {
					turn=1;
				}else {
					turn=2;
				}
			}
			view.updateInfobox("                      Infobox\n"
					+ "Cards left: " + cardscounter + "   "
					+"     Turn: Player"+ turn +"\n"+ card.toString());	
		}
		if(cardscounter == 24) {
			deck.initCards();
			cardscounter = 23;
		}
		if(cardscounter == 1) {
			deck.initCards();
			cardscounter = 45;
		}
		cardscounter--;
	}
	/**
	 * Check if the game has finished.
	 * @return true or false if the game is finished or not.
	 */
	//public boolean CheckIfGameFinished() {
		//if(player1.isHasFinished() || player2.isHasFinished()) 
			//return true;
		//return false;
	//}
	
}
