package co.edu.uptc.presentation.Gui;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

import co.edu.uptc.logic.control.Game;
/**
 * @author Marco Antonio Vargas Garcia & Miguel Angel Alfonso Saavedra
 * @version 1.0
 */
public class GUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -7631358823389667283L;
	private Font italic = new Font("Comic Sans MS Italic", Font.ITALIC, 30);
	private Font italic_Dif = new Font("Comic Sans MS Italic", Font.ITALIC, 25);
	private Font italic_ques = new Font("Comic Sans MS Italic", Font.ITALIC, 50);
	private Font italic_over = new Font("Comic Sans MS Italic", Font.ITALIC, 70);
	private ImageIcon exitButton = new ImageIcon("src/Resource/Buttons/exit_Button.png");
	private ImageIcon rankedButton = new ImageIcon("src/Resource/Buttons/ranked_Button.png");
	private ImageIcon playButton = new ImageIcon("src/Resource/Buttons/play_Button.png");
	private ImageIcon easyButton = new ImageIcon("src/Resource/Buttons/easy_Button.png");
	private ImageIcon midButton = new ImageIcon("src/Resource/Buttons/mid_Button.png");
	private ImageIcon hardButton = new ImageIcon("src/Resource/Buttons/hard_Button.png");
	private ImageIcon nextButton = new ImageIcon("src/Resource/Buttons/next_Button.png");
	private ImageIcon homeButton = new ImageIcon("src/Resource/Buttons/home_Button.png");
	private ImageIcon logo = new ImageIcon("src/Resource/Desktop/logo.png");
	private Image fondo;
	private URL fon;
	private Container con;
	private JButton exit;
	private JButton play;
	private JButton ranked;
	private JButton easy;
	private JButton mid;
	private JButton hard;
	private JButton next;
	private JButton nextTF;
	private JButton desk;
	private JTextArea rankEasy;
	private JTextArea rankHard;
	private JTextArea rankMid;
	private JTextArea quest;
	private JTextArea score;
	private JTextArea end;
	private JRadioButton option1;
	private JRadioButton option2;
	private JRadioButton option3;
	private JRadioButton option4;
	private ButtonGroup options;
	private JRadioButton optionTr;
	private JRadioButton optionFs;
	private ButtonGroup optionsToF;
	private Game start;
	private byte cont;
	private int points;
	private String difficult;
	
	public GUI() {
		con = getContentPane();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setIconImage(logo.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		con.add(Home());
		start = new Game();
	}

	private JPanel Home() {
		fon = this.getClass().getResource("/Resource/Backgraund/PRINCIPAL.png");
		fondo = new ImageIcon(fon).getImage();
		JPanel principal = new JPanel() {
			private static final long serialVersionUID = -858521380093130531L;

			@Override
			public void paint(Graphics g) {
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
				setOpaque(false);
				super.paint(g);
			}
		};

		play = new JButton("Jugar");
		play.setFont(italic);
		play.setBounds(100, 50, 200, 180);
		Icon pl = new ImageIcon(
				playButton.getImage().getScaledInstance(play.getWidth(), play.getHeight(), Image.SCALE_DEFAULT));
		play.setIcon(pl);
		play.setContentAreaFilled(false);
		play.setHorizontalTextPosition(SwingConstants.CENTER);
		play.setBorderPainted(false);
		play.addActionListener(this);

		ranked = new JButton("Ranking");
		ranked.setFont(italic);
		ranked.setBounds(100, 290, 200, 180);
		Icon ra = new ImageIcon(
				rankedButton.getImage().getScaledInstance(ranked.getWidth(), ranked.getHeight(), Image.SCALE_DEFAULT));
		ranked.setIcon(ra);
		ranked.setContentAreaFilled(false);
		ranked.setHorizontalTextPosition(SwingConstants.CENTER);
		ranked.setBorderPainted(false);
		ranked.addActionListener(this);

		exit = new JButton("Salir");
		exit.setFont(italic);
		exit.setBounds(100, 530, 200, 180);
		Icon ex = new ImageIcon(
				exitButton.getImage().getScaledInstance(exit.getWidth(), exit.getHeight(), Image.SCALE_DEFAULT));
		exit.setIcon(ex);
		exit.setContentAreaFilled(false);
		exit.setHorizontalTextPosition(SwingConstants.CENTER);
		exit.setBorderPainted(false);
		exit.addActionListener(this);

		principal.setLayout(null);
		principal.add(play);
		principal.add(ranked);
		principal.add(exit);

		return principal;
	}

	private JPanel Records() {
	
		fon = this.getClass().getResource("/Resource/Backgraund/RANKED.png");
		fondo = new ImageIcon(fon).getImage();
		JPanel principal = new JPanel() {
			
			private static final long serialVersionUID = -3633438765604253923L;

			@Override
			public void paint(Graphics g) {
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
				setOpaque(false);
				super.paint(g);
			}
		};

		play = new JButton("Jugar");
		play.setFont(italic);
		play.setBounds(100, 50, 200, 180);
		Icon pl = new ImageIcon(
				playButton.getImage().getScaledInstance(play.getWidth(), play.getHeight(), Image.SCALE_DEFAULT));
		play.setIcon(pl);
		play.setContentAreaFilled(false);
		play.setHorizontalTextPosition(SwingConstants.CENTER);
		play.setBorderPainted(false);
		play.addActionListener(this);

		ranked = new JButton("Ranking");
		ranked.setFont(italic);
		ranked.setBounds(100, 290, 200, 180);
		Icon ra = new ImageIcon(
				rankedButton.getImage().getScaledInstance(ranked.getWidth(), ranked.getHeight(), Image.SCALE_DEFAULT));
		ranked.setIcon(ra);
		ranked.setContentAreaFilled(false);
		ranked.setHorizontalTextPosition(SwingConstants.CENTER);
		ranked.setBorderPainted(false);
		ranked.addActionListener(this);

		exit = new JButton("Salir");
		exit.setFont(italic);
		exit.setBounds(100, 530, 200, 180);
		Icon ex = new ImageIcon(
				exitButton.getImage().getScaledInstance(exit.getWidth(), exit.getHeight(), Image.SCALE_DEFAULT));
		exit.setIcon(ex);
		exit.setContentAreaFilled(false);
		exit.setHorizontalTextPosition(SwingConstants.CENTER);
		exit.setBorderPainted(false);
		exit.addActionListener(this);
		
		rankEasy = new JTextArea("");
		rankEasy.setBounds(460, 310, 230, 430);
		rankEasy.setEditable(false);
		rankEasy.setFont(italic_ques);
		rankEasy.setOpaque(false);
		route(1, start);
		rankEasy.setLineWrap(true);
		rankEasy.setWrapStyleWord(true);
		
		rankMid = new JTextArea("");
		rankMid.setBounds(760, 310, 230, 430);
		rankMid.setEditable(false);
		rankMid.setFont(italic_ques);
		rankMid.setOpaque(false);
		route(2, start);
		rankMid.setLineWrap(true);
		rankMid.setWrapStyleWord(true);
		
		rankHard = new JTextArea("");
		rankHard.setBounds(1063, 310, 230, 430);
		rankHard.setEditable(false);
		rankHard.setFont(italic_ques);
		rankHard.setOpaque(false);
		route(3, start);
		rankHard.setLineWrap(true);
		rankHard.setWrapStyleWord(true);
		
		principal.setLayout(null);
		principal.add(play);
		principal.add(ranked);
		principal.add(exit);
		principal.add(rankEasy);
		principal.add(rankMid);
		principal.add(rankHard);

		return principal;
	}

	private JPanel Difficult() {
		fon = this.getClass().getResource("/Resource/Backgraund/DIFFICULTY.png");
		fondo = new ImageIcon(fon).getImage();
		JPanel principal = new JPanel() {
			
			private static final long serialVersionUID = -5983188473676001366L;

			@Override
			public void paint(Graphics g) {
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
				setOpaque(false);
				super.paint(g);
			}
		};

		play = new JButton("Jugar");
		play.setFont(italic);
		play.setBounds(100, 50, 200, 180);
		Icon pl = new ImageIcon(
				playButton.getImage().getScaledInstance(play.getWidth(), play.getHeight(), Image.SCALE_DEFAULT));
		play.setIcon(pl);
		play.setContentAreaFilled(false);
		play.setHorizontalTextPosition(SwingConstants.CENTER);
		play.setBorderPainted(false);
		play.addActionListener(this);

		ranked = new JButton("Ranking");
		ranked.setFont(italic);
		ranked.setBounds(100, 290, 200, 180);
		Icon ra = new ImageIcon(
				rankedButton.getImage().getScaledInstance(ranked.getWidth(), ranked.getHeight(), Image.SCALE_DEFAULT));
		ranked.setIcon(ra);
		ranked.setContentAreaFilled(false);
		ranked.setHorizontalTextPosition(SwingConstants.CENTER);
		ranked.setBorderPainted(false);
		ranked.addActionListener(this);

		exit = new JButton("Salir");
		exit.setFont(italic);
		exit.setBounds(100, 530, 200, 180);
		Icon ex = new ImageIcon(
				exitButton.getImage().getScaledInstance(exit.getWidth(), exit.getHeight(), Image.SCALE_DEFAULT));
		exit.setIcon(ex);
		exit.setContentAreaFilled(false);
		exit.setHorizontalTextPosition(SwingConstants.CENTER);
		exit.setBorderPainted(false);
		exit.addActionListener(this);

		easy = new JButton("Facil");
		easy.setFont(italic_Dif);
		easy.setBounds(490, 360, 200, 180);
		Icon es = new ImageIcon(
				easyButton.getImage().getScaledInstance(easy.getWidth(), easy.getHeight(), Image.SCALE_DEFAULT));
		easy.setIcon(es);
		easy.setContentAreaFilled(false);
		easy.setHorizontalTextPosition(SwingConstants.CENTER);
		easy.setBorderPainted(false);
		easy.addActionListener(this);

		mid = new JButton("Medio");
		mid.setFont(italic_Dif);
		mid.setBounds(800, 360, 200, 180);
		Icon mi = new ImageIcon(
				midButton.getImage().getScaledInstance(mid.getWidth(), mid.getHeight(), Image.SCALE_DEFAULT));
		mid.setIcon(mi);
		mid.setContentAreaFilled(false);
		mid.setHorizontalTextPosition(SwingConstants.CENTER);
		mid.setBorderPainted(false);
		mid.addActionListener(this);

		hard = new JButton("Dificil");
		hard.setFont(italic_Dif);
		hard.setBounds(1100, 360, 200, 180);
		hard.setHorizontalTextPosition(SwingConstants.CENTER);
		Icon ha = new ImageIcon(
				hardButton.getImage().getScaledInstance(hard.getWidth(), hard.getHeight(), Image.SCALE_DEFAULT));
		hard.setIcon(ha);
		hard.setContentAreaFilled(false);
		hard.setBorderPainted(false);
		hard.addActionListener(this);

		principal.setLayout(null);
		principal.add(play);
		principal.add(ranked);
		principal.add(exit);
		principal.add(easy);
		principal.add(mid);
		principal.add(hard);

		return principal;
	}

	private JPanel Question() {
		fon = this.getClass().getResource("/Resource/Backgraund/BASE.png");
		fondo = new ImageIcon(fon).getImage();
		JPanel principal = new JPanel() {
			
			private static final long serialVersionUID = -8481276487189921374L;

			@Override
			public void paint(Graphics g) {
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
				setOpaque(false);
				super.paint(g);
			}
		};

		score = new JTextArea("Puntaje\n" + points);
		score.setFont(italic_ques);
		score.setBounds(110, 250, 300, 200);
		score.setOpaque(false);
		score.setEditable(false);

		quest = new JTextArea();
		quest.setFont(italic_ques);
		quest.setBounds(400, 40, 930, 300);
		quest.setLineWrap(true);
		quest.setWrapStyleWord(true);
		quest.setOpaque(false);
		quest.setEditable(false);

		option1 = new JRadioButton("Opcion 1");
		option1.setFont(italic_Dif);
		option1.setBounds(400, 370, 800, 100);
		option1.setOpaque(false);

		option2 = new JRadioButton("Opcion 2");
		option2.setFont(italic_Dif);
		option2.setBounds(400, 450, 800, 100);
		option2.setOpaque(false);

		option3 = new JRadioButton("Opcion 3");
		option3.setFont(italic_Dif);
		option3.setBounds(400, 530, 800, 100);
		option3.setOpaque(false);

		option4 = new JRadioButton("Opcion 4");
		option4.setFont(italic_Dif);
		option4.setBounds(400, 610, 800, 100);
		option4.setOpaque(false);
		
		options = new ButtonGroup();
		options.add(option1);
		options.add(option2);
		options.add(option3);
		options.add(option4);
		
		next = new JButton();
		next.setBounds(1200, 630, 150, 70);
		Icon ne = new ImageIcon(
				nextButton.getImage().getScaledInstance(next.getWidth(), next.getHeight(), Image.SCALE_DEFAULT));
		next.setIcon(ne);
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
		next.addActionListener(this);

		principal.setLayout(null);
		principal.add(score);
		principal.add(quest);
		principal.add(option1);
		principal.add(option2);
		principal.add(option3);
		principal.add(option4);
		principal.add(next);

		return principal;
	}
	
	private JPanel QuestionToF() {
		fon = this.getClass().getResource("/Resource/Backgraund/BASE.png");
		fondo = new ImageIcon(fon).getImage();
		JPanel principal = new JPanel() {
			

			/**
			 * 
			 */
			private static final long serialVersionUID = -821870464613219023L;

			@Override
			public void paint(Graphics g) {
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
				setOpaque(false);
				super.paint(g);
			}
		};

		score = new JTextArea("Puntaje\n" + points);
		score.setFont(italic_ques);
		score.setBounds(110, 250, 300, 200);
		score.setOpaque(false);
		score.setEditable(false);

		quest = new JTextArea();
		quest.setFont(italic_ques);
		quest.setBounds(400, 40, 930, 300);
		quest.setLineWrap(true);
		quest.setWrapStyleWord(true);
		quest.setOpaque(false);
		quest.setEditable(false);

		optionTr = new JRadioButton("Verdadero");
		optionTr.setFont(italic_Dif);
		optionTr.setBounds(400, 450, 800, 100);
		optionTr.setOpaque(false);

		optionFs = new JRadioButton("Falso");
		optionFs.setFont(italic_Dif);
		optionFs.setBounds(400, 530, 800, 100);
		optionFs.setOpaque(false);
		
		optionsToF = new ButtonGroup();
		optionsToF.add(optionTr);
		optionsToF.add(optionFs);
		
		nextTF = new JButton();
		nextTF.setBounds(1200, 630, 150, 70);
		Icon ne = new ImageIcon(
				nextButton.getImage().getScaledInstance(nextTF.getWidth(), nextTF.getHeight(), Image.SCALE_DEFAULT));
		nextTF.setIcon(ne);
		nextTF.setContentAreaFilled(false);
		nextTF.setBorderPainted(false);
		nextTF.addActionListener(this);

		principal.setLayout(null);
		principal.add(score);
		principal.add(quest);
		principal.add(optionTr);
		principal.add(optionFs);
		principal.add(nextTF);

		return principal;
	}

	private JPanel GameOver() {
		fon = this.getClass().getResource("/Resource/Backgraund/BASE.png");
		fondo = new ImageIcon(fon).getImage();
		JPanel principal = new JPanel() {
			
			private static final long serialVersionUID = -821870464613219023L;

			@Override
			public void paint(Graphics g) {
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
				setOpaque(false);
				super.paint(g);
			}
		};
		
		desk = new JButton("Inicio");
		
		desk.setFont(italic);
		desk.setBounds(100, 290, 200, 180);
		Icon de = new ImageIcon(
				homeButton.getImage().getScaledInstance(desk.getWidth(), desk.getHeight(), Image.SCALE_DEFAULT));
		desk.setIcon(de);
		desk.setContentAreaFilled(false);
		desk.setHorizontalTextPosition(SwingConstants.CENTER);
		desk.setBorderPainted(false);
		desk.addActionListener(this);
		
		end = new JTextArea("Fin del Juego\n" + points);
		end.setFont(italic_over);
		end.setBounds(600, 250, 500, 300);
		end.setLineWrap(true);
		end.setWrapStyleWord(true);
		end.setOpaque(false);
		end.setEditable(false);
		
		principal.setLayout(null);
		principal.add(desk);
		principal.add(end);
		return principal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object fuente = e.getSource();

		if (fuente == exit) {
			System.exit(ABORT);
		}

		if (fuente == ranked) {
			con.removeAll();
			con.add(Records());
			setVisible(true);
			
		}

		if (fuente == play) {
			con.removeAll();
			con.add(Difficult());
			setVisible(true);
		}

		if (fuente == easy) {
			cont = 1;
			difficult = "easy";
			start.GenerateQuestionsGame(difficult);
			con.removeAll();
			changeQuestion();
		}

		if (fuente == mid) {
			cont = 1;
			difficult = "medium";
			start.GenerateQuestionsGame(difficult);
			con.removeAll();
			changeQuestion();
		}

		if (fuente == hard) {
			cont = 1;
			difficult = "hard";
			start.GenerateQuestionsGame(difficult);
			con.removeAll();
			changeQuestion();
		}

		if (fuente == next) {			
			
			if (option1.isSelected()) {
				if (start.validateAnswer(start.getListQuestionGame().get(cont-1), "a") == 0) {
					JOptionPane.showMessageDialog(null, start.getListQuestionGame().get(cont-1).getExplication(), "Incorrecto" , JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, start.getListQuestionGame().get(cont-1).getExplication(), "Correcto" , JOptionPane.INFORMATION_MESSAGE);
				}
				 
				points = points + start.validateAnswer(start.getListQuestionGame().get(cont-1), "a");
				cont++;

			}
			if (option2.isSelected()) {
				if (start.validateAnswer(start.getListQuestionGame().get(cont-1), "b") == 0) {
					JOptionPane.showMessageDialog(null, start.getListQuestionGame().get(cont-1).getExplication(), "Incorrecto" , JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, start.getListQuestionGame().get(cont-1).getExplication(), "Correcto" , JOptionPane.INFORMATION_MESSAGE);
				}
				points = points + start.validateAnswer(start.getListQuestionGame().get(cont-1), "b");
				cont++;

			}
			if (option3.isSelected()) {
				if (start.validateAnswer(start.getListQuestionGame().get(cont-1), "c") == 0) {
					JOptionPane.showMessageDialog(null, start.getListQuestionGame().get(cont-1).getExplication(), "Incorrecto" , JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, start.getListQuestionGame().get(cont-1).getExplication(), "Correcto" , JOptionPane.INFORMATION_MESSAGE);
				}
				points = points + start.validateAnswer(start.getListQuestionGame().get(cont-1), "c");
				cont++;

			}
			if (option4.isSelected()) {
				
				if (start.validateAnswer(start.getListQuestionGame().get(cont-1), "d") == 0) {
					JOptionPane.showMessageDialog(null, start.getListQuestionGame().get(cont-1).getExplication(), "Incorrecto" , JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, start.getListQuestionGame().get(cont-1).getExplication(), "Correcto" , JOptionPane.INFORMATION_MESSAGE);
				}
				points = points + start.validateAnswer(start.getListQuestionGame().get(cont-1), "d");
				cont++;


			}
			changeQuestion();
		}
		
		if ((fuente == nextTF)) {
			
			if (optionTr.isSelected()) {
				if (start.validateAnswer(start.getListQuestionGame().get(cont-1), "v") == 0) {
					JOptionPane.showMessageDialog(null, start.getListQuestionGame().get(cont-1).getExplication(), "Incorrecto" , JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, start.getListQuestionGame().get(cont-1).getExplication(), "Correcto" , JOptionPane.INFORMATION_MESSAGE);
				}
				points = points + start.validateAnswer(start.getListQuestionGame().get(cont-1), "v");
				cont++;

			}
			if (optionFs.isSelected()) {
				if (start.validateAnswer(start.getListQuestionGame().get(cont-1), "f") == 0) {
					JOptionPane.showMessageDialog(null, start.getListQuestionGame().get(cont-1).getExplication(), "Incorrecto" , JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, start.getListQuestionGame().get(cont-1).getExplication(), "Correcto" , JOptionPane.INFORMATION_MESSAGE);
				}
				points = points + start.validateAnswer(start.getListQuestionGame().get(cont-1), "f");
				cont++;

			}
			
			changeQuestion();
		}
		
		if (fuente == desk) {
			con.removeAll();
			con.add(Home());
			setVisible(true);
		}
	}
	
	private void name () {
		String nm = "";
		while( true ) {
			nm = JOptionPane.showInputDialog(null,"Ingrese su nombre", "Fin del Juego", JOptionPane.QUESTION_MESSAGE);
			
			if (nm != null && !nm.isEmpty()) {
					start.ScoreRegistration(nm, points, difficult);
				break;
				}
			}
		}
	
	private void route(int x, Game start) {
		int con = 1;
		for (int i = 0; i < start.getListScore().size(); i++) {
			if (start.getListScore().get(i).getID() >= 1000 && start.getListScore().get(i).getID() < 2000 && x == 1) {
				String letras = (con + "." + start.getListScore().get(i).getName() + " "
						+ start.getListScore().get(i).getScore()+"\n");
				rankEasy.append(letras);
				con++;
			} else if (start.getListScore().get(i).getID() >= 2000 && start.getListScore().get(i).getID() < 3000
					&& x == 2) {
				String letras = (con + "." + start.getListScore().get(i).getName() + " "
						+ start.getListScore().get(i).getScore()+"\n");
				rankMid.append(letras);
				con++;
			} else if (start.getListScore().get(i).getID() >= 3000 && x == 3) {
				String letras = (con + "." + start.getListScore().get(i).getName() + " "
						+ start.getListScore().get(i).getScore()+"\n");
				rankHard.append(letras);
				con++;
			}
			
		}
	}
	
	private void changeQuestion() {
		
		if (cont <= start.getListQuestionGame().size()) {
			if (start.getListQuestionGame().get(cont-1).getID() >= 100
					&& start.getListQuestionGame().get(cont-1).getID() < 200) {
				con.removeAll();
				con.add(Question());
				
				quest.setText((cont) + "." + start.getListQuestionGame().get(cont-1).getFormulation());
				
				option1.setText(start.searchQuestionMO(start.getListQuestionGame().get(cont-1))
								.getAnswer_options().get(0));
				option2.setText(start.searchQuestionMO(start.getListQuestionGame().get(cont-1))
						.getAnswer_options().get(1));
				option3.setText(start.searchQuestionMO(start.getListQuestionGame().get(cont-1))
						.getAnswer_options().get(2));
				option4.setText(start.searchQuestionMO(start.getListQuestionGame().get(cont-1))
						.getAnswer_options().get(3));
				setVisible(true);
			
			}else if (start.getListQuestionGame().get(cont-1).getID() >=  200) {
				
				con.removeAll();
				con.add(QuestionToF());
				
				quest.setText((cont) + "." + start.getListQuestionGame().get(cont-1).getFormulation());
				
				setVisible(true);
			}
		}else {
			con.removeAll();
			con.add(GameOver());
			name();
		}
	}
	

}