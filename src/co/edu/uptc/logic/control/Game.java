package co.edu.uptc.logic.control;
/**
 * @author Marco Antonio Vargas Garcia & Miguel Angel Alfonso Saavedra
 * @version 1.0
 */
import java.util.ArrayList;

import co.edu.uptc.logic.model.Player;
import co.edu.uptc.logic.model.Question.*;
import co.edu.uptc.persistence.DAOPlayer;
import co.edu.uptc.persistence.DAOQuestion;

public class Game {

	private ArrayList<Player> ListScores;
	private ArrayList<Question> ListAllQuestions;

	public Game() {

		ListAllQuestions = new DAOQuestion().DisplayQuestionData();
		
	}

	public ArrayList<Player> getListScore() {
		ListScores = new DAOPlayer().displayPlayerData();
		return ListScores;
	}

public void ScoreRegistration(String name, int score, String difficult) {
		
		Player p = new Player();
		p.setScore(score);
		p.setName(name);
		int type = 0;
		int id = 0;
		if(difficult.equalsIgnoreCase("easy")==true) { type = 1; id = 1000; }
		else if(difficult.equalsIgnoreCase("medium")==true) { type = 2; id = 2000;}
		else if(difficult.equalsIgnoreCase("hard")==true) { type = 3; id = 3000;}
		ArrayList<Player> ListScoresType = new DAOPlayer().displayPlayerDataDifficults(type);
		new DAOPlayer().resetDataScores(type);
		if(ListScoresType.size() == 0) {
			p.setID(0+id);
			new DAOPlayer().saveScore(p, type);
		}else {
			int cont = 0;
			for (int i = 0; i < ListScoresType.size(); i++) {
				if(score > ListScoresType.get(i).getScore() && cont == 0) {
					p.setID(i+id);
					new DAOPlayer().saveScore(p, type);
					cont++;
				}
				ListScoresType.get(i).setID(ListScoresType.get(i).getID()+cont);
				new DAOPlayer().saveScore(ListScoresType.get(i), type);
			}
			if(cont == 0) {
				p.setID(ListScoresType.size()+id);
				new DAOPlayer().saveScore(p, type);
			}
			
		}
	
		ListScores = new DAOPlayer().displayPlayerData();
	}

	public void GenerateQuestionsGame(String difficult) {

		new DAOQuestion().resetQuestionGame();

		ArrayList<Question> auxListQuestion = ListAllQuestions;

		int cantQuestion = 0;
		if (difficult.equalsIgnoreCase("easy") == true) {
			cantQuestion = 15;
		} else if (difficult.equalsIgnoreCase("medium") == true) {
			cantQuestion = 30;
		} else if (difficult.equalsIgnoreCase("hard") == true) {
			cantQuestion = 45;
		}

		int cont1 = 0;
		int cont2 = 0;
		int cont3 = 0;

		for (int i = 0; i < auxListQuestion.size(); i++) {

			if (ListAllQuestions.get(i).getID() >= 100 && ListAllQuestions.get(i).getID() < 200) {
				cont1++;
			} else if (ListAllQuestions.get(i).getID() >= 200 && ListAllQuestions.get(i).getID() < 300) {
				cont2++;
			} else if (ListAllQuestions.get(i).getID() >= 300) {
				cont3++;
			}
		}

		int cont4 = 0;
		int cont5 = 0;
		int cont6 = 0;

		for (int i = 0; i < cantQuestion; i++) {
			int tipQuestion = (int) (Math.random() * (2) + 1);
			int aux = 0;
			while (aux == 0) {
				if (tipQuestion == 1 && cont4 == (cantQuestion / 3)) {
					tipQuestion = (int) (Math.random() * (2) + 1);
				} else if (tipQuestion == 2 && cont5 == (cantQuestion / 3)) {
					tipQuestion = (int) (Math.random() * (2) + 1);
//				} else if (tipQuestion == 3 && cont6 == (cantQuestion / 3)) {
//					tipQuestion = (int) (Math.random() * (2) + 1);
				} else {
					aux++;
				}
			}
			if (tipQuestion == 1 && cont4 != (cantQuestion / 3)) {
				int mo = (int) (Math.random() * (cont1) + 0);
				new DAOQuestion().saveQuestionsGame(auxListQuestion.get(mo), tipQuestion);
				auxListQuestion.remove(mo);
				cont1--;
				cont4++;
//			} else if (tipQuestion == 2 && cont5 != (cantQuestion / 3)) {
//				int o = (int) (Math.random() * (cont2) + cont1);
//				new DAOQuestion().saveQuestionsGame(auxListQuestion.get(o), tipQuestion);
//				auxListQuestion.remove(o);
//				cont2--;
//				cont5++;
			} else if (tipQuestion == 2 && cont6 != (cantQuestion / 3)) {
				int tof = (int) (Math.random() * (cont3) + cont2 + cont1);
				new DAOQuestion().saveQuestionsGame(auxListQuestion.get(tof), tipQuestion);
				auxListQuestion.remove(tof);
				cont3--;
				cont6++;
			}

		}

	}

	public ArrayList<Question> getListQuestionGame() {
		ArrayList<Question> Questions = new DAOQuestion().DisplayQuestionGameData();
		return Questions;
	}

	public QuestionMO searchQuestionMO(Question Q) {
		return new DAOQuestion().searchQuestionMO(Q);
	}

//	public QuestionO searchQuestionO(Question Q) {
//		return new DAOQuestion().searchQuestionO(Q);
//	}

	public QuestionTOF searchQuestionTOF(Question Q) {
		return new DAOQuestion().searchQuestionTOF(Q);
	}

	public int validateAnswer(Question Q, String answer) {
		int points = 0;
		if (Q.getID() >= 100 && Q.getID() < 200) {
			points = answer.equalsIgnoreCase(searchQuestionMO(Q).getAnswer()) == true ? Q.getPoints() : 0;
//		} else if (Q.getID() >= 200 && Q.getID() < 300) {
//			points = answer.equalsIgnoreCase(searchQuestionO(Q).getAnswer()) == true ? Q.getPoints() : 0;
		} else if (Q.getID() >= 200) {
			if (answer.toLowerCase().equalsIgnoreCase("v")) {
				answer = "true";
			} else {
				answer = "false";
			}
			points = Boolean.compare(Boolean.parseBoolean(answer), searchQuestionTOF(Q).isAnswer()) == 0 ? Q.getPoints()
					: 0;
		}
		return points;
	}

}
