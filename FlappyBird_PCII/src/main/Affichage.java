/**class Affichage 
 * La classe Affichage h�rite de JPanel.
 *  Elle dispose de :
 *  attribut de type Etat pour acc�der � l��tat du mod�le lorsque l�affichage doit �tre revu,
 *  via la m�thode paint.
 *  attribut de type Control qui permet de notifier la vue des diff�rents changements qui ont lieu.
 *  des attributs LARGEUR ,HAUTEUR , HEIGHT,WIDTH qui d�finissent la taille des objets � d�finir
 *  Cette classe g�re l'affichage sur l'�cran des diff�rentes composantes pr�sentes dans notre jeu

 */

package main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Affichage extends JPanel {
	public final int LARGEUR = 600;//largeur et hauteur correspondent respectivement a la largeur et hauteur de la Panel
	public final int HAUTEUR = 400;
	public final int HEIGHT=100; //Les deux variables height et width repr�sentent les dimensions de l��clipse
	public final int WIDTH=50;
	public Etat player;
	public Control c ;
	
    /*constructeur de la classe Affichage*/
	public Affichage() {
		this.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));	
	}
	
    /**flyBird
     *  dessine l��clipse qui repr�sente l'oiseau dans le jeu � partir des coordonn�es pr�d�finis
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
