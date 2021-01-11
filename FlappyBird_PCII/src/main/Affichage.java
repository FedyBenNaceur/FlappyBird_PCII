package main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Affichage extends JPanel {
	public JFrame fenetre;
	public final int LARGEUR = 600;//largeur et hauteur correspendent respectivement a la largeur et hauteur de la Panel
	public final int HAUTEUR = 400;
	public final int HEIGHT=100; //Les deux variables height et width representent les dimensions de l'eclipse
	public final int WIDTH=50;
	public Etat player;
	Control c ;

	public Affichage() {
		this.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));	
	}

	public void flyBird(int x, int y, int largeur, int hauteur, Graphics g) {
		g.drawOval(x, y, largeur, hauteur);
	}
	
	public void initialiseEtat(Etat e ) {
		this.player = e ;
	}
	
	public void initialiseControl(Control c ) {
		this.c = c;
		this.addMouseListener(this.c);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		flyBird(player.getX(), player.getHauteur(), WIDTH, HEIGHT, g);

	}

}
