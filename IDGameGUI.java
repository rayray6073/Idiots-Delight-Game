
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author Rachel Celestine 
 * December 16,2014 
 *	Final Project 
 */

import java.awt.*;
import java.awt.event.*;


public class IDGameGUI {
	
	//size of the frame
	private static final int WIDTH = 600;
	private static final int HEIGHT = 700;
	
	//creating the frame 
	private JFrame frame; 
	
	//Create the ID game panel
	private DelightsPanel delightPanel;
	//creating a JPanel
	private JPanel primary;
	//creating buttons 
	private JButton reset;
	//creating a container 
	private JPanel container;
	//creating the help button; 
	private JButton help;
	private int counter;
	
	/**
	 * this constructor initializes the buttons and add actions to them 
	 * it creates the frame and container in which the game is going to be played 
	 * 
	 */
	public IDGameGUI() {
		this.counter = 0;
		this.frame = new JFrame("Idiot's Delight Game");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.delightPanel = new DelightsPanel();
		
		this.reset = new JButton("New Game");
		this.reset.addActionListener(new ResetButtonListener());
		
		this.help = new JButton("Help");
		
		help.addActionListener(new HelpButtonListener());
		
		this.container = new JPanel();
		this.container.add(this.delightPanel);
		this.container.add(this.reset);
		this.container.add(this.help);
		
		this.frame.getContentPane().add(this.container);
		
		this.frame.pack();
		this.frame.setVisible(true);
		
	}
	/**
	 * this inner class resets the game when an action is performed 
	 * it calls the reset method and then repaints the board 
	 */
	private class ResetButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			delightPanel.reset();
			delightPanel.repaint();
		}
	}
	
	/**
	 * this is the other inner class that offers help when the 
	 * player needs help 
	 *it calls 
	 */
	private class HelpButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (counter%2 == 0){
				delightPanel.check();
				counter++;
			}else if (counter%2 == 1){
				delightPanel.check2();
				counter++;
			}
			
		}
	}
	

	public static void main(String[] args) {
		IDGameGUI gui = new IDGameGUI();
	}

}

