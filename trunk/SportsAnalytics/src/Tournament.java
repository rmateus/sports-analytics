
import java.awt.*;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tournament extends JApplet{
	public static final String PANEL1 = "Panel 1";
	public static final String PANEL2 = "Panel 2";
	private CardLayout cardlayout = new CardLayout();
	private JPanel mainPanel = new JPanel(cardlayout);
	private ImageIcon pic;
	private Image background; 
	private File file;

	public void init(){ 
		resize(2000, 2000);
		createGUI();
	} 

	public void stop()  { 

	} 

	private void createGUI() {
		pic = new ImageIcon();
		pic.setImage(getImage(getCodeBase(), "bgp.jpg"));
		background = getImage(getCodeBase(), "bgp.jpg");
		
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
		StartScreen ss = new StartScreen(mainPanel, pic, background);
		
		JPanel test = new JPanel();
		test.setLayout(new BorderLayout());
		test.add(BorderLayout.CENTER, ss);
		JPanel westPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension((this.getWidth())/2 - 539 ,600));
		//System.out.println(this.getBounds());
		eastPanel.setPreferredSize(new Dimension((this.getWidth())/2 - 539,600));
		//westPanel.setPreferredSize(new Dimension((this.getWidth())/2 - 440 ,600));
		//System.out.println(this.getBounds());
		//eastPanel.setPreferredSize(new Dimension((this.getWidth())/2 - 440   ,600));
		eastPanel.setBackground(Color.ORANGE);
		westPanel.setBackground(Color.ORANGE);
		
		
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
		setBackground(Color.ORANGE);
		setForeground(Color.BLUE);
		this.setMaximumSize(getPreferredSize()); // prevent growth
		this.setMinimumSize(getPreferredSize()); // prevent shrink
	
	}

}


