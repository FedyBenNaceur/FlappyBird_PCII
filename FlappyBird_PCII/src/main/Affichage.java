/**class Affichage 
 * La classe Affichage hérite de JPanel.
 *  Elle dispose de :
 *  attribut de type Etat pour accéder à l’état du modèle lorsque l’affichage doit être revu,
 *  via la méthode paint.
 *  attribut de type Control qui permet de notifier la vue des différents changements qui ont lieu.
 *  des attributs LARGEUR ,HAUTEUR , HEIGHT,WIDTH qui définissent la taille des objets à définir
 *  Cette classe gère l'affichage sur l'écran des différentes composantes présentes dans notre jeu

 */

package main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Affichage extends JPanel {
	public final int LARGEUR = 600;//largeur et hauteur correspondent respectivement a la largeur et hauteur de la Panel
	public final int HAUTEUR = 400;
	public final int HEIGHT=100; //Les deux variables height et width représentent les dimensions de l’éclipse
	public final int WIDTH=50;
	public Etat player;
	public Control c ;
	
    /*constructeur de la classe Affichage*/
	public Affichage() {
		this.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));	
	}
	
    /**flyBird
     *  dessine l’éclipse qui représente l'oiseau dans le jeu à partir des coordonnées prédéfinis
     * @param x 
     * @param y
     * @param largeur :largeur de l'eclipse 
     * @param hauteur : hauteur de l'eclipse 
     * @param g
     */
	private void flyBird(int x, int y, int largeur, int hauteur, Graphics g) {
		g.drawOval(x, y, largeur, hauteur);
	}
	/*Initialise l'attribut player */
	public void initialiseEtat(Etat e ) {
		this.player = e ;
	}
	
	/*Initialise l'attribut c */
	public void initialiseControl(Control c ) {
		this.c = c;
		this.addMouseListener(this.c);
	}
    /*Affichage*/
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		flyBird(player.getX(), player.getHauteur(), WIDTH, HEIGHT, g);

	}

}
