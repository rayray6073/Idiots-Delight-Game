import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * @author Rachel C 
 * December 16,2014 
 *	Final Project 
 */

public class CardsStack{
	/**this is a represents a pile that can hold cards**/
	private Stack<Card> cards;
	/**this represents the x and y location of the cards**/
	private int x,y;
	/**this represents the cards image**/
	private ImageIcon image;
	/**this represents the cards height**/
	public int CARDHEIGHT;
	/**this represents the cards width**/
	public int CARDWIDTH;
	/**this creates the back of the cards image**/
	private ImageIcon back = new ImageIcon("back.png");


	/**
	 * this is a constructor that initializes the deck and sets the x and y values to those 
	 * of the inputed x and y values. It also sets the cards width and height to those of the 
	 * of the back card 
	 * @param x is the x location of the card 
	 * @param y is the y location of the card
	 */
	public CardsStack(int x, int y) {
		cards = new Stack<Card>();
		this.x = x;
		this.y=y;
		CARDHEIGHT = back.getIconHeight();
		CARDWIDTH = back.getIconWidth();
		
	}
	
	/**
	 * this method checks to see if the pile has been clicked or not
	 * @param mouseX is the x location of where the mouse has been clicked
	 * @param mouseY is the y location of where the mouse has been clicked 
	 * @return returns true of false based on the locations of the mouse 
	 */
	public Boolean clicked(int mouseX , int mouseY){
		Boolean ans = false; 
		if(mouseX>= x && mouseX<=x+CARDWIDTH && mouseY >=y && mouseY<= y+CARDHEIGHT){
			ans = true;
		}
		return ans;
	}
	
	/**
	 * this method creates a full deck of shuffled cards
	 * it creates a local deck and adds all the values to the 
	 * pile
	 */
	public void full(){
		Deck d = new Deck();
		d.fullDeck();
		ArrayList<Card> temp = d.returnArrayL();
		for (int i = 0; i < temp.size(); i++){
			Card c = temp.get(i);
			cards.push(c);
		}
		
		}

	
	/**
	 * this method adds a card to the top of the pile 
	 * @param c is the card object that is being added
	 */
	public void add(Card c){
		cards.push(c);
		
	}
	
	/**
	 * removes a card from the top of a pile 
	 * @return the card object that was removed
	 */
	public Card remove(){
		Card c = cards.pop();
		return c;
	}

	/**
	 * this method draws the top card of the pile 
	 * @param c is where the drawing is going to be at 
	 * @param g is the image that is being drawn
	 */
	public void draw(Component c, Graphics g){
		Boolean ans = cards.isEmpty();
		if(ans == false){
			cards.peek().draw(c, g, this.x, this.y);
		}
	}
	
	/**
	 * this method specific draws the back of the deck 
	 * @param c is where the drawing is going to be at 
	 * @param g is the image that is being drawn 
	 */
	public void drawBack(Component c, Graphics g){
		this.back.paintIcon(c, g, this.x, this.y);
	}
	
	/**
	 * allows you to see the top card of the deck without having 
	 * to remove it
	 * @return the card object
	 */
	public Card peek(){
		Card c = cards.peek();
		return c;
	}
	
	/**
	 * gets the x value of the pile 
	 * @return an int 
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * gets the y value of the pile 
	 * @return an int 
	 */
	public int getY(){
		return this.y;
	}
	
	/**
	 * checks to see if the pile is empty or not 
	 * @return a boolean based on if the pile is empty
	 */
	public Boolean isEmpty(){
		Boolean ans = cards.isEmpty();
		return ans;
	}
	
	/**
	 * this method clears the piles by removing all cards 
	 * from the deck if they have any 
	 */
	public void clear(){
		cards.clear();
	}
	
}
