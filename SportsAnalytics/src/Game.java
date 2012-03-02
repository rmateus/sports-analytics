import java.awt.Graphics;


public class Game {

	private Team team1;		// the first team
	private Team team2;		// the second team
	private Team winner;	// the winner of this game
	private Game nextGame;	// the game that comes next in the tournament
	private Game prevGame1;	// the previous game that contributes one team
	private Game prevGame2;	// the previous game that contributes one team

	public Game(Game nextGame){
		this.nextGame = nextGame;

	}

	/**
	 * decides who the winner is based on their overallScore 
	 * and calls advance
	 */
	public void playGame(){
		// determine which team one
		if (team1.getOverallScore() >= team2.getOverallScore())
			this.setWinner(team1);
		else
			this.setWinner(team2);
		// advance them to the next round
		advance(this.winner);
	}

	/**
	 * advances the winner of a game to the next game
	 * @param winner the winner of the current game
	 */
	public void advance(Team winner){
		if (this.nextGame == null)	// check for null (if its the championship game)
			return;
		if (this.nextGame.getTeam1() == null) 
			this.nextGame.setTeam1(winner);		
		else if (this.nextGame.getTeam2() == null)
			this.nextGame.setTeam2(winner);
		return;
	}

	/**
	 * draws the championship game and the winner "game"
	 * @param g the graphics page to draw on
	 * @param x	the x-coordinate
	 * @param y	the y coordinate
	 * @param height the height
	 * @param width the width
	 * @param lineLength how long (LEFT TO RIGHT) the lines are
	 */
	public void drawChamp(Graphics g, int x, int y, int height, int width, int lineLength){
		g.drawRect(x, y, width, height);
		g.drawString(this.team1.getSeed()+ " " +this.team1.getName(), x, y);
		g.drawString(this.team2.getSeed()+ " " +this.team2.getName(), x, y+height);

		g.drawLine(x + width, y+ (height/2), x + width + lineLength, y + (height/2));
		g.drawLine(x, y + (height/2), x - lineLength, y + (height/2));

		g.drawLine(x + width/2, y, x+width/2, y-2*lineLength);
		g.drawRect(x, y-2*lineLength-height, width, height);
		g.drawString(this.getWinner().getSeed() +" " + this.getWinner().getName(), x, y-2*lineLength-height);
	}

	/**
	 * draws the right half of the bracket
	 * @param g the graphics page to draw on
	 * @param x	the x-coordinate
	 * @param y	the y coordinate
	 * @param height the height
	 * @param width the width
	 * @param spacing NOT USED
	 * @param lineLength how long (LEFT TO RIGHT) the lines are
	 */
	public void drawGame(Graphics g, int x, int y, int height, int width, int spacing, int lineLength){ 
		//right half of bracket
		g.drawRect(x,y,width,height);
		if(this.team1 != null){
			g.drawString(this.team1.getSeed()+ " " +this.team1.getName(), x, y);
		}

		if(this.team2 != null){
			g.drawString(this.team2.getSeed()+ " " +this.team2.getName(), x, y + height);
		}

		int round = Global.maxRound - this.getRound() -2; // should be a 1. the two allows it to fit on the screen
		if(this.prevGame2 != null){
			g.drawLine(x+width,y+(height/2),x+width+lineLength,y+(height/2)+(height*((int)Math.pow(2, round))));
			prevGame2.drawGame(g, x+width+lineLength, y+((height)*((int)Math.pow(2, round))) , height, width, spacing, lineLength);
		}

		if(this.prevGame1 != null){
			g.drawLine(x+width,y+(height/2),x+width+lineLength,y+(height/2)-(height*((int)Math.pow(2, round))));
			prevGame1.drawGame(g, x+width+lineLength, y-((height)*((int)Math.pow(2, round))), height, width, spacing, lineLength);
		}
	}

	/**
	 * draws the left half of the bracket
	 * @param g the graphics page to draw on
	 * @param x	the x-coordinate
	 * @param y	the y coordinate
	 * @param height the height
	 * @param width the width
	 * @param spacing NOT USED
	 * @param lineLength how long (LEFT TO RIGHT) the lines are
	 */
	public void drawGameLeft(Graphics g, int x, int y, int height, int width, int spacing, int lineLength){ 
		g.drawRect(x,y,width,height);
		if(this.team1 != null){
			g.drawString(this.team1.getSeed()+ " " +this.team1.getName(), x, y);
		}

		if(this.team2 != null){
			g.drawString(this.team2.getSeed()+ " " +this.team2.getName(), x, y + height);
		}
		int round = Global.maxRound - this.getRound() -2; // should be a 1. the two allows it to fit on the screen
		if(this.prevGame2 != null){
			g.drawLine(x,y+(height/2),x-lineLength,y+(height/2)+(spacing+height*((int)Math.pow(2, round))));
			prevGame2.drawGameLeft(g, x-width-lineLength, y+(spacing+(height)*((int)Math.pow(2, round))) , height, width, spacing, lineLength);
		}

		if(this.prevGame1 != null){
			g.drawLine(x,y+(height/2),x-lineLength,y+(height/2)-(spacing+height*((int)Math.pow(2, round))));
			prevGame1.drawGameLeft(g, x-width-lineLength, y-(spacing+(height)*((int)Math.pow(2, round))), height, width, spacing, lineLength);
		}

	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Team getWinner() {
		return winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}

	public Game getNextGame() {
		return nextGame;
	}

	public void setNextGame(Game nextGame) {
		this.nextGame = nextGame;
	}

	public Game getPrevGame1() {
		return prevGame1;
	}

	public void setPrevGame1(Game prevGame1) {
		this.prevGame1 = prevGame1;
	}

	public Game getPrevGame2() {
		return prevGame2;
	}

	public void setPrevGame2(Game prevGame2) {
		this.prevGame2 = prevGame2;
	}

	/**
	 * tells what round the game is in
	 * @return the round the game is inn, where zero is the Championship
	 */
	public int getRound(){
		int i =0;
		Game probe = this;
		while (probe.getNextGame()!=null){
			i++;
			probe=probe.getNextGame();
		}
		return i;
	}


	/**
	 * Creates games and sets the teams and previous games
	 * @param teams The array list of teams
	 */
	public void createGames(Team[] teams){
		if (this.getRound() < Global.maxRound-1){
			this.setPrevGame1(new Game(this));
			this.setPrevGame2(new Game(this));
			this.getPrevGame1().createGames(teams);
			this.getPrevGame2().createGames(teams);
		}

		if (this.getRound() == Global.maxRound-1){
			this.setTeam1(teams[Global.teamIndex]);
			Global.teamIndex++;
		}
		if (this.getRound() == Global.maxRound-1){
			this.setTeam2(teams[Global.teamIndex]);
			Global.teamIndex++;
		}

	}

	/**
	 * plays all the games. advances winning teams
	 */
	public void playTournament(){
		if (this.getRound() < Global.maxRound-1){
			this.prevGame1.playTournament();
			this.prevGame2.playTournament();
			this.playGame();
		}
		else
			this.playGame();
	}




}

