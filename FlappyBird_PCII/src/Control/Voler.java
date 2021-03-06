package Control;

import Model.Etat;

public class Voler extends Thread {
	private Etat player;
	private final int time_to_sleep = 200;// determine combien de temps le thread doit attendre avant de faire descendre
											// l'eclipse
	private boolean fst = true ;
	public Voler(Etat p) {
		super("voler");
		player = p;
	}

	/**
	 * run la methode utilise une boucle infinie pour faire redescendre l'oiseau
	 */
	@Override
	public void run() {
		while (!player.gameEnd) {
			if (fst) {
				try {
					Thread.sleep(2000);
					fst = false ; 
				}catch (Exception e ) {
					e.printStackTrace();
				}
			}
			player.moveDownn();
			
			try {
				Thread.sleep(time_to_sleep);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
