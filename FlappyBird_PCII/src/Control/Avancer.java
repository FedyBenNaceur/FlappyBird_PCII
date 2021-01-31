package Control;

import Vue.Affichage;

// classe Avancer ; Une classe qui gere le defilement de la ligne brisée
public class Avancer extends Thread {
	private Affichage game;
	private final int time_to_sleep = 100;

	public Avancer(Affichage g) {
		super("Avancer");
		this.game = g;
	}
	

	@Override
	public void run() {
		while (!game.player.gameEnd) {
			game.p.setPosition();
			game.player.testPerdu();
			try {
				Thread.sleep(time_to_sleep);			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
