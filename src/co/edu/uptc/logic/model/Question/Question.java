package co.edu.uptc.logic.model.Question;


public class Question {

	private int ID;
	private String formulation;
	private int points;
	private String explication;
	
	public String getFormulation() {
		return formulation;
	}
	public void setFormulation(String formulation) {
		this.formulation = formulation;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getExplication() {
		return explication;
	}
	public void setExplication(String explication) {
		this.explication = explication;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	
}
