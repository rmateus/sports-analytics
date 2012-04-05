import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/*
 * This GUI class will handle the sliders that set the weight of each stat. Each stat weight
 * is a private static variable found in Team. After simulate is press, eachs slider is read 
 * and saved as the variable in Team
 * 
 * This is still a work in progress. For any questions, contact me on facebook
 */

public class StartScreen extends JFrame {

	private JPanel panel;

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
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 432);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		final JSlider seedSlider = new JSlider();
		seedSlider.setSnapToTicks(true);
		seedSlider.setPaintTicks(true);
		seedSlider.setMinorTickSpacing(10);
		seedSlider.setName("Seed");
		seedSlider.setPaintLabels(true);
		seedSlider.setBounds(10, 161, 200, 23);
		panel.add(seedSlider);
		
		final JSlider reboundsSlider = new JSlider();
		reboundsSlider.setSnapToTicks(true);
		reboundsSlider.setPaintTicks(true);
		reboundsSlider.setPaintLabels(true);
		reboundsSlider.setName("Seed");
		reboundsSlider.setMinorTickSpacing(10);
		reboundsSlider.setBounds(10, 228, 200, 23);
		panel.add(reboundsSlider);
		
		final JSlider winPercentageSlider = new JSlider();
		winPercentageSlider.setSnapToTicks(true);
		winPercentageSlider.setPaintTicks(true);
		winPercentageSlider.setPaintLabels(true);
		winPercentageSlider.setName("Seed");
		winPercentageSlider.setMinorTickSpacing(10);
		winPercentageSlider.setBounds(220, 161, 200, 23);
		panel.add(winPercentageSlider);
		
		final JSlider threePointsPerGameSlider = new JSlider();
		threePointsPerGameSlider.setSnapToTicks(true);
		threePointsPerGameSlider.setPaintTicks(true);
		threePointsPerGameSlider.setPaintLabels(true);
		threePointsPerGameSlider.setName("Seed");
		threePointsPerGameSlider.setMinorTickSpacing(10);
		threePointsPerGameSlider.setBounds(220, 228, 200, 23);
		panel.add(threePointsPerGameSlider);
		
		JLabel winPercentageSliderLabel = new JLabel("Win Percentage");
		winPercentageSliderLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		winPercentageSliderLabel.setBounds(262, 127, 122, 23);
		panel.add(winPercentageSliderLabel);
		
		JLabel seedSliderLabel = new JLabel("Seed");
		seedSliderLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		seedSliderLabel.setBounds(92, 127, 62, 23);
		panel.add(seedSliderLabel);
		
		JLabel reboundsSliderLabel = new JLabel("Rebounds");
		reboundsSliderLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reboundsSliderLabel.setBounds(71, 194, 93, 23);
		panel.add(reboundsSliderLabel);
		
		JLabel threePointsPerGameSliderLabel = new JLabel("3 Point FGs Per Game");
		threePointsPerGameSliderLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		threePointsPerGameSliderLabel.setBounds(230, 194, 190, 23);
		panel.add(threePointsPerGameSliderLabel);
		
		JButton btnSimulate = new JButton("Simulate");
		btnSimulate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Team.winPercentgeWeight = winPercentageSlider.getValue()/100.0;
				Team.seedWeight = seedSlider.getValue()/100.0;
				Team.reboundsWeight = reboundsSlider.getValue()/100.0;
				Team.threePointsPerGameWeight = threePointsPerGameSlider.getValue()/100.0;
			}
		});
		btnSimulate.setBounds(170, 324, 89, 23);
		panel.add(btnSimulate);
	}
}
