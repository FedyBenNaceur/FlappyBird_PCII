/**class Affichage 
 * La classe Affichage h�rite de JPanel.
 *  Elle dispose de :
 *  attribut de type Etat pour acc�der � l��tat du mod�le lorsque l�affichage doit �tre revu,
 *  via la m�thode paint.
 *  attribut de type Control qui permet de notifier la vue des diff�rents changements qui ont lieu.
 *  des attributs LARGEUR ,HAUTEUR , HEIGHT,WIDTH qui d�finissent la taille des objets � d�finir
 *  Cette classe g�re l'affichage sur l'�cran des diff�rentes composantes pr�sentes dans notre jeu

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
	public final int HEIGHT = 60; // Les deux variables height et width repr�sentent les dimensions de l��clipse
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
	 * flyBird dessine l��clipse qui repr�sente l'oiseau dans le jeu � partir des
	 * coordonn�es pr�d�finis
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
	 * paintParcours Procedure qui permet de peindre la ligne bris�e
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
	 * setScore methode qui met � jour la valeur du score
	 */
	private void setScore() {
		this.score.setText("Score:" + this.p.getPosition());
	}

}
