import javax.swing.Icon;


public class Team {
	
	private String name;		// team name
	private double overallScore;// the score that they are ranked by
	private int seed;		  	// seed in the tournament
	private double winPercentage;	// win %
	private double fieldGoalPercentage; // field goal percentage
	private double threePointsPercentage; // 3podoubles%
	private double offensiveRebs; // Offensive Rebounds/Game
	private double defensiveRebs; // defensive Rebounds/Game
	private double steals;	// steals/game
	private double blocks;	//blocks/Game
	private double ppg; //points/game
	private double turnovers; // turnovers/Game


	
	public Team(String name, int seed, double winPercentage, double fieldGoalPercentage, 
			double threePointsPercentage, double offensiveRebs, double defensiveRebs, double steals,
			double blocks, double ppg, double turnovers){

		this.name = name;		// team name
		this.seed = seed;		  	// seed in the tournament
		this.winPercentage = winPercentage;	// win %
		this.fieldGoalPercentage = fieldGoalPercentage; // field goal percentage
		this.threePointsPercentage = threePointsPercentage; // 3points%
		this.offensiveRebs = offensiveRebs; // Offensive Rebounds/Game
		this.defensiveRebs = defensiveRebs; // defensive Rebounds/Game
		this.steals = steals;	// steals/game
		this.blocks = blocks;	//blocks/Game
		this.ppg = ppg; //points/game
		this.turnovers = turnovers; // turnovers/Game
		
	}
	
	public Team(String name, Icon i, int seed, int oRebs){
		this.name = name;		// team name
		this.seed = seed;		  	// seed in the tournament
		this.offensiveRebs = oRebs;
	}
	

		
	public String toString(){
		return (this.name + " \tS:" +seed);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public double getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(double overallScore) {
		this.overallScore = overallScore;
	}

	public int getSeed() {
		return seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}

	public double getWinPercentage() {
		return winPercentage;
	}

	public void setWinPercentage(double winPercentage) {
		this.winPercentage = winPercentage;
	}

	public double getFieldGoalPercentage() {
		return fieldGoalPercentage;
	}

	public void setFieldGoalPercentage(double fieldGoalPercentage) {
		this.fieldGoalPercentage = fieldGoalPercentage;
	}

	public double getThreePointsPercentage() {
		return threePointsPercentage;
	}

	public void setThreePointsPercentage(double threePointsPercentage) {
		this.threePointsPercentage = threePointsPercentage;
	}

	public double getOffensiveRebs() {
		return offensiveRebs;
	}

	public void setOffensiveRebs(double offensiveRebs) {
		this.offensiveRebs = offensiveRebs;
	}

	public double getDefensiveRebs() {
		return defensiveRebs;
	}

	public void setDefensiveRebs(double defensiveRebs) {
		this.defensiveRebs = defensiveRebs;
	}

	public double getSteals() {
		return steals;
	}

	public void setSteals(double steals) {
		this.steals = steals;
	}

	public double getBlocks() {
		return blocks;
	}

	public void setBlocks(double blocks) {
		this.blocks = blocks;
	}

	public double getPpg() {
		return ppg;
	}

	public void setPpg(double ppg) {
		this.ppg = ppg;
	}

	public double getTurnovers() {
		return turnovers;
	}

	public void setTurnovers(double turnovers) {
		this.turnovers = turnovers;
	}

	
}