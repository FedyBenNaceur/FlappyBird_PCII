package main;

public class Etat {
	private int x;
	private int hauteur;

	private final int Speed = 20 ;
	private Affichage game ; 

	public Etat(Affichage a) {
		this.x=10;
		this.game = a ;
		this.hauteur = game.HAUTEUR - a.HEIGHT ;
		
	}
	
	public void jump() {
		if ( this.hauteur>0 ) {
			this.hauteur -= Speed ;
		}
	}
	
	public int getHauteur() {
		return this.hauteur ;
	}
	
	public int getX() {
		return this.x ;
	}
	
	

}
