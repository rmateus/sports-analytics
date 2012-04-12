
import java.applet.*; 
import java.awt.*;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class Tournament extends Applet{

	
	private Team[] teamArray;


	public void init(){ 
		resize(2000, 2000);
	} 

	public void stop()  { 
	} 

	// TODO delete when sliders work
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

	/**
	 * Sets up and plays the tournament
	 * @param g Graphics page to draw on
	 */
	public void generateBracket(Graphics g){
		initWeights(); //method only used for testing. 
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

	}


	public void paint(Graphics g){ 
		clear(g);
		generateBracket(g);
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
			teamArray[i].setOverallScore((((Global.seedMax - teamArray[i].getSeed())*Global.seedWeight)/Global.maxSeed)+
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
		test.setInputFile("C:" + File.separator+ "Users" +File.separator+ "Jeff" +File.separator+ 
				"workspace" +File.separator+ "SportsAnalytics" +File.separator+ "SportsAnalyticsProjectStatsData.xls");
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


