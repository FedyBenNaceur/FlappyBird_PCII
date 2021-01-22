/* Classe main qui s'occupe de l'instanciation */
//mailto:thi-thuong-huyen.nguyen@universite-paris-saclay.fr

package main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		Affichage panel = new Affichage();
		Etat e = new Etat(panel);
		Control c = new Control(panel);
		(new Voler(e)).start();
		panel.initialiseControl(c);
		panel.initialiseEtat(e);
		Parcours p = new Parcours(panel);
		panel.initialiseParcours(p);
		(new Avancer(panel)).start();
		JFrame fenetre = new JFrame("flappy birds");
		fenetre.add(panel);
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
