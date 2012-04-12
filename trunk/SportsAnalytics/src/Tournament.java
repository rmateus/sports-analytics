
import java.applet.*; 
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.JApplet;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tournament extends JApplet{
	public static final String PANEL1 = "Panel 1";
	public static final String PANEL2 = "Panel 2";
	private CardLayout cardlayout = new CardLayout();
	private JPanel mainPanel = new JPanel(cardlayout);



	public void init(){ 
		resize(2000, 2000);
		createGUI();
	} 

	public void stop()  { 

	} 

	private void createGUI() {
		BracketGUI b = new BracketGUI(mainPanel);
		StartScreen ss = new StartScreen(mainPanel);
		mainPanel.add(ss, PANEL1);
		mainPanel.add(b, PANEL2);
		getContentPane().add(mainPanel);
	
	}

}


