
public class Global {
	public static int xxx =0;
	
	public static int teamIndex;
	public static int maxRound = 5; 
	public static int maxSeed = 16;	
	public static int sliderTotal = 100;
	public static int season = 2011;
	public static int numberOfGames = 64; // counting the winner rectangle as a game
	public static int numberOfCorrectGames;	//
	public static int bestNumberOfCorrectGames;
	public static int[] bestCombination = new int[] {0,0,0,0,0,0,0,0,0,0}; // the ten weights
	public static int bestScore;
	public static int currentScore;
	
	// maximums
	public static double seedMax;
	public static double winPercentageMax;
	public static double fieldGoalPercentageMax;
	public static double threePointsPercentageMax;
	public static double offensiveRebsMax;
	public static double defensiveRebsMax;
	public static double stealsMax;
	public static double blocksMax;
	public static double ppgMax;
	public static double turnoversMax;
	
	
	// input from sliders
	public static double seedWeight;
	public static double winPercentageWeight;
	public static double fieldGoalPercentageWeight;
	public static double threePointsPercentageWeight;
	public static double offensiveRebsWeight;
	public static double defensiveRebsWeight;
	public static double stealsWeight;
	public static double blocksWeight;
	public static double ppgWeight;
	public static double turnoversWeight;

}
