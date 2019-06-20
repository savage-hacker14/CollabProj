import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GUI functionality for the collab project. 
 * @author arjun
 * Date: 6/20/19
 */
public class guiMain {

	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("Welcome");	//creates a JFrame that occupies the whole screen
		mainFrame.setSize(1920, 1080);
		mainFrame.setLocation(0, 0);	//centered 
		
		JButton playButton = new JButton("PLAY");	//creates the play button. 
		playButton.setBounds(0, 0, 200, 300);
		
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playAction.start();	//calls the action class for playButton and starts a new JFrame
			}
		});
		
		JButton exitButton = new JButton("EXIT");
		exitButton.setBounds(0, -300, 200, 300);
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); //exits out of the mainFrame. 
			}
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 0, 600, 800);
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(playButton);
		buttonPanel.add(exitButton);
		
		mainFrame.add(buttonPanel);
		mainFrame.setVisible(true);
	}

}
