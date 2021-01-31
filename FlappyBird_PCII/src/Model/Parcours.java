/*class Parcours qui s'occupe de la logique derriere la ligne brisée*/
package Model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import Vue.Affichage;

public class Parcours {
	public ArrayList<Point> points;// la liste des points qui represente
	public Affichage game;
	private int pos = 0;
	public final int px = 3;// cet attribut est utilisé pour faire avancer la position de quelques pixels
	public Point[] droite ;

	// constructeur de la classe parcours
	public Parcours(Affichage a) {
		points = new ArrayList<Point>();
		game = a;
		initialisePoints();
		pos = 0;
		droite = new Point[2];
		this.droite[0] = new Point(0,0);
		this.droite[1] = new Point(0,0);
		updateDroite();
	}

	/**
	 * initialisePoints Procedure qui initialise le tableau de points de manière
	 * aleatoire avec une distance mininmale de 20 entre deux points et maximale de
	 * 40 . Ps : J'attends le retour de notre charge de tp pour amelioré mon algo
	 */

	private void initialisePoints() {
		// positionner le premier point au milieu de l'ovale
		int x = 20;
		int y = game.HAUTEUR / 2;
		points.add(new Point(x, y));
		Random r = new Random();
		while (x <= game.LARGEUR) {
			x += 50 + r.nextInt(15);
			y = r.nextInt(game.player.HEIGHT_max - game.player.HEIGHT_min) + game.player.HEIGHT_min;
			points.add(new Point(x, y));
		}
		

	}

	/**
	 * addPoint Procedure qui permet d'ajouter un points dans la liste tout en
	 * conservant les contraintes fixées sur cette liste .
	 */
	public void addPoint() {
		Point last = points.get(points.size() - 1);
		Random r = new Random();
		// int offset = (points.get(1).x - points.get(0).x);
		int x = r.nextInt((last.x + 90) - (last.x + 75)) + (last.x + 75);
		int y = r.nextInt(game.player.HEIGHT_max - game.player.HEIGHT_min) + game.player.HEIGHT_min;
		points.add(new Point(x, y));
	}

	/**
	 * renvoie la liste de points
	 * 
	 * @return liste des points qui constitue la ligne brisée visible
	 */

	public Point[] getParcours() {
		// updateDroite()
		Point[] res = new Point[points.size()];
		updateDroite();
		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			res[i] = p;
		}
		return res;
	}

	// getteur de l'attribut Position
	public int getPosition() {
		return this.pos;
	}

	// setteur de l'attribut Position
	public void setPosition() {
		pos += px;
		for (int i = 0; i < points.size(); i++) {
			if (points.get(i).x - px < -90) {
				points.remove(i);
			}
		/*if (points.get(i).x - px < game.LARGEUR && points.get(i).x - px > 550  ) {
				addPoint();
			}*/
			points.set(i, new Point(points.get(i).x - px, points.get(i).y));
			
		}
		if (points.get(points.size()-1).x  <= game.LARGEUR  ) {
			addPoint();
		}
		
		game.repaint();
	}
	
    private void updateDroite() {
    	droite[0]= points.get(0);
		droite[1]=points.get(1);
    }
    
    public float fstY() {
    	float pente = (droite[1].y - droite[0].y) /(droite[0].x-droite[1].x) ;
    	float b = droite[0].y - (pente*droite[0].x ) ;
    	return pente + b ;
    }

}