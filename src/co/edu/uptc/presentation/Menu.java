package co.edu.uptc.presentation;

import java.util.Scanner;

import co.edu.uptc.logic.control.Game;

public class Menu {

	private Game play;

	public Menu() {

		play = new Game();

	}

	public void Console() {
		int op = 0;
		Scanner sc = new Scanner(System.in);

		while (op != 3) {
			System.out.println("[]============= BIENVENIDO AL JUEGO DE PREGUNTAS =============[]\n" + "1. JUGAR \n"
					+ "2. PUNTUACIONES \n" + "3. SALIR");
			op = sc.nextInt();

			switch (op) {
			case 1:
				Play();

				break;
			case 2:

				System.out.println("[]============= PUNTUACIONES =============[]\n[]============= FACIL =============[]\n");

				route(1, play);

				System.out.println("\n[]============= MEDIO =============[]\n");

				route(2, play);
				
				System.out.println("\n[]============= DIFICIL =============[]\n");

				route(3, play);

				break;

			case 3:
				System.out.println("\n[]============= HA SALIDO DEL JUEGO =============[]\n");
				break;

			default:
				System.out.println("\n[]============= ERROR COMANDO INVALIDO =============[]\n");
				break;
			}
		}
	}
	
	public void Play() {
		Scanner sc = new Scanner(System.in);
		String difficult;
		int points = 0;
		String answer = "";
		System.out.println("\n[]============= ¡QUE EMPIEZE EL JUEGO! =============[]\n");
		System.out.println("Escoja la Dificultad (easy, medium, hard)");
		difficult = sc.next();
		play.GenerateQuestionsGame(difficult);

		for (int i = 0; i < play.getListQuestionGame().size(); i++) {
			System.out.println("\n" + (i + 1) + "." + play.getListQuestionGame().get(i).getFormulation());
			if (play.getListQuestionGame().get(i).getID() >= 100
					&& play.getListQuestionGame().get(i).getID() < 200) {
				for (int j = 0; j < play.searchQuestionMO(play.getListQuestionGame().get(i)).getAnswer_options()
						.size(); j++) {
					System.out.println(play.searchQuestionMO(play.getListQuestionGame().get(i))
							.getAnswer_options().get(j));
					System.out.println(play.searchQuestionMO(play.getListQuestionGame().get(i))
							.getPoints());
				}
				
			} 

			else if (play.getListQuestionGame().get(i).getID() >=  300) {
				System.out.println("Verdaero (v)\nFalso (f)");
				
			}
			
			answer = sc.next();
			
			if(play.getListQuestionGame().get(i).getID() >=  300) {
				while(!answer.equalsIgnoreCase("v") && !answer.equalsIgnoreCase("f")) {
					if(!answer.equalsIgnoreCase("v") && !answer.equalsIgnoreCase("f")) {
						System.out.println("LA OPCION ES INVALIDA INTENTE NUEVAMENTE");
						answer = sc.next();
					}
				}
			}
			
			if (play.validateAnswer(play.getListQuestionGame().get(i), answer) != 0) {
				System.out.println("CORRECTO\n");
			} else {
				System.out.println("INCORRECTO\n");
			}
			System.out.println("'" + play.getListQuestionGame().get(i).getExplication() + "'\n\n");
			points = points + play.validateAnswer(play.getListQuestionGame().get(i), answer);
			sc.nextLine();
		}
		System.out.println("Por favor ingrese su nombre");
		answer = sc.next();
		

		play.ScoreRegistration(answer, points, difficult);
		System.out.println("Su puntuacion ha sido registrada");
	}

	public void route(int x, Game play) {
		int cont = 1;
		for (int i = 0; i < play.getListScore().size(); i++) {
			if (play.getListScore().get(i).getID() >= 1000 && play.getListScore().get(i).getID() < 2000 && x == 1) {
				System.out.println(cont + "." + play.getListScore().get(i).getName() + "   "
						+ play.getListScore().get(i).getScore());
				cont++;
			} else if (play.getListScore().get(i).getID() >= 2000 && play.getListScore().get(i).getID() < 3000
					&& x == 2) {
				System.out.println(cont + "." + play.getListScore().get(i).getName() + "   "
						+ play.getListScore().get(i).getScore());
				cont++;
			} else if (play.getListScore().get(i).getID() >= 3000 && x == 3) {
				System.out.println(cont + "." + play.getListScore().get(i).getName() + "   "
						+ play.getListScore().get(i).getScore());
				cont++;
			}
		}
	}

}
