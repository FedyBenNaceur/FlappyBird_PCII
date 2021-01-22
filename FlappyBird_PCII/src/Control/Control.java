/**Control  
 * Classe qui implemente l'interface MouseListener et qui permet de notifier l'affichage d'un changement eventuel 
 * declench� par l'utilisateur 
 */

package Control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vue.Affichage;

public class Control implements MouseListener {
	Affichage game;

	/* Constructeur de la classe Control */
	public Control(Affichage a) {
		this.game = a;
	}

	/*
	 * MouseClicked permet de mettre � jour la position du joueur et met � jour
	 * l'afficage
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		this.game.player.jump();
		game.repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
