import javax.swing.Icon;


public class Team {
	
	private String name;		// team name
	private Icon pic;		 	// the team logo
	private double overallScore;// the score that they are ranked by
	private int seed;		  	// seed in the tournament
	private int rebounds;		// rebounds per game
	private int winPercentage;	// win %
	private int threePointsPerGame; // 3points/game
	static double seedWeight;
	static double reboundsWeight;
	static double winPercentgeWeight;
	static double threePointsPerGameWeight;
	
	public Team(String name, Icon pic, int seed, int rebs/*, int winPercentage, int threePointsPerGame*/){
		this.name = name;
		this.pic = pic;
		this.seed = seed;
		this.rebounds = rebs;
		/*this.setWinPercentage(winPercentage);
		this.setThreePointsPerGame(threePointsPerGame);*/
	}
	
	/**
	 * ranks the teams
	 * @param teams
	 */
	public static void rankTeams(Team[] teams){
		for (int i=0; i < teams.length; i++){
			teams[i].setOverallScore(seedWeight*(Global.maxSeed - teams[i].getSeed()) + reboundsWeight*teams[i].getRebounds()/* + winPercentageWeight*teams[i].getWinPercentage() + threePointsPerGameWeight*teams[i].getThreePointsPerGame()*/);
			//teams[i].setOverallScore(Global.maxSeed - teams[i].getSeed());
		}
	}
	
	
	public String toString(){
		return (this.name + " \tS:" +seed + " R:" + rebounds);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Icon getPic() {
		return pic;
	}
	
	public void setPic(Icon pic) {
		this.pic = pic;
	}
	
	public int getSeed() {
		return seed;
	}
	
	public void setSeed(int seed) {
		this.seed = seed;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public double getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(double d) {
		this.overallScore = d;
	}

	public int getWinPercentage() {
		return winPercentage;
	}

	public void setWinPercentage(int winPercentage) {
		this.winPercentage = winPercentage;
	}

	public int getThreePointsPerGame() {
		return threePointsPerGame;
	}

	public void setThreePointsPerGame(int threePointsPerGame) {
		this.threePointsPerGame = threePointsPerGame;
	}

}
