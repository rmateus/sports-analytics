
import java.applet.*; 
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class Tournament extends Applet{

		private Team[] teamArray;
		//private JSlider sb = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		
		
		// The method that will be automatically called  when the applet is started 
		public void init(){ 
			resize(2000, 2000);
		 // It is required but does not need anything. 
		} 
		// This method gets called when the applet is terminated 
		// That's when the user goes to another page or exits the browser. 
		public void stop()  { 
		     // no actions needed here now. 
		} 
		// The standard method that you have to use to paint things on screen 
		// This overrides the empty Applet method, you can't called it "display" for example.

		public void paint(Graphics g){ 
			
			ExcelReader test = new ExcelReader(this);
			test.setInputFile("C:" + File.separator+ "Users" +File.separator+ "Jeff" +File.separator+ 
				"workspace" +File.separator+ "SportsAnalytics" +File.separator+ "SportsExample.xls");
			try {
				test.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Team.rankTeams(teamArray);	// calculates the overall Rank of each team
			
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


