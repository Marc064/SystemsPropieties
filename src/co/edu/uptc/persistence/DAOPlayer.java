package co.edu.uptc.persistence;

import java.util.ArrayList;

import co.edu.uptc.logic.model.Player;
import co.edu.uptc.utilities.Archive;

public class DAOPlayer {

	private String route_one = "Means/SCORES/ScoresEasy.score";
	private String route_two = "Means/SCORES/ScoresMedium.score";
	private String route_three = "Means/SCORES/ScoresHard.score";

	public void saveScore(Player p, int type) {

		if (type == 1) {
			new Archive().AddContents(route_one, p.getID() + ", " + p.getName() + ", " + p.getScore());
		} else if (type == 2) {
			new Archive().AddContents(route_two, p.getID() + ", " + p.getName() + ", " + p.getScore());
		} else if (type == 3) {
			new Archive().AddContents(route_three, p.getID() + ", " + p.getName() + ", " + p.getScore());
		}

	}

	public ArrayList<Player> displayPlayerData() {
		ArrayList<Player> listPlayer = new ArrayList<Player>();
		ArrayList<String> data1 = new Archive().FileContents(route_one);
		ArrayList<String> data2 = new Archive().FileContents(route_two);
		ArrayList<String> data3 = new Archive().FileContents(route_three);

		for (int i = 0; i < data1.size(); i++) {

			String Line[] = data1.get(i).split(", ");
			Player p = new Player();

			p.setID(Integer.parseInt(Line[0]));
			p.setName(Line[1]);
			p.setScore(Integer.parseInt(Line[2].replace(";", "")));

			listPlayer.add(p);

		}
		for (int i = 0; i < data2.size(); i++) {

			String Line[] = data2.get(i).split(", ");
			Player p = new Player();

			p.setID(Integer.parseInt(Line[0]));
			p.setName(Line[1]);
			p.setScore(Integer.parseInt(Line[2].replace(";", "")));

			listPlayer.add(p);

		}
		for (int i = 0; i < data3.size(); i++) {

			String Line[] = data3.get(i).split(", ");
			Player p = new Player();

			p.setID(Integer.parseInt(Line[0]));
			p.setName(Line[1]);
			p.setScore(Integer.parseInt(Line[2].replace(";", "")));

			listPlayer.add(p);

		}

		return listPlayer;
	}

	public ArrayList<Player> displayPlayerDataDifficults(int type) {
		String route = "";
		if (type == 1) {
			route = route_one;
		} else if (type == 2) {
			route = route_two;
		} else if (type == 3) {
			route = route_three;
		}
		ArrayList<String> data = new Archive().FileContents(route);
		ArrayList<Player> listPlayer = new ArrayList<Player>();

		for (int i = 0; i < data.size(); i++) {

			String Line[] = data.get(i).split(", ");
			Player p = new Player();

			p.setID(Integer.parseInt(Line[0]));
			p.setName(Line[1]);
			p.setScore(Integer.parseInt(Line[2].replace(";", "")));

			listPlayer.add(p);
		}
		return listPlayer;
	}
	
	public void resetDataScores(int type) {
		
		if(type == 1) {
			
			new Archive().resetArchive(route_one);
			
		}
		else if( type == 2) {
			
			new Archive().resetArchive(route_two);
			
		}
		else if(type == 3) {
			
			new Archive().resetArchive(route_three);
			
		}
		
	}

}
