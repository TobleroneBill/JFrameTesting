import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainWindow implements ActionListener{

	
	
	static JPanel examplePanel = new JPanel();
	static JPanel panel = new JPanel();
	int i = 0;
	//panel creation for CenterPanel
	static JPanel cP1 = new JPanel();
	static JPanel cP2 = new JPanel();
	static JPanel cP3 = new JPanel();
	static JPanel cP4 = new JPanel();
	static JPanel cP5 = new JPanel();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// make the frame
		JFrame frame = new JFrame("BorderLayout Testing");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		// sets frame layout to the border layout. this is the default, but I did it like this for
		// clarity
		frame.setLayout(new BorderLayout());
		
		// create the main panel for the frame
		
		panel.setLayout(new BorderLayout());
		
		// add the panel to the frame
		frame.add(panel);
		
		//create the button and add it to the panel
		JButton layoutChange = new JButton("Switch Borders");
		
		//
		//addActionListener needs a class to add the functionality to. MainWindow implements the actionlistener 
		//method, so this is valid.
		//
		//the reason you need to make a new one, is because it needs an object to add it to. (could create a variable
		//if this is being used more than once)
		//
		//you can only use .this, when in constructor method, because there it already knows what object 'this' is
		//the object doesnt need to be instanciated (created) because its doing it in the constructor.
		//
		
		//not my best explanation, but the best i can do rn
		layoutChange.addActionListener(new MainWindow());
		panel.add(layoutChange, BorderLayout.NORTH);
		
		//create a 2nd panel, to add to the original panel
		
		examplePanel.setBackground(Color.BLACK);
		examplePanel.setLayout(new BorderLayout());
		panel.add(examplePanel,BorderLayout.CENTER);
		

		
		
		// sets panel colors from: https://www.color-hex.com/color-palette/1008908
		cP1.setBackground(new Color(221,204,255));
		cP2.setBackground(new Color(218,255,236));
		cP3.setBackground(new Color(255,242,205));
		cP4.setBackground(new Color(224,240,255));
		cP5.setBackground(new Color(251,206,206));
		
		//sets example panel sizes
		cP1.setPreferredSize(new Dimension(100,100));
		cP2.setPreferredSize(new Dimension(100,100));
		cP3.setPreferredSize(new Dimension(100,100));
		cP4.setPreferredSize(new Dimension(100,100));
		cP5.setPreferredSize(new Dimension(100,100));
		
		//adds example panels to THE example panel
		examplePanel.add(cP1,BorderLayout.NORTH);
		examplePanel.add(cP2,BorderLayout.SOUTH);
		examplePanel.add(cP3,BorderLayout.EAST);
		examplePanel.add(cP4,BorderLayout.WEST);
		examplePanel.add(cP5,BorderLayout.CENTER);
		
		
		//show frame
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("lol");
		
		layoutChange();
		panel.revalidate();
		
	}

	public void layoutChange() {
		int[] layout = {0,1,2};
		
		panel.revalidate();
		if (layout[i] == 0) {
			examplePanel.setLayout(new FlowLayout());
			panel.revalidate();
			i++;
			System.out.println(i);
		} else if(layout[i] == 1)  {
			examplePanel.setLayout(new GridLayout());
			panel.revalidate();
			i++;
			System.out.println(i);
		} else if (layout[i] == 2) {
			examplePanel.setLayout(new BorderLayout());
			panel.revalidate();
			
			//need to reset the locations of each subPanel, so I ReAdd them. I'm sure theres a better solution
			//but this works lol
			
			examplePanel.add(cP1,BorderLayout.NORTH);
			examplePanel.add(cP2,BorderLayout.SOUTH);
			examplePanel.add(cP3,BorderLayout.EAST);
			examplePanel.add(cP4,BorderLayout.WEST);
			examplePanel.add(cP5,BorderLayout.CENTER);
			i=0;
			System.out.println(i);
		}
		
		
	}
	
}
