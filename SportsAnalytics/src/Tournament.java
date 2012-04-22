
import java.awt.*;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tournament extends JApplet{
	public static final String PANEL1 = "Panel 1";
	public static final String PANEL2 = "Panel 2";
	private CardLayout cardlayout = new CardLayout();
	private JPanel mainPanel = new JPanel(cardlayout);
	private ImageIcon pic;
	private ImageIcon bgLeft; 
	private ImageIcon bgRight; 

	public void init(){ 
		resize(1400,850);
		createGUI();
	} 

	public void stop()  { 

	} 

	private void createGUI() {
		pic = new ImageIcon();
		bgLeft = new ImageIcon();
		bgRight = new ImageIcon();
		pic.setImage(getImage(getCodeBase(), "bgp.jpg"));
		bgLeft.setImage(getImage(getCodeBase(), "gt1.jpg"));
		bgRight.setImage(getImage(getCodeBase(), "gt2.jpg"));
		
		//file = new File();
		/*URL excel;
		try {
			excel = new URL(getCodeBase(), "SportsAnalyticsProjectStatsData");
			file = new File(excel.getFile()); //new File(getCodeBase(), "SportsAnalyticsProjectStatsData"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		
		BracketGUI b = new BracketGUI(mainPanel/*, file*/);
		StartScreen ss = new StartScreen(mainPanel, pic);//, background);
		
		JPanel test = new JPanel();
		test.setLayout(new BorderLayout());
		test.add(BorderLayout.CENTER, ss);
		JPanel westPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(this.getWidth()/2-pic.getIconWidth()/2 ,600));
		//System.out.println(this.getBounds());
		eastPanel.setPreferredSize(new Dimension(this.getWidth()/2-pic.getIconWidth()/2 ,600));
		//westPanel.setPreferredSize(new Dimension((this.getWidth())/2 - 440 ,600));
		//System.out.println("W= "+background.getIconWidth() + "\tH= " +background.getIconHeight());
		//eastPanel.setPreferredSize(new Dimension((this.getWidth())/2 - 440   ,600));
		//JLabel back1 = new JLabel(background);
		//JLabel back2 = new JLabel(background);
		//JLabel back4 = new JLabel(background);
		JLabel back3 = new JLabel(bgRight);
		JLabel back4 = new JLabel(bgLeft);
		
		//eastPanel.add(back1);
		eastPanel.add(back4);
		westPanel.add(back3);
		//westPanel.add(back4);
		
		System.out.println(eastPanel.getBounds());
		eastPanel.setBackground(Color.BLACK);
		westPanel.setBackground(Color.BLACK);
		
		
		test.add(BorderLayout.EAST,eastPanel);
		test.add(BorderLayout.WEST,westPanel);
		
		
		//main.setLayout(new BorderLayout(2000,2000));
		//getContentPane().add(main);
		//mainScreen.add(BorderLayout.CENTER, ss);
		//mainScreen.add(BorderLayout.WEST, new JPanel());
		
		
		mainPanel.add(test, PANEL1);
		mainPanel.add(b, PANEL2);
		//main.add(BorderLayout.CENTER, mainPanel);
		getContentPane().add(mainPanel);
		
		this.setPreferredSize(new Dimension(2000,2000));
		//setBackground(Color.ORANGE);
		//setForeground(Color.BLUE);
		this.setMaximumSize(getPreferredSize()); // prevent growth
		this.setMinimumSize(getPreferredSize()); // prevent shrink
	
	}

}


