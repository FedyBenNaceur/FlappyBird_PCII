/*Etat  
 * La classe Etat définit une variable hauteur ainsi qu’une méthode d’accès getHauteur et une méthode de modification JUMP.
 *  Cette dernière permet d’augmenter la valeur de la hauteur, 
 *  tout en restant bornée par les dimensions définies dans la classe Affichage .
 */

package Model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.lang.Math;

import javax.swing.JOptionPane;

import Vue.Affichage;

public class Etat {
	private final int x;
	private int hauteur;
	public final int WIDTH_max = 630;
	public final int WIDTH_min = -100;
	public final int HEIGHT_max = 280;
	public final int HEIGHT_min = 150;

	public final int JUMP;// Attribut qui definit la vitesse avec laquelle l'eclipse se deplacer
	private Affichage game;
	public final int DROP;
	public boolean gameEnd = false;

	/* constructeur de la classe Etat */
	public Etat(Affichage a) {
		this.game = a;
		this.x = 20 - (game.WIDTH / 2);
		this.hauteur = (game.HAUTEUR / 2) - (game.HEIGHT / 2);
		DROP = 10;
		JUMP = game.HEIGHT / 2;
	}

	/**
	 * JUMP permet d’augmenter la valeur de la hauteur, tout en restant bornée par
	 * les dimensions définies dans la classe Affichage
	 * 
	 */
	public void jump() {
		if (this.hauteur - JUMP > 0) {
			this.hauteur -= JUMP;
		} else {
			this.hauteur = 0;
		}
	}

	/* retourne la hauteur */
	public int getHauteur() {
		return this.hauteur;
	}

	public int getX() {
		return this.x;
	}

	/**
	 * moveDown methode qui permet de mettre à jour la position du oiseau en le
	 * fesant redescendre
	 */
	public void moveDownn() {
		if ((hauteur + game.HEIGHT) + DROP < game.HAUTEUR) {
			this.hauteur += DROP;
		} else {
			this.hauteur = game.HAUTEUR - game.HEIGHT;
		}
		this.game.revalidate();
		this.game.repaint();
	}
    
	/**
	 * methode qui renvoie les quatres points du rectangel a tester
	 * @return le tableau des points 
	 */
	public Point[] getPolyPoints() {
		Point[] res = new Point[5];
		res[0] = new Point(this.x, this.hauteur);
		res[1] = new Point(this.x + game.WIDTH, this.hauteur);
		res[2] = new Point(this.x + game.WIDTH, this.hauteur + game.HEIGHT);
		res[3] = new Point(this.x, this.hauteur + game.HEIGHT);
		res[4] = new Point(this.x, this.hauteur);
		return res;

	}

	/**
	 * fonction qui teste si la partie est perdue ou pas et alerte l'execution des
	 * threads
	 */

	public void testPerdu() {
		Point[] tmp = game.p.getParcours();
		Point[] polyPoints = getPolyPoints();
		// Rectangle rect1 = new Rectangle(this.x, this.hauteur , this.game.WIDTH,
		// this.game.HEIGHT);
		boolean res = true;
		for (int i = 0; i < game.p.points.size() - 2; i++) {
			for (int j = 0; j < polyPoints.length - 1; j++) {
				Line2D rec = new Line2D.Float(polyPoints[j].x, polyPoints[j].y, polyPoints[j + 1].x,
						polyPoints[j + 1].y);
				Line2D line = new Line2D.Float(tmp[i].x, tmp[i].y, tmp[i + 1].y, tmp[i + 1].y);
				if (line.intersectsLine(rec)) {
					res = false;
					break;
				}
			}
		}

		if (res == true) {
			gameEnd = true;
			JOptionPane.showMessageDialog(game, "Votre socre est : " + game.p.getPosition(), "lost",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
