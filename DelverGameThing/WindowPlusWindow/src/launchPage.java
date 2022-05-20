import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class launchPage implements ActionListener{

	//frame
	JFrame frame  = new JFrame("Window " + windowMaker.levelsDeep);
	//text displaying what level you are on
	JLabel ldText = new JLabel("Levels Deep: " + windowMaker.levelsDeep);
	//Panels
	JPanel bPanel = new JPanel();
	JPanel hudPanel = new JPanel();
	//buttons
	JButton button = new JButton("Delve");		//delve a level button
	JButton quitsies = new JButton("Quit");		//quit button
		
	
	
	launchPage(){

		Random rand = new Random(); //creates a new random object, to take random integers from
		int xBound = rand.nextInt(400);				//random integer in a range from 0-400
		int yBound = rand.nextInt(400);
		int wXBound = (500 + rand.nextInt(500));	//random integer from 0-500, + 500 for the window size to be
		int wYBound = (500 + rand.nextInt(500));	//randomised
		System.out.println(xBound);					//print values for debugging
		System.out.println(yBound);
		
		
		
		ldText.setBounds(10, 10, 100, 20);			//ldText settings
		ldText.setVisible(true);
		
		button.addActionListener(this);				//button settings
		button.setBounds(xBound, yBound, 100, 30);	//using random values to place the button
		button.setFocusable(false);					//cant be tabbed
		
		quitsies.setBounds(10, 30, 100, 20);		//quit button settings
		quitsies.setFocusable(false);				//cant be tabbed
		quitsies.addActionListener(this);			//adds action Listener
		
		//frame settings
		frame.setForeground(Color.BLACK);			//setting colors which get covered up so kinda useless
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	//frame close option
		frame.setLayout(new BorderLayout());		//setting to borderLayout
		frame.setSize(wXBound, wYBound);			//setting size to be random (but more than 500x500)
		frame.setResizable(false);					//unresizeable
		frame.setLocationRelativeTo(null);			//sets to middle of screen
		frame.setVisible(true);						//sets visible
		
		hudPanel.setBounds(300, 300, 100, 100);		//sets bounds of hud panel (think this gets resized from layout
		
		bPanel.setBackground(Color.BLACK);			//panel bg is black
		bPanel.setLayout(null);						//no layoutManager
		bPanel.setVisible(true);					//is visible
		frame.add(hudPanel,BorderLayout.NORTH);		//adds hud panel to top of screen
		frame.add(bPanel,BorderLayout.CENTER);		//adds main panel with the random button to center screen

		
		
		bPanel.add(button);							//adds the randomly placed button
		
		
		hudPanel.add(quitsies);						//adds the quit button to the hud
		hudPanel.add(ldText);						//adds the text to the hud

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
			frame.dispose();					//if delve button is pressed, destroy this window, add 1 to
			windowMaker.levelsDeep +=1;			//global levels deep variable and create a new randomised
			new launchPage();					//window
		}else if(e.getSource()== quitsies) {
			frame.dispose();					//if player presses quit, destroy window and open the quit screen
			new newWindow();
			
		}
	}
}
