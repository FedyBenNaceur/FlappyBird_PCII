package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements MouseListener {
	Affichage game ;
	public Control (Affichage a){
		this.game = a ;
	}

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
