/* Classe main qui s'occupe de l'instanciation */
//mailto:thi-thuong-huyen.nguyen@universite-paris-saclay.fr

package main;

import javax.swing.JFrame;

import Control.Avancer;
import Control.Control;
import Control.Voler;
import Model.Etat;
import Model.Parcours;
import Vue.Affichage;

public class Main {
	public static void main(String[] args) {
		Affichage panel = new Affichage();
		
		Control c = new Control(panel);						
		Etat e = new Etat(panel);
		panel.initialiseEtat(e);
		Parcours p = new Parcours(panel);
		panel.initialiseParcours(p);	
		panel.initialiseControl(c);		
		JFrame fenetre = new JFrame("flappy birds");
		fenetre.add(panel);
		(new Voler(e)).start();
		(new Avancer(panel)).start();
	    fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
