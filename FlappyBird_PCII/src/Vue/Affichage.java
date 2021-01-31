/**class Affichage 
 * La classe Affichage hérite de JPanel.
 *  Elle dispose de :
 *  attribut de type Etat pour accéder à l’état du modèle lorsque l’affichage doit être revu,
 *  via la méthode paint.
 *  attribut de type Control qui permet de notifier la vue des différents changements qui ont lieu.
 *  des attributs LARGEUR ,HAUTEUR , HEIGHT,WIDTH qui définissent la taille des objets à définir
 *  Cette classe gère l'affichage sur l'écran des différentes composantes présentes dans notre jeu

 */

package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Control.Control;
import Model.Etat;
import Model.Parcours;

public class Affichage extends JPanel {
	public final int LARGEUR = 600;// largeur et hauteur correspondent respectivement a la largeur et hauteur de la									// Panel
	public final int HAUTEUR = 400;
	public final int HEIGHT = 60; // Les deux variables height et width représentent les dimensions de l’éclipse
	public final int WIDTH = 20;
	public Etat player;
	public Control c;
	public Parcours p;
	private JLabel score;

	/* constructeur de la classe Affichage */
	public Affichage() {
		this.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
		this.setBackground(Color.cyan);
		this.score = new JLabel("Score	");
		this.add(score);
	
	}

	/**
	 * flyBird dessine l’éclipse qui représente l'oiseau dans le jeu à partir des
	 * coordonnées prédéfinis
	 * 
	 * @param x
	 * @param y
	 * @param largeur :largeur de l'eclipse
	 * @param hauteur : hauteur de l'eclipse
	 * @param g
	 */
	private void flyBird(int x, int y, int largeur, int hauteur, Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(x, y, largeur, hauteur);
	}

	/* Initialise l'attribut player */
	public void initialiseEtat(Etat e) {
		this.player = e;
	}

	/* Initialise l'attribut c */
	public void initialiseControl(Control c) {
		this.c = c;
		this.addMouseListener(this.c);
	}

	/* Initialise Parcours */
	public void initialiseParcours(Parcours p) {
		this.p = p;
	}

	/* Affichage */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		flyBird(player.getX(), player.getHauteur(), WIDTH, HEIGHT, g);
		//g.drawRect(player.getX(), player.getHauteur(), WIDTH, HEIGHT);
		paintParcours(g);
		setScore();
		super.revalidate();
		super.repaint();
	}

	/**
	 * paintParcours Procedure qui permet de peindre la ligne brisée
	 * 
	 * @param g
	 */

	public void paintParcours(Graphics g) {
		Point[] tmp = p.getParcours();

		for (int i = 0; i < p.points.size() - 2; i++) {
			g.setColor(Color.MAGENTA);
			g.drawLine(tmp[i].x, tmp[i].y, tmp[i + 1].x, tmp[i + 1].y);
		}

	}

	/**
	 * setScore methode qui met à jour la valeur du score
	 */
	private void setScore() {
		this.score.setText("Score:" + this.p.getPosition());
	}

}
