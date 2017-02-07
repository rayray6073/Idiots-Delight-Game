import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * @author Rachel C
 */
public class Card implements Comparable<Card> {
	/**this is the value of the rank for each card **/
	private int rank;
	/**this is the value of the suite for each card**/
	private int suite;
	/**this is the value of the string King**/
	int KING = 13;
	/**this is the value of the string Queen**/
	int QUEEN= 12;
	/**this is the value of the string Jack**/
	int JACK = 11;
	/**this is the value of the string Ace**/
	int ACE = 1;
	/**this is the value of the string club**/
	int club = 14;
	/**this is the value of the string heart**/
	int heart = 15;
	/**this is the value of the string spade**/
	int spade = 16; 
	/**this is the value of the string diamond**/
	int diamond = 17; 
	
	/**this is the picture of the card**/
	private ImageIcon image;
	/**this is the picture of the back of the cards**/
	private ImageIcon back;

	
	/**this is the value of anything with no value **/
	public static final int NONE = -1;
	
	/**
	 * this is the constructor that initializes the rank and the suite from 
	 * inputs given 
	 * @param suite is the value of the suite
	 * @param rank is the value of the rank
	 */
	public Card(int suite, int rank) {
		this.rank = rank;
		this.suite = suite;
	
		this.back = new ImageIcon("back.png");
		this.image = new ImageIcon(fileName());

	}
	
	/**
	 * this is a constructor that creates a blank card 
	 * there is no value for the rank or suite 
	 */
	public Card(){
		this.rank=NONE;
		this.suite=NONE;
		
	}
	
	/**
	 * this method returns the value of the height
	 * @return an in that is the value of the height
	 */
	public int getCardHeight(){
		int a = back.getIconHeight();
		return a; 
	}
	
	/**
	 * this method returns the value of the width 
	 * @return an int value of the width 
	 */
	public int getCardWidth(){
		int a = back.getIconWidth();
		return a;
	}
	
	/**
	 * this method paints/draws the cards 
	 * @param c is what the picture is going to be drawn on
	 * @param g is the picture that actually is going to drawn
	 * @param x is the x axis location of the picture in the top right hand corner
	 * @param y is the y axis location of the picture in the top right hand corner
	 */
	public void draw(Component c, Graphics g, int x , int y){
		image.paintIcon(c, g, x, y);
	}
	
	/**
	 * this is a helper method that converts the int values of the suit into 
	 * a letter so the correct picture file can be selected
	 * @param suit is the value of the suite for the picture
	 * @return a string that has the letter representation of the suite
	 */
	private String suiteLetter(int suit){
		String suitL;
		if(suit == 14){
			suitL = "c";
		}else if (suit ==15){
			suitL = "h";
		}else if (suit == 16){
			suitL = "s";
		}else{
			suitL = "d";
		}
		return suitL;

	}
	
	/**
	 * this is a helper method that converts the int value of the rank into a letter representation 
	 * @param rank takes in the int value of the rank 
	 * @return string that represents the rank
	 */
	private String rankLetter(int rank){
		String rankL = null;;
		if(rank == ACE){
			rankL = "a";
		}else if(rank > 1 && rank < 10){
			rankL = rank+"";
			}else if (rank == 10){
				rankL="t";
			}else if (rank == JACK){
				rankL="j";
			}else if (rank == QUEEN){
				rankL = "q";
			}else if (rank == 13){
				rankL = "k";
			}
		return rankL;
	}
	
	/**
	 * this method combines the value of the rankLetter and suiteLetter 
	 * to make the file name of the correct card
	 * @return returns a string of the file name
	 */
	public String fileName(){
		int r = getCardRank();
		String rankL = rankLetter(r);
		int s = getCardSuite();
		String suitL = suiteLetter(s);
		
		String name = rankL+suitL+".png";
		return name;
		
	}
	
	/**
	 * this gets the int value of the suite
	 * @return the int value of the suite
	 */
	public int getCardSuite(){
		int b = this.suite;
		return b;
	}
	
	/**
	 * gets the int value of the rank
	 * @return returns the int value of the rank
	 */
	public int getCardRank(){
		int r = this.rank;
		return r;
	}
	
	/**
	 * sets the value of the rank and the suite 
	 * @param suite is the int value of the suite 
	 * @param rank is the int value of the rank 
	 */
	public void setCardType(int suite, int rank){
		this.suite=suite;
		this.rank=rank;
	}
	
	/**
	 * this checks whether to cards are equal to each other 
	 * @param another card 
	 * @return whether its true that they are equal or false if they
	 * are not
	 */
	public boolean equals(Object obj){
		Card c;
		try {
			c = (Card) obj;
		}
		catch (ClassCastException cce){
			throw new IllegalArgumentException("lhdlvslkvd");
		}
		if(this.rank == c.getCardRank() && this.suite == (c.getCardSuite())){
			return true;
		}
		else{
			return false;
		}
	}
	
		/**
		 * creates a string of the current cards rank and suite
		 * @return the string that it created about the card 
		 */
		public String toString(){
			String s = suite + " " + rank;
			return s; 
		}
		
		/**
		 * this compares whether 1 card with another 
		 * @return an int value 
		 * if the in t is -1 the first card is less than the second 
		 * if it returns 0 they are equal 
		 * if it returns 1 then the first card is greater than the second
		 * card
		 */
		public int compareTo(Card c) {
			
			String s1 = this.toString();
			String s2 = c.toString();
			
			int r = s1.compareTo(s2);
			return r;
		}
		
	

}
