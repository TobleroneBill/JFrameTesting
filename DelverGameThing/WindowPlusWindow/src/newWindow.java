import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.BorderFactory;

public class newWindow implements ActionListener {
	
	//frame
	JFrame frame = new JFrame("Stats");
	
	//buttons
	JButton quit = new JButton("REALLY QUIT");
	JButton cont = new JButton("Continue");
	
	//panels
	JPanel mainPanel = new JPanel();
	JPanel hudLeft = new JPanel();
	
	//labels
	JLabel stats = new JLabel();
	JLabel time = new JLabel();
	JLabel coolPic = new JLabel();
	
	//window constructor
	newWindow(){
		//window settings
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//lets you close program
		frame.setSize(500, 500);								//sets frame size to 500x500. gets packed so doesnt matter
		frame.setLocation(10, 300);								//sets loctaion to halfway down screen
		frame.setResizable(false);								//stops resizing
		frame.setVisible(true);									//sets frame to visible
			
		//left panel settings
		hudLeft.setBackground(new Color(72,61,139));	//sets left Panel Color
		
		//MainPanelSettings
		mainPanel.setBackground(new Color(42,32,102));	//sets window backGround Color
		mainPanel.setLayout(new BorderLayout());		//sets layout to be a border layout. (this might be df idk)
		mainPanel.setVisible(true);						//sets panel to be visible
		
		//continue Button settings
		cont.setBounds(30, 40, 100, 23);				//continue button size
		cont.setFocusable(false);						//stops it being able to be tabbed on
		cont.setBackground(new Color(0x68ee97));		//sets greenHexColor
		hudLeft.add(cont,BorderLayout.EAST);			//sets loctaion in border
		cont.addActionListener(this);					//adds actionlistener
		
		//quit button settings
		quit.setBounds(60, 40, 100, 23);				//quit button size
		quit.setFocusable(false);						//stops it being tabbed on
		quit.setBackground(new Color(0xcf5b5b));		//sets the red hexColor
		hudLeft.add(quit,BorderLayout.EAST);			//sets location in border
		quit.addActionListener(this);					//adds the actionlistener
		
		//stats
		stats.setText("Levels Delved: " + windowMaker.levelsDeep);					//shows user what level they on
		stats.setBorder(BorderFactory.createLineBorder(new Color(123,104,238), 5));	//adds a border
		stats.setVisible(true);														//sets the stats to visible
		stats.setForeground(new Color(106,90,205));									//sets text color
		stats.setFont(new Font("Impact", Font.BOLD,30));							//sets text styling
		
		
		
		//add panels to the frame.
		frame.add(mainPanel);								//adds main panel to frame
		mainPanel.add(stats,BorderLayout.CENTER);			//adds the stats label to the mainpanel
		hudLeft.setPreferredSize(new Dimension(150,150));	//sets preffered size of leftHud to 150
		mainPanel.add(hudLeft,BorderLayout.WEST);			//adds the left panel, using borderlayout settings
		frame.pack();										//packs it all so it looks nice
		stats.setPreferredSize(new Dimension(100,100));		//sets the size of the text to make the window fit
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==quit) {
			System.exit(0);					//if button pressed is quit, terminate the program
			
		} else if (e.getSource() == cont) {
			new launchPage();				//if continue is pressed, launch a new page and delete this window
			frame.dispose();
			
		}
		
	}
}
