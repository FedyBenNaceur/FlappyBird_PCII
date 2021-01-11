/*Etat 
 * La classe Etat d�finit une variable hauteur ainsi qu�une m�thode d�acc�s getHauteur et une m�thode de modification jump.
 *  Cette derni�re permet d�augmenter la valeur de la hauteur, 
 *  tout en restant born�e par les dimensions d�finies dans la classe Affichage.
 */

package main;

public class Etat {
	private int x;
	private int hauteur;
	private final int Speed = 20; // Attribut qui definit la vitesse avec laquelle l'eclipse se deplace
	private Affichage game;

	/* constructeur de la classe Etat */
	public Etat(Affichage a) {
		this.x = 10;
		this.game = a;
		this.hauteur = game.HAUTEUR - a.HEIGHT;

	}

	/**
	 * jump permet d�augmenter la valeur de la hauteur, tout en restant born�e par
	 * les dimensions d�finies dans la classe Affichage
	 * 
	 */
	public void jump() {
		if (this.hauteur > 0) {
			this.hauteur -= Speed;
		}
	}
    /*retourne la hauteur */
	public int getHauteur() {
		return this.hauteur;
	}

	public int getX() {
		return this.x;
	}

}
