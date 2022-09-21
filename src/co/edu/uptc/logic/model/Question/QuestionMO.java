package co.edu.uptc.logic.model.Question;

import java.util.ArrayList;

public class QuestionMO extends Question{

	private String answer;
	private ArrayList<String> answer_options;
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public ArrayList<String> getAnswer_options() {
		return answer_options;
	}
	public void setAnswer_options(ArrayList<String> answer_options) {
		this.answer_options = answer_options;
	}
	
	
	
}
