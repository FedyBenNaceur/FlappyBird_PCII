/*class Parcours qui s'occupe de la logique derriere la ligne brisée*/
package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


public class Parcours {
	public ArrayList<Point> points;// la liste des points qui represente 
	public Affichage game;
	private int pos = 0;
	public final int px = 1;// cet attribut est utilisé pour faire avancer la position de quelques pixels
    
	//constructeur de la classe parcours 
	public Parcours(Affichage a) {
		points = new ArrayList<Point>();
		game = a;
		initialisePoints();
		pos = 0;

	}
    
	/**initialisePoints
	 * Procedure qui initialise le tableau de points de manière aleatoire avec une
	 *  distance mininmale de 20 entre deux points et maximale de 40 .
	 *  Ps : J'attends le retour de notre charge de tp pour amelioré mon algo
	 */
	private void initialisePoints() {
		// positionner le premier point au milieu de l'ovale
		int prevx = 10 + (game.WIDTH / 2);
		int prevy = game.HAUTEUR - (game.HEIGHT / 2);
		points.add(new Point(prevx, prevy));
		Random r = new Random();
		while (prevx <= game.LARGEUR) {
			int x = r.nextInt((prevx + 40) - (prevx + 20)) + (prevx + 20);//50 30 30 
			int y = r.nextInt(game.HAUTEUR);
			points.add(new Point(x, y));
			prevx = x;
			prevy = y;	
		}
	}
	
	
	/**addPoint
	 * Procedure qui permet d'ajouter un points dans la liste tout en conservant les contraintes
	 * fixées sur cette liste .
	 */
	public void addPoint () {
		Point last = points.get(points.size()-1);
		Random r = new Random();
		int offset = (points.get(1).x-points.get(0).x);
		int x = r.nextInt((last.x + 50) - (last.x + 30)) + (last.x + 30);
		int y = r.nextInt(game.HAUTEUR);
		points.add(new Point(x,y));
		removePoint(offset);
	}
	
	/**removePoint 
	 * Procedure qui permet de supprimer un element de la liste et mettre à jour la position des points
	 * @param offset : ce paramatre permet de definir le decalage necessaire pour decaler les points
	 */
	public void removePoint (int offset) {
		for(int i = 0 ; i < points.size()-1 ; i++ ) {
			points.set(i, new Point(points.get(i).x - offset , points.get(i).y));
		}
		points.remove(0);
	}
	
	/**
	 * renvoie la liste de points
	 * 
	 * @return liste des points qui constitue la ligne brisée visible
	 */
	public Point[] getParcours() {
		Point[] res = new Point[points.size()];
		for (int i = 0 ; i<points.size();i++) {
			int x = points.get(i).x  ; 
		    int y = points.get(i).y;
		    res[i] = new Point(x,y);
	     }
		return res ;
	}


	// getteur de l'attribut Position
	public int getPosition() {
		return this.pos;
	}

	// setteur de l'attribut Position
	public void setPosition() {
		pos += px;
		addPoint();
		game.repaint();
	}

}
