
import java.applet.*; 
import java.awt.*;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class Tournament extends Applet{

	
	private Team[] teamArray;

	// The method that will be automatically called  when the applet is started 
	public void init(){ 
		resize(2000, 2000);
	} 
	// This method gets called when the applet is terminated 
	// That's when the user goes to another page or exits the browser. 
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

		/*
		Team UNC = new Team("North Carolina", null, 1 , 30);
		Team Duke = new Team("Duke", null, 16, 28);
		Team SYR = new Team("Syracuse", null, 8, 15);
		Team BY = new Team("Baylor", null, 9, 20);
		Team OSU = new Team("Ohio St", null, 5, 10);
		Team UK = new Team("Kentucky", null, 12, 15);
		Team UVA = new Team("Virginia", null, 4, 15);
		Team HAR = new Team("Harvard" ,null, 13, 5);
		Team UF = new Team("Florida", null, 6, 30);
		Team VT = new Team("Viginia Tech", null , 11, 41);
		Team GT = new Team("Georgia Tech", null, 3, 100);
		Team WF = new Team("Wake Forrest", null, 14 , 26);
		Team UGA = new Team("UGA", null , 7, 0);
		Team UCONN = new Team("UCONN", null, 10, 11);
		Team UCLA = new Team("UCLA", null, 2 , 27);
		Team UNLV = new Team("UNLV" , null, 15 , 24);
		Team GNZ = new Team("Gonzaga", null, 1 , 35);
		Team Army = new Team("Army", null, 16, 5);
		Team TENN = new Team("Tennesee", null, 8, 14);
		Team USC = new Team("USC", null, 9 , 16);
		Team VANDY = new Team("Vanderbilt", null, 5, 22);
		Team UM = new Team("Miami", null, 12, 25);
		Team CLEM = new Team("Clemson", null, 4 , 30);
		Team TCU = new Team("TCU", null, 13, 40);
		Team SMU = new Team("SMU", null, 6, 12);
		Team MRH = new Team("Morehouse", null, 11, 30);
		Team UT = new Team("Texas", null, 3, 23);
		Team PRD = new Team("Purdue", null, 14 , 40);
		Team FLST = new Team("Florida St", null, 7, 11);
		Team LSU = new Team("LSU", null, 10, 10);
		Team BAMA = new Team("Alabama", null, 2, 19);
		Team ARK = new Team("Arkansas", null, 15, 2);
		Team MST = new Team("Michigan St", null, 1 , 30);
		Team RICE = new Team("Rice", null, 16, 40);
		Team MICH = new Team("Michigan", null, 8, 23 );
		Team MARQ = new Team("Marquettte", null, 9, 15);
		Team WVU = new Team("West Virginia", null, 5, 11);
		Team RUT = new Team("Rutgers", null, 12, 22);
		Team PITT = new Team("Pittsburgh", null, 4, 40);
		Team PRNC = new Team("Princeton", null, 13, 22);
		Team CAL = new Team("California", null, 6, 22);
		Team ARZ = new Team("Arizona", null, 11, 1);
		Team COL = new Team("Colorado", null, 3, 18);
		Team AZST = new Team("Arizona St", null, 14, 19);
		Team TAM = new Team("Texas A&M", null, 7, 10);
		Team MIZZ= new Team("Missouri", null, 10, 23);
		Team WIS= new Team("Wisconsin", null, 2, 32);
		Team ILL = new Team("Illinois", null, 15, 11);
		Team IOWA= new Team("Iowa", null, 1, 5);
		Team TROY = new Team("Troy", null, 16, 3);
		Team NCST= new Team("North Carolina St", null, 8, 19);
		Team ORG = new Team("Oregon", null, 9, 5);
		Team SDST = new Team("San Diego St", null, 5, 8);
		Team BUT = new Team("Butler", null, 12, 14);
		Team MURST= new Team("Murray St", null, 4, 16);
		Team STAN= new Team("Stanford", null, 13, 32);
		Team WASH= new Team("Washington", null, 6, 33);
		Team WASHST= new Team("Washington St", null, 11, 32);
		Team MISS = new Team("Missisippi", null, 3, 14);
		Team VCU = new Team("VCU", null, 14, 19);
		Team IND = new Team("Indiana", null, 7, 48);
		Team MINN = new Team("Minnesota", null, 10, 44);
		Team ECU = new Team("Eastern Carolina", null, 2, 11);
		Team ND= new Team("Notre Dame", null, 15, 13);

		Team[] t = {UNC, Duke, SYR, BY, OSU, UK, UVA, HAR, UF, VT, GT, WF, UGA,
				UCONN, UCLA, UNLV, GNZ, Army, TENN, USC, VANDY, UM, CLEM, TCU, SMU, MRH,
				UT, PRD, FLST, LSU, BAMA, ARK,	//first 32 teams are above
				MST, RICE, MICH, MARQ, WVU, RUT, PITT, PRNC, CAL, ARZ, AZST, COL, TAM,
				MIZZ, WIS, ILL, IOWA, TROY, NCST, ORG, SDST, BUT, MURST, STAN, WASH, WASHST,
				MISS, VCU, IND, MINN, ECU, ND};

		teamArray = t;
		 */
	}
}


