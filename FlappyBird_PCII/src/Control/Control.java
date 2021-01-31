/**Control  
 * Classe qui implemente l'interface MouseListener et qui permet de notifier l'affichage d'un changement eventuel 
 * declenché par l'utilisateur 
 */

package Control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Vue.Affichage;

public class Control implements MouseListener {
	Affichage game;

	/* Constructeur de la classe Control */
	public Control(Affichage a) {
		this.game = a;
	}

	/*
	 * MouseClicked permet de mettre à jour la position du joueur et met à jour
	 * l'afficage
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (!game.player.gameEnd) {
			this.game.player.jump();
			game.revalidate();
			game.repaint();
		}
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
