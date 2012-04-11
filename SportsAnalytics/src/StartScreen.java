import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;


/*
 * This GUI class will handle the sliders that set the weight of each stat. Each stat weight
 * is a private static variable found in Team. After simulate is press, each slider is read 
 * and saved as the variable in Global, as is the year
 * 
 * PLEASE NOTE THAT LABEL VARIABLE NAMES ARE INACCURATE, but they work. Slider viariables are named correctly
 * 
 * This is still a work in progress. For any questions, contact me on facebook
 * @author Stephen Csukas
 */

public class StartScreen extends JFrame {

	private JPanel panel;
	private final ButtonGroup year = new ButtonGroup();
	private final JSlider seed;
	private final JSlider pointsPerGame;
	private final JSlider turnovers;
	private final JSlider defensiveRebounds;
	private final JSlider offensiveRebounds;
	private final JSlider winPercentage;
	private final JSlider threePointPercentage;
	private final JSlider FGPercentage;
	private final JSlider steals;
	private final JSlider blocks;
	
	private final JRadioButton year2011, year2012, year2010;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen frame = new StartScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartScreen() {
		//setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		getClass().getResource("src/bgp.jpg");
		JLabel logo = new JLabel(new ImageIcon("src/bgp.jpg"));
		//JLabel logo = new JLabel(new ImageIcon("C:\\Users\\Stephen\\Documents\\_School\\SA\\bgp.jpg"));
		logo.setBounds(0, 0, 440, 185);
		panel.add(logo);
		
		//create Simulate button and event handler
		JButton btnSimulate = new JButton("Simulate");
		btnSimulate.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSimulate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//if 2010 is selected, display error
				if(year2010.isSelected()){
					JOptionPane.showMessageDialog(null,"Sorry, this year is currently unavailable. Please select a different year.");
				}
				else{
					//else, set correct year
					if(year2011.isSelected()){
						Global.season = 2011;
					}
					else{//2012
						Global.season = 2012;
					}
					
					//set the weights (as a percentage, number will be between 0 and 1)
					Global.seedWeight = seed.getValue()/100.0;
					Global.winPercentageWeight = winPercentage.getValue()/100.0;
					
					Global.ppgWeight = pointsPerGame.getValue()/100.0;
				    Global.turnoversWeight = turnovers.getValue()/100.0;
					
					Global.fieldGoalPercentageWeight = FGPercentage.getValue()/100.0;
					Global.threePointsPercentageWeight = threePointPercentage.getValue()/100.0;
					
					Global.offensiveRebsWeight = offensiveRebounds.getValue()/100.0;
					Global.defensiveRebsWeight = defensiveRebounds.getValue()/100.0;
					
					Global.seedWeight = steals.getValue()/100.0;
					Global.blocksWeight = blocks.getValue()/100.0;
				}
			}
		});
		btnSimulate.setBounds(256, 501, 151, 43);
		panel.add(btnSimulate);	
		
		//create radio buttons for selecting the year
		year2011 = new JRadioButton("2011");
		year.add(year2011);
		year2011.setFont(new Font("Tahoma", Font.PLAIN, 18));
		year2011.setBounds(88, 521, 65, 23);
		panel.add(year2011);
		
		year2012 = new JRadioButton("2012");
		year2012.setSelected(true);
		year.add(year2012);
		year2012.setFont(new Font("Tahoma", Font.PLAIN, 18));
		year2012.setBounds(155, 521, 65, 23);
		panel.add(year2012);
		
		year2010 = new JRadioButton("2010");
		year.add(year2010);
		year2010.setFont(new Font("Tahoma", Font.PLAIN, 18));
		year2010.setBounds(20, 521, 65, 23);
		panel.add(year2010);
		
		//create all labels
		JLabel seedSliderLabel = new JLabel("3 Point Percentage");
		seedSliderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		seedSliderLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		seedSliderLabel.setBounds(10, 340, 200, 23);
		panel.add(seedSliderLabel);
		
		JLabel Seedlbl = new JLabel("Seed");
		Seedlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Seedlbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Seedlbl.setBounds(20, 251, 181, 23);
		panel.add(Seedlbl);
		
		JLabel threePointsPerGameSliderLabel = new JLabel("Points Per Game");
		threePointsPerGameSliderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		threePointsPerGameSliderLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		threePointsPerGameSliderLabel.setBounds(10, 296, 200, 23);
		panel.add(threePointsPerGameSliderLabel);
		
		JLabel lblSelectYear = new JLabel("Select Year");
		lblSelectYear.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSelectYear.setBounds(70, 496, 111, 23);
		panel.add(lblSelectYear);
		
		JLabel lblSelectStatWeights = new JLabel("Select Stat Weights");
		lblSelectStatWeights.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectStatWeights.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelectStatWeights.setBounds(0, 211, 440, 23);
		panel.add(lblSelectStatWeights);
	
		JLabel lblOffensiveRebounds = new JLabel("Offensive Rebounds");
		lblOffensiveRebounds.setHorizontalAlignment(SwingConstants.CENTER);
		lblOffensiveRebounds.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOffensiveRebounds.setBounds(10, 387, 200, 23);
		panel.add(lblOffensiveRebounds);
		
		JLabel lblTurnovers = new JLabel("Turnovers");
		lblTurnovers.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurnovers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTurnovers.setBounds(220, 296, 204, 23);
		panel.add(lblTurnovers);
		
		JLabel lblFgPercentage = new JLabel("FG Percentage");
		lblFgPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblFgPercentage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFgPercentage.setBounds(220, 340, 204, 23);
		panel.add(lblFgPercentage);
		
		JLabel lblWinRebounds = new JLabel("Defensive Rebounds");
		lblWinRebounds.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinRebounds.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWinRebounds.setBounds(224, 387, 200, 23);
		panel.add(lblWinRebounds);
		
		JLabel lblSteals = new JLabel("Steals");
		lblSteals.setHorizontalAlignment(SwingConstants.CENTER);
		lblSteals.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSteals.setBounds(224, 432, 200, 23);
		panel.add(lblSteals);
		
		JLabel lblBlocks = new JLabel("Blocks");
		lblBlocks.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlocks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBlocks.setBounds(42, 432, 131, 23);
		panel.add(lblBlocks);
		
		JLabel lblWinPercentage = new JLabel("Win Percentage");
		lblWinPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinPercentage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWinPercentage.setBounds(224, 251, 200, 23);
		panel.add(lblWinPercentage);
		
		//Created the 10 sliders, each will adjust the weight of the respective stat
		pointsPerGame = new JSlider();
		pointsPerGame.setSnapToTicks(true);
		pointsPerGame.setPaintTicks(true);
		pointsPerGame.setPaintLabels(true);
		pointsPerGame.setName("Seed");
		pointsPerGame.setMinorTickSpacing(10);
		pointsPerGame.setBounds(10, 319, 200, 23);
		panel.add(pointsPerGame);
		
		threePointPercentage = new JSlider();
		threePointPercentage.setSnapToTicks(true);
		threePointPercentage.setPaintTicks(true);
		threePointPercentage.setPaintLabels(true);
		threePointPercentage.setName("Seed");
		threePointPercentage.setMinorTickSpacing(10);
		threePointPercentage.setBounds(10, 363, 200, 23);
		panel.add(threePointPercentage);
		
		seed = new JSlider();
		seed.setSnapToTicks(true);
		seed.setPaintTicks(true);
		seed.setPaintLabels(true);
		seed.setName("Seed");
		seed.setMinorTickSpacing(10);
		seed.setBounds(10, 274, 200, 23);
		panel.add(seed);
		
		offensiveRebounds = new JSlider();
		offensiveRebounds.setSnapToTicks(true);
		offensiveRebounds.setPaintTicks(true);
		offensiveRebounds.setPaintLabels(true);
		offensiveRebounds.setName("Seed");
		offensiveRebounds.setMinorTickSpacing(10);
		offensiveRebounds.setBounds(10, 410, 200, 23);
		panel.add(offensiveRebounds);
		
		winPercentage = new JSlider();
		winPercentage.setSnapToTicks(true);
		winPercentage.setPaintTicks(true);
		winPercentage.setPaintLabels(true);
		winPercentage.setName("Seed");
		winPercentage.setMinorTickSpacing(10);
		winPercentage.setBounds(224, 274, 200, 23);
		panel.add(winPercentage);
		
		FGPercentage = new JSlider();
		FGPercentage.setSnapToTicks(true);
		FGPercentage.setPaintTicks(true);
		FGPercentage.setPaintLabels(true);
		FGPercentage.setName("Seed");
		FGPercentage.setMinorTickSpacing(10);
		FGPercentage.setBounds(220, 363, 200, 23);
		panel.add(FGPercentage);
		
		turnovers = new JSlider();
		turnovers.setSnapToTicks(true);
		turnovers.setPaintTicks(true);
		turnovers.setPaintLabels(true);
		turnovers.setName("Seed");
		turnovers.setMinorTickSpacing(10);
		turnovers.setBounds(224, 319, 200, 23);
		panel.add(turnovers);
		
		defensiveRebounds = new JSlider();
		defensiveRebounds.setSnapToTicks(true);
		defensiveRebounds.setPaintTicks(true);
		defensiveRebounds.setPaintLabels(true);
		defensiveRebounds.setName("Seed");
		defensiveRebounds.setMinorTickSpacing(10);
		defensiveRebounds.setBounds(224, 410, 200, 23);
		panel.add(defensiveRebounds);
		
		blocks = new JSlider();
		blocks.setSnapToTicks(true);
		blocks.setPaintTicks(true);
		blocks.setPaintLabels(true);
		blocks.setName("Seed");
		blocks.setMinorTickSpacing(10);
		blocks.setBounds(10, 455, 200, 23);
		panel.add(blocks);
		
		steals = new JSlider();
		steals.setSnapToTicks(true);
		steals.setPaintTicks(true);
		steals.setPaintLabels(true);
		steals.setName("Seed");
		steals.setMinorTickSpacing(10);
		steals.setBounds(224, 455, 200, 23);
		panel.add(steals);
		
		JButton help = new JButton("Help");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Adjust each slider based on how important you think each stat is to \n" +
						                           "a team's success, the left side of the slider meaning not important\n" +
						                           "and the right side meaning extremely important. Then, simply select\n" +
						                           "the season you want to simulate and click the Simulation button.");
			
			}
		});
		help.setFont(new Font("Tahoma", Font.PLAIN, 12));
		help.setBounds(0, 185, 67, 23);
		panel.add(help);
		
		JButton about = new JButton("About");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Created by Stephen Csukas, Derek Miller, Jeff Pansisi,o\n" +
												   " Brandon Palmer, and Caleb Kirksey. [will add more to this]");

			}
		});
		about.setHorizontalAlignment(SwingConstants.LEFT);
		about.setFont(new Font("Tahoma", Font.PLAIN, 12));
		about.setBounds(360, 185, 74, 23);
		panel.add(about);
	}
}