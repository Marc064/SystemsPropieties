package co.edu.uptc.persistence;

import java.util.ArrayList;

import co.edu.uptc.logic.model.Question.Question;
import co.edu.uptc.logic.model.Question.QuestionMO;
import co.edu.uptc.logic.model.Question.QuestionO;
import co.edu.uptc.logic.model.Question.QuestionTOF;
import co.edu.uptc.utilities.Archive;

public class DAOQuestion {

	private String route_one = "Means/QUESTIONS/QuestionsMO.quest";
//	private String route_two = "Means/QUESTIONS/QuestionsO.quest";
	private String route_three = "Means/QUESTIONS/QuestionsTOF.quest";
	private String route_four = "Means/QUESTIONS/QuestionsGame.quest";
	
	
	
	public ArrayList<Question> DisplayQuestionData(){
		ArrayList<String> data1 = new Archive().FileContents(route_one);
//		ArrayList<String> data2 = new Archive().FileContents(route_two);
		ArrayList<String> data3 = new Archive().FileContents(route_three);
		ArrayList<Question> listQuestions = new ArrayList<Question>();
		
		for (int i = 0; i < data1.size(); i++) {
			
			String Line[] = data1.get(i).split("< ");
			QuestionMO q = new QuestionMO();
			ArrayList<String> answer_options = new ArrayList<String>();
			
			q.setID(Integer.parseInt(Line[0]));
			q.setFormulation(Line[1]);
			q.setAnswer(Line[2]);
			answer_options.add(Line[3]);
			answer_options.add(Line[4]);
			answer_options.add(Line[5]);
			answer_options.add(Line[6]);
			q.setAnswer_options(answer_options);
			q.setPoints(Integer.parseInt(Line[7].replace("<", "")));
			q.setExplication(Line[8]);
			
			listQuestions.add(q);
		}
		
//		for (int i = 0; i < data2.size(); i++) {
//			
//			String Line[] = data2.get(i).split("< ");
//			QuestionO q = new QuestionO();
//			
//			q.setID(Integer.parseInt(Line[0]));
//			q.setFormulation(Line[1]);
//			q.setAnswer(Line[2]);
//			q.setPoints(Integer.parseInt(Line[3].replace("<", "")));
//			q.setExplication(Line[4]);
//			
//			listQuestions.add(q);
//		}
		
		for (int i = 0; i < data3.size(); i++) {
			
			String Line[] = data3.get(i).split("< ");
			QuestionTOF q = new QuestionTOF();
			
			q.setID(Integer.parseInt(Line[0]));
			q.setFormulation(Line[1]);
			q.setAnswer(Boolean.parseBoolean(Line[2]));
			q.setPoints(Integer.parseInt(Line[3].replace("<", "")));
			q.setExplication(Line[4]);
			
			listQuestions.add(q);
		}
		
		return listQuestions;
	}
	
	public void saveQuestionsGame(Question Q, int type) {
		
		if(type == 1){
			QuestionMO qmo = searchQuestionMO(Q);
			new Archive().AddContents(route_four, qmo.getID() + "< "
					+ qmo.getFormulation() + "< "
					+ qmo.getAnswer() + "< "
					+ qmo.getAnswer_options().get(0) + "< "
					+ qmo.getAnswer_options().get(1) + "< "
					+ qmo.getAnswer_options().get(2) + "< "
					+ qmo.getAnswer_options().get(3) + "< "
					+ qmo.getPoints() + "< "
					+ qmo.getExplication());
		}
//		else if(type == 2) {
//			QuestionO qo = searchQuestionO(Q);
//			new Archive().AddContents(route_four, qo.getID() + "< "
//					+ qo.getFormulation() + "< "
//					+ qo.getAnswer() + "< "
//					+ qo.getPoints() + "< "
//					+ qo.getExplication());
//		}
		else if(type == 2) {
			QuestionTOF qtof = searchQuestionTOF(Q);
			new Archive().AddContents(route_four, qtof.getID() + "< "
					+ qtof.getFormulation() + "< "
					+ qtof.isAnswer() + "< "
					+ qtof.getPoints() + "< "
					+ qtof.getExplication());
		}
	}
	
