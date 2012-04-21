import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
 



@SuppressWarnings("serial")
public class BracketGUI extends JPanel{

	private Team[] teamArray;
	private JButton back;
	private final JPanel mainPanel;
	private File excelFile;

	public BracketGUI(JPanel mainPanel/*, File f*/){
		this.mainPanel = mainPanel;
		//this.excelFile = f;

	}

	public void paint(Graphics g){
		clear(g);
		//findBestCombo();
		//findBestWeightedCombo();
		generateBracket(g);
	}


	public void findBestCombo(){
		Global.bestNumberOfCorrectGames =0;
		Global.numberOfCorrectGames =0;
		Global.bestCombination =  new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		initArray();
		setMaxes();
		for (int a = 0; a <= 100; a+=50){
			Global.seedWeight = a;
			for(int b = 0; b <= 100; b+=50){
				Global.winPercentageWeight = b;
				for (int c = 0; c <= 100; c+=50){
					Global.fieldGoalPercentageWeight = c;
					for (int d = 0; d <= 100; d+=50){
						Global.threePointsPercentageWeight = d;
						for (int e = 0; e <= 100; e+=50){
							Global.offensiveRebsWeight = e;
							for (int f = 0; f <= 100; f+=50){
								Global.defensiveRebsWeight = f;
								for (int g = 0; g <= 100; g+=50){
									Global.stealsWeight = g;
									for (int h = 0; h <= 100; h+=50){
										Global.blocksWeight = h;
										for (int i = 0; i <= 100; i+=50){
											Global.ppgWeight =h;
											for (int j = 0; j <= 100; j+=50){
												Global.turnoversWeight =j;
												playTournament2();
												if (Global.numberOfCorrectGames > Global.bestNumberOfCorrectGames){
													Global.bestNumberOfCorrectGames = Global.numberOfCorrectGames;
													Global.bestCombination[0] = a;
													Global.bestCombination[1] = b;
													Global.bestCombination[2] = c;
													Global.bestCombination[3] = d;
													Global.bestCombination[4] = e;
													Global.bestCombination[5] = f;
													Global.bestCombination[6] = g;
													Global.bestCombination[7] = h;
													Global.bestCombination[8] = i;
													Global.bestCombination[9] = j;
													System.out.println("new best!  = " + Global.bestNumberOfCorrectGames);
													System.out.println(Global.bestCombination[0]+", "+
															Global.bestCombination[1]+", "+
															Global.bestCombination[2]+", "+
															Global.bestCombination[3]+", "+
															Global.bestCombination[4]+", "+
															Global.bestCombination[5]+", "+
															Global.bestCombination[6]+", "+
															Global.bestCombination[7]+", "+
															Global.bestCombination[8]+", "+
															Global.bestCombination[9]+", ");
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		Global.seedWeight = Global.bestCombination[0];
		Global.winPercentageWeight = Global.bestCombination[1];
		Global.fieldGoalPercentageWeight = Global.bestCombination[2];
		Global.threePointsPercentageWeight = Global.bestCombination[3];
		Global.offensiveRebsWeight = Global.bestCombination[4];
		Global.defensiveRebsWeight = Global.bestCombination[5];
		Global.stealsWeight =Global.bestCombination[6];
		Global.blocksWeight = Global.bestCombination[7];
		Global.ppgWeight =  Global.bestCombination[8];
		Global.turnoversWeight = Global.bestCombination[9];
	}

	public void playTournament2(){
		Global.numberOfCorrectGames =0;
		Global.currentScore =0;
		rankTeams();	// calculates the overall Rank of each team

		Global.teamIndex = 0;
		Game semi1 = InitializeTournament(teamArray);
		Game semi2 = InitializeTournament(teamArray);

		semi1.playTournament();
		semi2.playTournament();

		Game champ = new Game(null);
		champ.setTeam1(semi1.getWinner());
		champ.setTeam2(semi2.getWinner());
		champ.playGame();
	}

	public void findBestWeightedCombo(){
		Global.bestScore = 0;
		Global.currentScore = 0;
		Global.bestCombination =  new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		initArray();
		setMaxes();
		for (int a = 0; a <= 100; a+=50){
			Global.seedWeight = a;
			for(int b = 0; b <= 100; b+=50){
				Global.winPercentageWeight = b;
				for (int c = 0; c <= 100; c+=50){
					Global.fieldGoalPercentageWeight = c;
					for (int d = 0; d <= 100; d+=50){
						Global.threePointsPercentageWeight = d;
						for (int e = 0; e <= 100; e+=50){
							Global.offensiveRebsWeight = e;
							for (int f = 0; f <= 100; f+=50){
								Global.defensiveRebsWeight = f;
								for (int g = 0; g <= 100; g+=50){
									Global.stealsWeight = g;
									for (int h = 0; h <= 100; h+=50){
										Global.blocksWeight = h;
										for (int i = 0; i <= 100; i+=50){
											Global.ppgWeight =h;
											for (int j = 0; j <= 100; j+=50){
												Global.turnoversWeight =j;
												playTournament2();
												if (Global.currentScore > Global.bestScore){
													Global.bestScore = Global.currentScore;
													Global.bestCombination[0] = a;
													Global.bestCombination[1] = b;
													Global.bestCombination[2] = c;
													Global.bestCombination[3] = d;
													Global.bestCombination[4] = e;
													Global.bestCombination[5] = f;
													Global.bestCombination[6] = g;
													Global.bestCombination[7] = h;
													Global.bestCombination[8] = i;
													Global.bestCombination[9] = j;
													System.out.println("new best!");
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		Global.seedWeight = Global.bestCombination[0];
		Global.winPercentageWeight = Global.bestCombination[1];
		Global.fieldGoalPercentageWeight = Global.bestCombination[2];
		Global.threePointsPercentageWeight = Global.bestCombination[3];
		Global.offensiveRebsWeight = Global.bestCombination[4];
		Global.defensiveRebsWeight = Global.bestCombination[5];
		Global.stealsWeight =Global.bestCombination[6];
		Global.blocksWeight = Global.bestCombination[7];
		Global.ppgWeight =  Global.bestCombination[8];
		Global.turnoversWeight = Global.bestCombination[9];
		
	}

	/*
	public void initWeights(){
		Global.seedWeight = 100;
		Global.winPercentageWeight = 100;
		Global.fieldGoalPercentageWeight = 100;
		Global.threePointsPercentageWeight = 100;
		Global.offensiveRebsWeight = 100;
		Global.defensiveRebsWeight = 100;
		Global.stealsWeight = 100;
		Global.blocksWeight = 100;
		Global.ppgWeight = 100;
		Global.turnoversWeight = 100;

	}
	 */
	/**
	 * Sets up and plays the tournament
	 * @param g Graphics page to draw on
	 */
	public void generateBracket(Graphics g){ 	
		Global.numberOfCorrectGames =0;
		Global.currentScore =0;
		initArray();
		setMaxes();
		rankTeams();	// calculates the overall Rank of each team

		Global.teamIndex = 0;
		Game semi1 = InitializeTournament(teamArray);
		Game semi2 = InitializeTournament(teamArray);

		semi1.playTournament();
		semi2.playTournament();

		Game champ = new Game(null);
		champ.setTeam1(semi1.getWinner());
		champ.setTeam2(semi2.getWinner());
		champ.playGame();


		Dimension appletSize = this.getSize();
		int appH = appletSize.height;
		int appW = appletSize.width;
		int rW = 80;		// length of a rect
		int rH = 25;		// height of a rect
		int spacing = 0;	//space between game nodes
		int lineLength = 40;
		semi1.drawGame(g, appW/2 + lineLength + rW , appH/2, rH, rW, spacing, lineLength);
		semi2.drawGameLeft(g, appW/2 - lineLength - 2*rW, appH/2, rH, rW, spacing, lineLength);
		champ.drawChamp(g, appW/2 - rW/2, appH/2, rH, rW, rW);
		if (back!=null){
			remove(back);
		}
		//back = new JButton("BACK");
		back = new JButton(Global.numberOfCorrectGames + "");
		//back = new JButton(Global.bestScore + "");
		back.setIgnoreRepaint(true);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove(back);
				CardLayout cl = (CardLayout) (mainPanel.getLayout());
				cl.next(mainPanel);
			}
		});
		back.setBounds(appW/2 - rW/2, appH-100, rW, rH);
		this.add(back);
		back.setVisible(true);
		back.requestFocusInWindow();

	}

	/**
	 * 
	 */
	public void setMaxes(){
		Global.seedMax = 16;
		Global.winPercentageMax = 0;
		Global.fieldGoalPercentageMax = 0;
		Global.threePointsPercentageMax = 0;
		Global.offensiveRebsMax = 0;
		Global.defensiveRebsMax = 0;
		Global.stealsMax = 0;
		Global.blocksMax = 0;
		Global.ppgMax = 0;
		Global.turnoversMax = 0;

		for (int i =0; i < 64; i++){

			if (teamArray[i].getWinPercentage() > Global.winPercentageMax){
				Global.winPercentageMax = teamArray[i].getWinPercentage();
			}
			if (teamArray[i].getFieldGoalPercentage() > Global.fieldGoalPercentageMax){
				Global.fieldGoalPercentageMax = teamArray[i].getFieldGoalPercentage();
			}
			if (teamArray[i].getThreePointsPercentage() > Global.threePointsPercentageMax){
				Global.threePointsPercentageMax = teamArray[i].getThreePointsPercentage();
			}
			if (teamArray[i].getOffensiveRebs() > Global.offensiveRebsMax){
				Global.offensiveRebsMax = teamArray[i].getOffensiveRebs();
			}
			if (teamArray[i].getDefensiveRebs() > Global.defensiveRebsMax){
				Global.defensiveRebsMax = teamArray[i].getDefensiveRebs();
			}
			if (teamArray[i].getSteals() > Global.stealsMax){
				Global.stealsMax = teamArray[i].getSteals();
			}
			if (teamArray[i].getBlocks() > Global.blocksMax){
				Global.blocksMax = teamArray[i].getBlocks();
			}
			if (teamArray[i].getPpg() > Global.ppgMax){
				Global.ppgMax = teamArray[i].getPpg();
			}
			if (teamArray[i].getTurnovers() > Global.turnoversMax){
				Global.turnoversMax = teamArray[i].getTurnovers();
			}
		}


	}

	/**
	 * Recursively creates and links all 
	 * the Games in the Tournament
	 * 
	 * @param teams
	 * @return returns the championship game.
	 */
	public Game InitializeTournament(Team[] teams)
	{
		Game championship = new Game(null);
		championship.createGames(teams);
		return championship;
	}

	/**
	 * ranks the teams
	 * @param teams
	 */
	public void rankTeams(){
		for (int i=0; i < teamArray.length; i++){
			teamArray[i].setOverallScore((((Global.seedMax - teamArray[i].getSeed())*Global.seedWeight))+
					((teamArray[i].getWinPercentage()*Global.winPercentageWeight)/Global.winPercentageMax)+
					((teamArray[i].getFieldGoalPercentage()*Global.fieldGoalPercentageWeight)/Global.fieldGoalPercentageMax)+
					((teamArray[i].getThreePointsPercentage()*Global.threePointsPercentageWeight)/Global.threePointsPercentageMax)+
					((teamArray[i].getOffensiveRebs()*Global.offensiveRebsWeight)/Global.offensiveRebsMax)+
					((teamArray[i].getDefensiveRebs()*Global.defensiveRebsWeight)/Global.defensiveRebsMax)+
					((teamArray[i].getSteals()*Global.stealsWeight)/Global.stealsMax)+
					((teamArray[i].getBlocks()*Global.blocksWeight)/Global.blocksMax)+
					((teamArray[i].getPpg()*Global.ppgWeight)/Global.ppgMax)+
					((Global.turnoversMax - teamArray[i].getTurnovers())*Global.turnoversWeight)/Global.turnoversMax);
		}
	}


	public void clear(Graphics g){
		g.clearRect(0, 0, 2000, 2000);
	}

	public void printStats(){
		for (int i=0; i<teamArray.length;i++){

		}
	}

	public void initArray(){
		ExcelReader test = new ExcelReader(this);
		/*if (this.excelFile == null){
			test.setInputFile(new File("SportsAnalyticsProjectStatsData.xls"));
		}
		else{
			test.setInputFile(this.excelFile);
		}*/
		this.excelFile = new File("SportsAnalyticsProjectStatsData.xls");
		test.setInputFile(this.excelFile);
		try {
			teamArray = test.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * getter for TeamArray
	 * @return this.TeamArray
	 */
	public Team[] getTeamArray(){
		return this.teamArray;
	}

	/**
	 * sets this.teamArray
	 * @param teamArray
	 */
	public void setTeamArray(Team[] teamArray){
		this.teamArray = teamArray;
	}

}