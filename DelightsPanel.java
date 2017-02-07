import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * this class is the class that creates the game and implements the rules 
 * @author Rachel C
 
 *	Final Project 
 */
public class DelightsPanel extends JPanel{
	
	/**these are the height and width of the screen for the game **/ 
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	
	/** these are the x and y values of the panel */
	private int x,y;

	/**these are the 5 different piles that are used in the game**/
	private CardsStack stock,tab1,tab2,tab3,tab4;

	/**
	 * this constructor initializes  all the piles adds the mouse listener to the panel, and sets the 
	 * preferred size and background 
	 */
	public DelightsPanel() {
		this.x = 0; 
		this.y =0;
		this.setPreferredSize(new Dimension(this.WIDTH,this.HEIGHT));
		this.setBackground(Color.WHITE);

		stock = new CardsStack(200,300);
		stock.full();

		tab1 = new CardsStack(10,50);
		tab2= new CardsStack(135,50);
		tab3= new CardsStack(260,50);
		tab4= new CardsStack(385,50);

		

		this.addMouseListener(new MousePanelListener());

	}

	/**
	 * this methods deals gives a single card to the four piles from the deck 
	 * and removes those 4 cards from the deck 
	 */
	public void deal(){
		Boolean ans = stock.isEmpty();
		if(ans == false){
			Card c = stock.remove();
			tab1.add(c);
			Card d = stock.remove();
			tab2.add(d);
			Card a = stock.remove();
			tab3.add(a);
			Card b = stock.remove();
			tab4.add(b);		
		}

	}

		/**
		 * this method checks to see if all the piles are empty
		 * @return return true if all piles are empty else it returns false
		 */
	public Boolean allEmpty (){
		Boolean ans; 
		if (tab1.isEmpty() && tab2.isEmpty() && tab3.isEmpty() && tab4.isEmpty()){
			ans = true;
		}else{
			ans = false; 
		}
		return ans;
	}

	/**
	 * this methods paints all 5 piles onto the panel 
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		stock.drawBack(this, g);
		tab1.draw(this,g);
		tab2.draw(this,g);
		tab3.draw(this,g);
		tab4.draw(this,g);
	}

	/**
	 * this method removes all cards that have the same rank/ int value as the param
	 * @param c is the int value that is compared to all the cards to see if they are 
	 * the same and removed 
	 */
	public void sameRank(int c){

		if(!tab1.isEmpty() && c == tab1.peek().getCardRank()){
			tab1.remove();
		}
		if(!tab2.isEmpty() && c == tab2.peek().getCardRank()){
			tab2.remove();
		}
		if(!tab3.isEmpty() &&  c == tab3.peek().getCardRank()){
			tab3.remove();
		}
		if(!tab4.isEmpty() && c == tab4.peek().getCardRank()){
			tab4.remove();
		}
	}

	/**
	 * this method checks to see if there are 2 or more cards that have the same int value 
	 * @param c is the value that is being compared
	 * @return boolean based on if there are 2 more cards with the same value 
	 */
	public boolean same(int c){
		int x = 0;
		if(!tab1.isEmpty() && c == tab1.peek().getCardRank()){
			x = x +1;
		}
		if(!tab2.isEmpty() && c == tab2.peek().getCardRank()){
			x = x+1;
		}
		if( !tab3.isEmpty() && c == tab3.peek().getCardRank()){
			x = x+1;
		}
		if(!tab4.isEmpty() && c == tab4.peek().getCardRank()){
			x = x+1;
		}

		if(x>=2){
			return true;
		}else{
			return false;
		}

	}
	
	/**
	 * this method removes the card from a specific pile based on the input value 
	 */
	public void remove(int rank){
		if(rank == 1){
			tab1.remove();
		}
		if(rank == 2){
			tab2.remove();
		}
		if(rank == 3){
			tab3.remove();
		}
		if(rank == 4){
			tab4.remove();
		}

	}
	
	/**
	 * this method checks to see if there are any higher values among the piles 
	 * @return a boolean based on this decision 
	 */
	public boolean allHigherSuite(){
		
		Boolean ans = false;
		if (tab1.isEmpty() == false){
			if (higherSuite(tab1.peek()) == true){
				ans = true;
		}
		}
		if(tab2.isEmpty() == false){
			if (higherSuite(tab2.peek()) == true){
				ans = true;
			}
		}
		if(tab3.isEmpty() == false){
			if (higherSuite(tab3.peek()) == true){
				ans = true;
		}
		}
		if(tab4.isEmpty() == false){
			if (higherSuite(tab4.peek()) == true){
				ans = true;
		}
		}
		return ans; 
		
		
	}
	
