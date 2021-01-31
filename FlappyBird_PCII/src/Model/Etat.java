/*Etat  
 * La classe Etat définit une variable hauteur ainsi qu’une méthode d’accès getHauteur et une méthode de modification JUMP.
 *  Cette dernière permet d’augmenter la valeur de la hauteur, 
 *  tout en restant bornée par les dimensions définies dans la classe Affichage .
 */

package Model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.lang.Math;

import javax.swing.JOptionPane;

import Vue.Affichage;

public class Etat {
	private final int x;
	private int hauteur;
	public final int WIDTH_max = 630 ;
	public final int WIDTH_min = -100 ;
	public final int HEIGHT_max = 280 ;
	public final int HEIGHT_min = 150 ;
	
	public final int JUMP ;// Attribut qui definit la vitesse avec laquelle l'eclipse se deplacer
	private Affichage game;
	public final int DROP ;
	public boolean gameEnd = false;

	/* constructeur de la classe Etat */
	public Etat(Affichage a) {
		this.game = a;
		this.x = 20 - (game.WIDTH / 2);
		this.hauteur = (game.HAUTEUR /2) - (game.HEIGHT / 2);
		DROP = 10 ;
		JUMP = game.HEIGHT/2 ;
	}

	/**
	 * JUMP permet d’augmenter la valeur de la hauteur, tout en restant bornée par
	 * les dimensions définies dans la classe Affichage
	 * 
	 */
	public void jump() {
		if (this.hauteur-JUMP > 0) {
			this.hauteur -= JUMP;
		}else {
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
		if ((hauteur + game.HEIGHT)+DROP < game.HAUTEUR) {
			this.hauteur += DROP;
		}
		else {
			this.hauteur = game.HAUTEUR-game.HEIGHT ;
		}
		this.game.revalidate();
		this.game.repaint();
	}

	/**
	 * fonction qui teste si la partie est perdue ou pas et alerte l'execution des threads  
	 */
	public void testPerdu() {
	    Point[] tmp = game.p.getParcours();
		Rectangle rect1 = new Rectangle(this.x, this.hauteur , this.game.WIDTH, this.game.HEIGHT);
		boolean res = true ;
		for(int i = 0 ;i<game.p.points.size()-2;i++) {
			Line2D line2 = new Line2D.Float(tmp[i].x,tmp[i].y,tmp[i+1].y,tmp[i+1].y);
			if (line2.intersects(rect1)) {
				res = false  ; 
				break ;
			}
		}
		if (res == true ) {
			gameEnd = true ;
			JOptionPane.showMessageDialog(game, "Votre socre est : " + game.p.getPosition(), 
			      "lost", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
}
	

