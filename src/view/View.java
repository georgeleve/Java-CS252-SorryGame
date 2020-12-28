package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import Model.card.Card;
/**
 * Class View that has all the graphics of the game.
 * @author George Leventopoulos
 */
@SuppressWarnings("serial")
public class View extends JFrame {
	//Fields of class view.
	private JFrame frame; //The frame
	private JLayeredPane back;  // For all of the backround.
	
	//For right side.
	private JMenuBar menu; //The menu 
	private JButton foldButton, Card1;
	private JLabel Card2; //Receive card button , Current Card button
	private JTextArea infobox; // Information box.
	private JLabel ReceiveCard, CurrentCard; //Text for receive card and current card.
	
	//For left side.
	private JLabel logo; //Sorry logo.
	private JLabel redHome, yellowHome,redStart, yellowStart;
	private JLabel backround; // Sets the backround.
	private JLabel txt1,txt2,txt3,txt4;//,txt6,txt7; //texts
	private JLabel[] square = new JLabel[100]; //the array that keeps the squares.
	private JButton[] pawns = new JButton[4]; //Array for pawns.
	private JButton exit; //button to exit the game.
	//private JButton f0,f1,f2,f3,b0,b1,b2,b3; //when i press this button I move the pawns[0] forward.
	private int index = 0; //variable that keeps the squares in the view.
	private int i = 0; //temporary variable.
	private int dialogButton = JOptionPane.YES_NO_OPTION;
	//Create the images that we are going to resize.
	ImageIcon card1 = new ImageIcon("images/cards/backCard.png");
	ImageIcon pawn0 = new ImageIcon("images/pawns/redPawn1.png");
	ImageIcon pawn1 = new ImageIcon("images/pawns/redPawn2.png");
	ImageIcon pawn2 = new ImageIcon("images/pawns/yellowpawn1.png");
	ImageIcon pawn3 = new ImageIcon("images/pawns/yellowPawn2.png");
	ImageIcon logos = new ImageIcon("images/sorryImage.jpg");
	ImageIcon greenback = new ImageIcon("images/background.png");
	int dialogResult;
	/** 
	 * Constructor for class view that creates every snapshot we need in the game.
	 */
	public View() {
		frame = new JFrame("Sorry Game");
		menu = new JMenuBar();
		exit = new JButton();
		/*b0 = new JButton();
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		f0 = new JButton();
		f1 = new JButton();
		f2 = new JButton();
		f3 = new JButton();*/
		//Right Side
		Card1 = new JButton();
		Card2 =  new JLabel();
		foldButton = new JButton();
		infobox = new JTextArea();
		ReceiveCard = new JLabel();
		CurrentCard = new JLabel();
		//Left Side
		pawns[0] = new JButton(); //red pawn0
		pawns[1] = new JButton(); //red pawn1
		pawns[2] = new JButton(); //yellow pawn0
		pawns[3] = new JButton(); //yellow pawn1
		redHome = new JLabel();
		yellowHome = new JLabel();
		redStart = new JLabel();
		yellowStart = new JLabel();
		backround = new JLabel();
		logo = new JLabel();
		//Texts 
		txt1 = new JLabel();
		txt2 = new JLabel();
		txt3 = new JLabel();
		txt4 = new JLabel();
		//txt6 = new JLabel();
		//txt7 = new JLabel();
		back = new JLayeredPane();
		resizeImages();
		initComponents(); 
		initButtons();
		//initListeners();
	}
	/**
	 * Intialize all the components.
	 */
	private void initComponents() { 
		frame.setSize(new Dimension(850, 800));
		frame.setVisible(true); 
		
		back.setBounds(0,0,850,800);
		
		backround.setIcon(greenback);
		backround.setOpaque(true);
		backround.setBounds(0, 0, 850, 800);
		back.add(backround,0);
		frame.add(back);
		
		//Create the Menu Bar
		frame.setJMenuBar(menu);
		
		JMenu newGame = new JMenu("New Game");
		menu.add(newGame);
		
		JMenu saveGame = new JMenu("Save Game");
		menu.add(saveGame);
		
		JMenu Continue = new JMenu("Continue");
		menu.add(Continue);
		
		JMenu savedGame = new JMenu("Saved Game");
		menu.add(savedGame);
	
		infobox.setOpaque(true);
		infobox.setBounds(650, 350, 180, 90);
		infobox.setBackground(Color.white);
		infobox.setText("Please select card..");
		Border a = BorderFactory.createLineBorder(Color.black, 3);
		infobox.setBorder(a);
		infobox.setEditable(false);
		
		logo.setIcon(logos);
		logo.setOpaque(true);		
		logo.setBounds(160,300,300,70);
		logo.setBackground(Color.white);
		a = BorderFactory.createLineBorder(Color.black, 1);
		logo.setBorder(a);
		
		CurrentCard.setOpaque(false);		
		CurrentCard.setBounds(755,270,80,20);
		CurrentCard.setText("Current Card");
		
		ReceiveCard.setOpaque(false);
		ReceiveCard.setBounds(655,270,80,20);
		ReceiveCard.setText("Receive Card");

		txt1.setOpaque(true);
		txt1.setBounds(167,105,50,20);
		txt1.setBackground(Color.white);
		txt1.setText("Start");
		
		txt2.setOpaque(true);
		txt2.setBounds(80,310,50,20);
		txt2.setBackground(Color.white);
		txt2.setText("Home");
		
		txt3.setOpaque(true);
		txt3.setBounds(430,540,50,20);
		txt3.setBackground(Color.white);
		txt3.setText("Start");
		
		txt4.setOpaque(true);
		txt4.setBounds(525,340,50,20);
		txt4.setBackground(Color.white);
		txt4.setText("Home");
		/*
		txt6.setOpaque(false);
		txt6.setBounds(670,440,80,20);
		txt6.setText("Move Forward");
		
		txt7.setOpaque(false);
		txt7.setBounds(670,560,100,20);
		txt7.setText("Move Backwards");*/
		
		// Red Start
		redStart.setOpaque(true);
		a = BorderFactory.createLineBorder(Color.red, 3);
		redStart.setBorder(a);
		redStart.setBackground(Color.white);
		redStart.setBounds(140, 55, 80, 80);
		back.add(redStart,0);	
		
		// Yellow Start
		yellowStart.setOpaque(true);
		a = BorderFactory.createLineBorder(Color.YELLOW, 3);
		yellowStart.setBorder(a);
		yellowStart.setBackground(Color.white);
		yellowStart.setBounds(410, 535, 80, 80);
		back.add(yellowStart,0);
		
		// Up Squares(red)
		for(i = 0; i < 14; i++) {
			square[index] = new JLabel();
			square[index].setOpaque(true);
			a = BorderFactory.createLineBorder(Color.black, 3);
			square[index].setBorder(a);
			//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
			square[index].setBackground(Color.white);
			square[index].setBounds(40 + 40*i, 15, 40, 40);
			// IMAGES
			if(index == 0 || index == 8) {
				square[index].setIcon(new ImageIcon("images/slides/redSlideStart.png"));
			}
			if(index == 1 || index == 2 || index == 9 || index == 10 || i == 11) {
				square[index].setIcon(new ImageIcon("images/slides/redSlideMedium.png"));
			}
			if(i == 3 || i == 12) {
				square[index].setIcon(new ImageIcon("images/slides/redSlideEnd.png"));
			}
			back.add(square[index++],1);
		}
		// Right squares (blue)
		for(i = 0; i < 16; i++) {
			square[index] = new JLabel();
			square[index].setOpaque(true);
			a = BorderFactory.createLineBorder(Color.black, 3);
			square[index].setBorder(a);
			//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
			square[index].setBackground(Color.white);
			square[index].setBounds(600, 40*i + 15, 40, 40);
			//IMAGES
			if(index == 15 || index == 23) {
				square[index].setIcon(new ImageIcon("images/slides/blueSlideStart.png"));
			}
			if(index == 16 || index == 17 || index == 24 || index == 25 || index == 26) {
				square[index].setIcon(new ImageIcon("images/slides/blueSlideMedium.png"));
			}
			if(index == 18 || i == 13) {
				square[index].setIcon(new ImageIcon("images/slides/blueSlideEnd.png"));
			}
			back.add(square[index++],1);
		}	
		//Down squares (yellow)
		for(i = 14; i > 0; i--) {
			square[index] = new JLabel();
			square[index].setOpaque(true);
			a = BorderFactory.createLineBorder(Color.black, 3);
			square[index].setBorder(a);
			//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
			square[index].setBackground(Color.white);
			square[index].setBounds(560 - 40*(14-i) , 615, 40, 40);
			//IMAGES
			if(index == 30 || index == 38) {
				square[index].setIcon(new ImageIcon("images/slides/yellowSlideStart.png"));
			}
			if(index == 31 || index == 32 || index == 39 || index == 40 || index == 41) {
				square[index].setIcon(new ImageIcon("images/slides/yellowSlideMedium.png"));
			}
			if(index == 33 || index == 42) {
				square[index].setIcon(new ImageIcon("images/slides/yellowSlideEnd.png"));
			}
			back.add(square[index++],1);                 
		}
		// Left squares(green)
		for(i = 0; i < 16; i++) {
			square[index] = new JLabel();
			square[index].setOpaque(true);
			a = BorderFactory.createLineBorder(Color.black, 3);
			square[index].setBorder(a);
			//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
			square[index].setBackground(Color.white);
			square[index].setBounds(0, 615 - 40*i, 40, 40);
			// IMAGES
			if(index == 53 || index == 45) {
				square[index].setIcon(new ImageIcon("images/slides/greenSlideStart.png"));
			}
			if(index == 46 || index == 47 || index == 54 || index == 55 || index == 56) {
				square[index].setIcon(new ImageIcon("images/slides/greenSlideMedium.png"));
			}
			if(index == 48 || index == 57) {
				square[index].setIcon(new ImageIcon("images/slides/greenSlideEnd.png"));
			}
			back.add(square[index++],1);					
		}		
		// Red Squares
		for(i = 1; i < 6; i++) {
			square[index] = new JLabel();
			square[index].setOpaque(true);
			a = BorderFactory.createLineBorder(Color.black, 3);
			square[index].setBorder(a);
			square[index].setBackground(Color.red);
			//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
			square[index].setBounds(80, 40*i + 15, 40, 40);
			back.add(square[index++],1);
		}
		
		// Red Home square
		redHome.setOpaque(true);
		a = BorderFactory.createLineBorder(Color.red, 3);
		redHome.setBorder(a);
		redHome.setBackground(Color.white);
		redHome.setBounds(60, 255, 80, 80);
		back.add(redHome,1);
		
		//RedHome 1
		square[index] = new JLabel();
		square[index].setOpaque(true);
		a = BorderFactory.createLineBorder(Color.black, 1);
		square[index].setBorder(a);
		//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
		square[index].setBackground(Color.red);
		square[index].setBounds(65, 270, 35, 35);
		back.add(square[index++],1);
		
		//RedHome 2
		square[index] = new JLabel();
		square[index].setOpaque(true);
		a = BorderFactory.createLineBorder(Color.black, 1);
		square[index].setBorder(a);
		//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
		square[index].setBackground(Color.red);
		square[index].setBounds(100, 270, 35, 35);
		back.add(square[index++],1);
			
		// Yellow Home square
		yellowHome.setOpaque(true);
		a = BorderFactory.createLineBorder(Color.yellow, 3);
		yellowHome.setBorder(a);
		yellowHome.setBackground(Color.white);
		yellowHome.setBounds(500, 335, 80, 80);
		back.add(yellowHome,1);
		
		// Yellow squares 
		for(i = 0; i < 5; i++) {
			square[index] = new JLabel();
			square[index].setOpaque(true);
			a = BorderFactory.createLineBorder(Color.black, 3);
			square[index].setBorder(a);
			//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
			square[index].setBackground(Color.yellow);
			square[index].setBounds(520, 415 + 40*4 - 40*i, 40, 40);
			back.add(square[index++],1);
		}		
		// Yellow Home 1
		square[index] = new JLabel();
		square[index].setOpaque(true);
		a = BorderFactory.createLineBorder(Color.black, 1);
		square[index].setBorder(a);
		//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
		square[index].setBackground(Color.yellow);
		square[index].setBounds(505, 370, 35, 35);
		back.add(square[index++],1);
		
		//Yellow Home 2
		square[index] = new JLabel();
		square[index].setOpaque(true);
		a = BorderFactory.createLineBorder(Color.black, 1);
		square[index].setBorder(a);
		//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
		square[index].setBackground(Color.yellow);
		square[index].setBounds(540, 370, 35, 35);
		back.add(square[index++],1);
		
		
		//Red Start 1
		square[index] = new JLabel();
		square[index].setOpaque(true);
		a = BorderFactory.createLineBorder(Color.black, 1);
		square[index].setBorder(a);
		//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
		square[index].setBackground(Color.red);
		square[index].setBounds(145, 70, 35, 35);
		back.add(square[index++],1);
		
		//Red Start 2
		square[index] = new JLabel();
		square[index].setOpaque(true);
		a = BorderFactory.createLineBorder(Color.black, 1);
		square[index].setBorder(a);
		//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
		square[index].setBackground(Color.red);
		square[index].setBounds(180, 70, 35, 35);
		back.add(square[index++],1);
		
		//Yellow Start 1
		square[index] = new JLabel();
		square[index].setOpaque(true);
		a = BorderFactory.createLineBorder(Color.black, 1);
		square[index].setBorder(a);
		//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
		square[index].setBackground(Color.yellow);
		square[index].setBounds(415, 570, 35,35);
		back.add(square[index++],0);
		
		//Yellow Start 2
		square[index] = new JLabel();
		square[index].setOpaque(true);
		a = BorderFactory.createLineBorder(Color.black, 1);
		square[index].setBorder(a);
		//square[index].setText(Integer.toString(index)); //UNCOMMENT FOR DEBUGGING
		square[index].setBackground(Color.yellow);
		square[index].setBounds(450, 570, 35, 35);
		back.add(square[index++],0);
		
		
		//Add the elements to the back
		back.add(logo,1);
		back.add(Card1,1);
		back.add(Card2,1);
		back.add(infobox,1);		
	}
	/**
	 * Initialize all the buttons
	 */
	public void initButtons(){
		/*
		 * UNCOMMENT FOR DEBBUGING
		f0.setIcon(pawn0);
		f0.setBounds(670, 460, 35, 35);
		f1.setIcon(pawn1);
		f1.setBounds(720, 460, 35, 35);
		f2.setIcon(pawn2);
		f2.setBounds(670, 500, 35, 35);
		f3.setIcon(pawn3);
		f3.setBounds(720, 500, 35, 35);
		
		b0.setIcon(pawn0);
		b0.setBounds(670, 580, 35, 35);
		b1.setIcon(pawn1);
		b1.setBounds(720, 580, 35, 35);
		b2.setIcon(pawn2);
		b2.setBounds(670, 620, 35, 35);
		b3.setIcon(pawn3);
		b3.setBounds(720, 620, 35, 35);
		*/
		pawns[0].setIcon(pawn0);
		pawns[0].setBounds(145, 70, 35, 35);
		
		pawns[1].setIcon(pawn1);
		pawns[1].setBounds(180, 70, 35, 35);
		
		pawns[2].setIcon(pawn2);
		pawns[2].setBounds(415, 570, 35, 35);
		
		pawns[3].setIcon(pawn3);
		pawns[3].setBounds(450, 570, 35, 35);
			
		Card1.setIcon(card1);
		Card1.setBounds(650, 150, 80, 120);
		
		Card2.setIcon(card1);
		Card2.setBounds(750, 150, 80, 120);
		
		foldButton.setBackground(Color.red);
		Border n = BorderFactory.createLineBorder(Color.black, 2);
		foldButton.setBorder(n);
		foldButton.setBounds(650, 310, 180, 35);
		foldButton.setText("Fold Button");
		
		exit.setOpaque(true);
		exit.setBounds(720, 15, 100, 20);
		exit.setBackground(Color.gray);
		exit.setText("Exit Button");
		
		back.add(ReceiveCard,1);
		back.add(CurrentCard,1);
		back.add(foldButton,1);
		back.add(txt1,0);
		back.add(txt2,0);
		back.add(txt3,0);
		back.add(txt4,0);
		//back.add(txt6,0);
		//back.add(txt7,0);
		back.add(pawns[0], 2);
		back.add(pawns[1], 2);
		back.add(pawns[2], 2);
		back.add(pawns[3], 2);	
		back.add(exit,2);
		/*
		back.add(b0,1);
		back.add(b1,1);
		back.add(b2,1);
		back.add(b3,1);
		back.add(f0,1);
		back.add(f1,1);
		back.add(f2,1);
		back.add(f3,1);*/
	}
	/**
	 * Update the Card1 depending on the card that the player take. 
	 * Get the image path, resize the image and repaint back.
	 * @param Card1 the button that the user press in order to change card.
	 */
	public void updateCard(Card card) {
		ImageIcon cardImage = new ImageIcon(card.getImage());
	    Image newCardImage = cardImage.getImage();
		Image modifiedCardImage = newCardImage.getScaledInstance(80, 120, java.awt.Image.SCALE_SMOOTH);
	    Card2.setIcon(new ImageIcon(modifiedCardImage));
	    back.repaint();
	}
	/**
	 * Update the pawns position
	 * @param position the position of the pawn.
	 */
	public void updatePawn(int position, int p) {
		pawns[p].setBounds(1,1,40,40);
		square[position].add(pawns[p],0);
		back.repaint();
	}
	/**
	 * Updates the infobox
	 * @param message the info that we want to show to the user.
	 */
	public void updateInfobox(String message) {
		infobox.setText(message);
		back.repaint();
	}
	/**
	 * Returns the Button that the player press.
	 * @return Card1 the button that the user press in order to change card.
	 */
	public JButton getCardButton() {
		return Card1;
	}
	/**
	 * Returns the back
	 * @return the back
	 */
	public JLayeredPane getBack() {
		return back;
	}
	/**
	 * Returns the infobox
	 * @return the infobox
	 */
	public JTextArea getInfobox() {
		return infobox;
	}
	/**
	 * Returns the 1st red pawn.
	 * @return pawns[0] the 1st red pawn
	 */
	public JButton getPawn0(){
		return pawns[0];
	}
	/**
	 * Returns the 2nd yellow pawn.
	 * @return panws[1] the 2nd yellow pawn
	 */
	public JButton getPawn1(){
		return pawns[1];
	}
	/**
	 * Returns the 1st yellow pawn.
	 * @return pawns[2] the 1st yellow pawn
	 */
	public JButton getPawn2(){
		return pawns[2];
	}
	/**
	 * Returns the 2nd yellow pawn.
	 * @return pawns[3] the 2nd yellow pawn
	 */
	public JButton getPawn3(){
		return pawns[3];
	}
	/**
	 * Returns fold button.
	 * @return foldbutton
	 */
	public JButton getFoldbutton() {
		return foldButton;
	}
	/**
	 * Returns the exit button.
	 * @return the exit button 
	 */
	public JButton getExitButton() {
		return exit;
	}
	/**
	 * Shows the message for card11.
	 */
	public void showMessage(String message) {
		dialogResult = JOptionPane.showConfirmDialog(this, message, "Option", dialogButton);
	}
	/**
	 * Reurns the dialog result
	 * @return dialogResult the result of the dialog
	 */
	public int returnMessage() {
		return dialogResult;
	}
	/**
	 * Resize all the images.
	 */
	public void resizeImages() {
		Image greenbackImage = greenback.getImage();
		Image modifiedgreenbackImage = greenbackImage.getScaledInstance(850, 800, java.awt.Image.SCALE_SMOOTH);
		greenback =  new ImageIcon(modifiedgreenbackImage);
			
		Image card1Image = card1.getImage();
		Image modified1Image = card1Image.getScaledInstance(80, 120, java.awt.Image.SCALE_SMOOTH);
		card1 =  new ImageIcon(modified1Image);
			
		Image pawnImage = pawn0.getImage();
		Image modifiedpawnImage0 = pawnImage.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		pawn0 =  new ImageIcon(modifiedpawnImage0);
		
		Image pawnImage1 = pawn1.getImage();
		Image modifiedpawnImage1 = pawnImage1.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		pawn1 =  new ImageIcon(modifiedpawnImage1);
			
		Image pawnImage2 = pawn2.getImage();
		Image modifiedpawnImage2 = pawnImage2.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		pawn2 =  new ImageIcon(modifiedpawnImage2);
			
		Image pawnImage3 = pawn3.getImage();
		Image modifiedpawnImage3 = pawnImage3.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		pawn3 =  new ImageIcon(modifiedpawnImage3);
			
		Image logoImage = logos.getImage();
		Image modifiedlogoImage = logoImage.getScaledInstance(300, 70, java.awt.Image.SCALE_SMOOTH);
		logos =  new ImageIcon(modifiedlogoImage);
	}
	/*
	public void initListeners() {	
		exit.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		f0.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updatePawn(k0, 0);
				k0++;
				if(k0 == 60) k0 = 0;
				if(k0 == 2) k0 = 60;
				
				if((k0==66 && k1==67) || (k0==67 && k1==66)) {
					infobox.setBackground(Color.red);
					updateInfobox("Congratulations!\n\n\nRED pawns win!!!");
				}
			}
		});
		
		f1.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updatePawn(k1, 1);
				k1++;
				if(k1 == 60) k1 = 0;
				if(k1 == 2) k1 = 60;
				if((k0==66 && k1==67) ||(k0==67 && k1==66)) {
					infobox.setBackground(Color.red);
					updateInfobox("Congratulations!\n\n\nRED pawns win!!!");
				}
			}
		});
		
		
		f3.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updatePawn(k3, 3);		
				k3++;
				if(k3 == 60) k3 = 0;
				if(k3 == 32) k3 = 67;
				if((k2==73 && k3==74) ||(k2==74 && k3==73)) {
					infobox.setBackground(Color.yellow);
					updateInfobox("Congratulations!\n\n\nYELLOW pawns win!");
				}
			}
		});
		
		b0.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				k0--;
				if(k0 == -1)k0 = 59;
				updatePawn(k0, 0);
			}
		});
		
		b1.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				k1--;
				if(k1 == -1)k1 = 59;
				updatePawn(k1, 1);
			}
		});
		
		b2.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				k2--;
				if(k2 == -1) k2 = 59;
				updatePawn(k2, 2);
			}
		});
		
		b3.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				k3--;
				if(k3 == -1) k3=59;
				updatePawn(k3, 3);
			}
		});
	}*/
}