	public QuestionMO searchQuestionMO(Question q) {
		ArrayList<String> data1 = new Archive().FileContents(route_one);
		QuestionMO qmo = new QuestionMO();
		for (int i = 0; i < data1.size(); i++) {
			
			String Line[] = data1.get(i).split("< ");
			if(Integer.parseInt(Line[0])==q.getID()) {
				ArrayList<String> answer_options = new ArrayList<String>();
				qmo.setID(Integer.parseInt(Line[0]));
				qmo.setFormulation(Line[1]);
				qmo.setAnswer(Line[2]);
				answer_options.add(Line[3]);
				answer_options.add(Line[4]);
				answer_options.add(Line[5]);
				answer_options.add(Line[6]);
				qmo.setAnswer_options(answer_options);
				qmo.setPoints(Integer.parseInt(Line[7].replace("<", "")));
				qmo.setExplication(Line[8].replace(";", ""));
				return qmo;
			}
		}
		return qmo;
	}
	
	
	
//	public QuestionO searchQuestionO(Question q) {
//		ArrayList<String> data1 = new Archive().FileContents(route_two);
//		QuestionO qo = new QuestionO();
//		for (int i = 0; i < data1.size(); i++) {
//			
//			String Line[] = data1.get(i).split("< ");
//			if(Integer.parseInt(Line[0])==q.getID()) {
//				qo.setID(Integer.parseInt(Line[0]));
//				qo.setFormulation(Line[1]);
//				qo.setAnswer(Line[2]);
//				qo.setPoints(Integer.parseInt(Line[3].replace("<", "")));
//				qo.setExplication(Line[4].replace(";", ""));
//				return qo;
//			}
//		}
//		return qo;
//	}
	
	public QuestionTOF searchQuestionTOF(Question q) {
		ArrayList<String> data1 = new Archive().FileContents(route_three);
		QuestionTOF qtof = new QuestionTOF();
		for (int i = 0; i < data1.size(); i++) {
			
			String Line[] = data1.get(i).split("< ");
			if(Integer.parseInt(Line[0])==q.getID()) {
				qtof.setID(Integer.parseInt(Line[0]));
				qtof.setFormulation(Line[1]);
				qtof.setAnswer(Boolean.parseBoolean(Line[2]));
				qtof.setPoints(Integer.parseInt(Line[3].replace("<", "")));
				qtof.setExplication(Line[4].replace(";", ""));
				return qtof;
			}
		}
		return qtof;
	}
	
	public void resetQuestionGame() {
		
		new Archive().resetArchive(route_four);
		
	}
	
	public ArrayList<Question> DisplayQuestionGameData(){
		ArrayList<String> data = new Archive().FileContents(route_four);
		ArrayList<Question> listQuestions = new ArrayList<Question>();
		
		for (int i = 0; i < data.size(); i++) {
			String Line[] = data.get(i).split("< ");
			
			if(Integer.parseInt(Line[0])>=100 && Integer.parseInt(Line[0])<200) {
				QuestionMO q = new QuestionMO();
				ArrayList<String> answer_options = new ArrayList<String>();
				q.setID(Integer.parseInt(Line[0]));
				q.setFormulation(Line[1]);
				q.setAnswer(Line[2]);
				answer_options.add(Line[3]);
				answer_options.add(Line[4]);
				answer_options.add(Line[5]);
				answer_options.add(Line[6]);
				q.setAnswer_options(answer_options);
				q.setPoints(Integer.parseInt(Line[7].replace("<", "")));
				q.setExplication(Line[8]);
				listQuestions.add(q);
			}
			else if(Integer.parseInt(Line[0])>=200 && Integer.parseInt(Line[0])<300) {
				QuestionO q = new QuestionO();
				q.setID(Integer.parseInt(Line[0]));
				q.setFormulation(Line[1]);
				q.setAnswer(Line[2]);
				q.setPoints(Integer.parseInt(Line[3].replace("<", "")));
				q.setExplication(Line[4]);
				listQuestions.add(q);
			}
			else if(Integer.parseInt(Line[0])>=300) {
				QuestionTOF q = new QuestionTOF();
				q.setID(Integer.parseInt(Line[0]));
				q.setFormulation(Line[1]);
				q.setAnswer(Boolean.parseBoolean(Line[2]));
				q.setPoints(Integer.parseInt(Line[3].replace("<", "")));
				q.setExplication(Line[4]);
				listQuestions.add(q);
			}
			
		}
		return listQuestions;
		
	}
	
}
