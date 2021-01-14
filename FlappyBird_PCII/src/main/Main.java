/*Classe main qui s'occupe de l'instanciation des attributs de Etat Affichage et Controle */
//mailto:thi-thuong-huyen.nguyen@universite-paris-saclay.fr

package main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		Affichage panel = new Affichage();
		Etat e = new Etat(panel);
		Control c = new Control(panel);
		panel.initialiseControl(c);
		panel.initialiseEtat(e);
		JFrame fenetre = new JFrame("flappy birds");
		fenetre.add(panel);
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
