package application.metier;

import java.util.ArrayList;

public class Joueur {

	private static int nbJoueur = 0;
	private int numJoueur;
	private int score;

	private PlateauIndividuel plateauJoueur;

	public Joueur() {
		this.numJoueur = ++ nbJoueur;
		this.score = 0;

		this.plateauJoueur = null;
	}

	public void creerPlateauJoueur() {
		this.plateauJoueur = new PlateauIndividuel();
	}


	// Setter
	public void setScore(int score) {
		this.score = score;
	}

	// Acceseur
	public int getNumJoueur() {
		return numJoueur;
	}
	public PlateauIndividuel getPlateauJoueur() {
		return this.plateauJoueur;
	}
	public int getScore() {
		return this.score;
	}
	public String toString() 
	{
		return "Joueur : " + this.numJoueur;
	}
}
