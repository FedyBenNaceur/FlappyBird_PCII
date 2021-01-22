package Control;

import Model.Etat;

public class Voler extends Thread {
	private Etat player;
	private final int time_to_sleep = 800;// determine combien de temps le thread doit attendre avant de faire descendre
											// l'eclipse
	public Voler(Etat p) {
		super("voler");
		player = p;
	}

	/**
	 * run la methode utilise une boucle infinie pour faire redescendre l'oiseau
	 */
	@Override
	public void run() {
		while (true) {	
			player.moveDownn();
			try {
				Thread.sleep(time_to_sleep);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
