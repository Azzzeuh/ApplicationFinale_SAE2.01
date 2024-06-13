package metier;

public class Joueur {

	private static int numJoueur;
	private int score;

	private PlateauIndividuel plateauJoueur;

	public Joueur() {
		numJoueur++;
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
}