	/**
	 * checks to see if there are any cards on all the piles that might have another 
	 * card with the same rank
	 * @return true if so, and false if not 
	 */
	public boolean allSame(){
		Boolean ans = false;
		if (!tab1.isEmpty()){
			if(same(tab1.peek().getCardRank()) == true){
			ans = true;
		}
		}
		else if(!tab2.isEmpty()){
			if(same(tab2.peek().getCardRank()) == true){
				ans =true;
			}
		}
		else if(!tab3.isEmpty()){
		    if(same(tab3.peek().getCardRank()) == true){
			ans = true; 
		}
		}
		else if(!tab4.isEmpty()){
			if(same(tab4.peek().getCardRank()) == true){
		
			ans = true;
			}
		}
		return ans; 
	}

	
	/**
	 * checks to see if there something else the player can do before dealing and offers help
	 * @return true and prints out that there is something that the player still needs to do 
	 */
	public boolean check2(){
		boolean ans = true;
		if(allHigherSuite() == false && allSame() == false){
			ans = false;
		}
		System.out.println("There is something that needs to be done. ");
		return ans;
	}
	
	/**
	 * checks to see if there something else the player can do before dealing and doesn't offers help
	 * @return true if there is and returns false if there is causing the deck to deal again
	 */
	public boolean check(){
		boolean ans = true;
		if(allHigherSuite() == false && allSame() == false){
			ans = false;
		}
		return ans;
	}

	/**
	 * checks to see if there is a card with the same suit and a higher rank than the inputed card 
	 * @param c is the card that we are compare other ranks with 
	 * @return true if there is and false if there isn't 
	 */
	public boolean higherSuite(Card c){
		int r = c.getCardRank();
		int s = c.getCardSuite();
		boolean ans = false;
		if(!tab1.isEmpty()){
			if(c.equals(tab1.peek()) == false && c.getCardSuite() == tab1.peek().getCardSuite()){
				if(c.getCardRank() < tab1.peek().getCardRank()){
					return true; 
				}
			}
		}
		if(!tab2.isEmpty()){ 
			if(c.equals(tab2.peek()) == false && c.getCardSuite() == tab2.peek().getCardSuite()){
				if(c.getCardRank() < tab2.peek().getCardRank()){
					return true;
			}
		}
		}
		if(!tab3.isEmpty()){ 
			if (c.equals(tab3.peek()) == false && c.getCardSuite() == tab3.peek().getCardSuite()){
				if(c.getCardRank() < tab3.peek().getCardRank()){
					return true;
				}
			}
		}
		if(!tab4.isEmpty()){
			if (c.equals(tab4.peek()) == false && c.getCardSuite() == tab4.peek().getCardSuite()){
			if(c.getCardRank() < tab4.peek().getCardRank()){
				return true;
			}
			}
		}
		return false; 
	}

	
	
	/**
	 * this method clears all the piles and creates a full new deck for the stock
	 */
	public void reset(){
		this.stock.clear();
		this.stock.full();
		this.tab1.clear();
		this.tab2.clear();
		this.tab3.clear();
		this.tab4.clear();
	}


	/**
	 * this method checks to see if there are any same rank cards as the top card of a pile 
	 * and if not it checks to see if there is a higher rank. If there is none then it does 
	 * nothing
	 * @param c is a pile
	 */
	public void removeCard(CardsStack c){
		int s = c.peek().getCardRank();
		if(same(s) == true){
			sameRank(s);
		}else if(higherSuite(c.peek()) == true){
			c.remove();
		}
	}
	
	
	/**
	 * an inner class properly implements the methods above so that the game works 
	 * correctly 
	 * @author Rachel Celestine
	 * Final Project 
	 */
	public class MousePanelListener extends MouseAdapter{
		/**
		 * this method checks to make sure you haven't won or lost the game and then performs
		 * an action based on where you clicked 
		 */
		public void mouseClicked(MouseEvent e){
			int mouseX = e.getX();
			int mouseY = e.getY();

			if(stock.isEmpty()){
				if(allEmpty() ==true){
					System.out.println("You won the game!!!!");
				}else if(check() == false && allEmpty() == false){
					System.out.println("You Lose the Game");
				}else if(check() == true && allEmpty() == false ){
					pressed(mouseX, mouseY);
				}
			}else if(!stock.isEmpty()){
					pressed(mouseX, mouseY);

				}
					
			}
			
			
		/**
		 * this method determines what pile has been selected and what actions to perform
		 * base on that selection
		 * @param x is the location that the mouse clicked 
		 * @param y is the y location that the mouse clicked 
		 */
		private void pressed(int x, int y){
			if(stock.clicked(x, y) == true){
				if(check() == true){
					//System.out.println("There is still something you can do.");
				}else if(check() == false){
				
				deal();
				repaint();
					}}
				else if(!tab1.isEmpty() &&tab1.clicked(x, y) == true){
				removeCard(tab1);
				repaint();

			}else if(!tab2.isEmpty() && tab2.clicked(x, y) == true){
				removeCard(tab2);
				repaint();

			}else if(!tab3.isEmpty() && tab3.clicked(x, y) == true){
				removeCard(tab3);
				repaint();

			}else if(!tab4.isEmpty() && tab4.clicked(x, y) == true){
				removeCard(tab4);
				repaint();


			}
			}
		}
	}
			

		
		

	



