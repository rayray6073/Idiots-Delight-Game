import java.util.ArrayList;
import java.util.Random;
/**
 * this is a class that creates a deck 
 * @author Rachel C 
 
 */

public class Deck {
	//this creates a random geerator object 
	Random gen = new Random();
	//an array of cards
	static Card [] deck;
	
	/**
	 * this constructor initializes the array and sets the size to 52
	 */
	public Deck() {
		deck = new Card[52];
	}
	
	/**
	 * this creates a full deck of cards and shuffles them by calling the swap method 
	 * and using the random generator
	 */
	public void fullDeck(){
		int z=0;
		while(z<52){
		for(int i = 14; i <18; i++){
			for(int j = 1; j<14;j++){
				Card b = new Card(i,j);
				deck[z] = b;
				z++;
			}
		}
		}
		shuflleDeck();
		
	}
	
	/**
	 * this creates and initializes and arrayList it then takes the value of the full sorted 
	 * deck and adds then to the arrayList. It then returns that arrayList 
	 * @return
	 */
	public ArrayList<Card> returnArrayL(){
		ArrayList<Card> myDeck = new ArrayList<Card>();
		for(int i=0; i < deck.length; i++){
			Card c = deck[i];
			myDeck.add(c);
		}
		return myDeck;
	}
	
	/**
	 * this is the shuffle method that 
	 * swap cards at 2 different locations 
	 */
	public void shuflleDeck(){

		for(int i = 0; i <deck.length; i++){
			int r = gen.nextInt(52);
			swap(i,r);
		}
	}
	
	/**
	 * this gets the card at a specified index 
	 * @param i is the specified index
	 * @return the card at the specified index
	 */
	public Card getCard(int i){
		Card temp = deck[i];
		return temp;
	}
	
	/**
	 * returns the length of the array 
	 * @return int value of the length
	 */
	public int getSize(){
		int s = deck.length;
		return s;
	}
	
	/**
	 * this method takes in 2 different index value and swap the cards at there location 
	 * with each other
	 * @param index the index of one of the cards being swapped 
	 * @param change the index of the other card being swapped 
	 */
	public static void swap(int index, int change){
		Card temp = deck[change];
		deck[change] = deck[index];
		deck[index] = temp;
	}




}
