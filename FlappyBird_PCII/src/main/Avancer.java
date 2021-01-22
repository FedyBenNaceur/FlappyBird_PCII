package main;


// classe Avancer ; Une classe qui gere le defilement de la ligne brisée
public class Avancer extends Thread {
	private Affichage game;

	public Avancer(Affichage g) {
		super("Avancer");
		this.game = g;
	}

	@Override
	public void run() {
		while (true) {
			game.p.setPosition();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
