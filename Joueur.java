public class Joueur
{

	private static int numJoueur;
	private int score;

	private PlateauIndividuel plateauJoueur;


	public Joueur()
	{
		this.numJoueur++;
		this.score = 0;

		this.plateauJoueur = null;
	}

	public void creerPlateauJoueur(PlateauIndividuel pltJ)
	{
		this.plateauJoueur = new PlateauIndividuel();
	}


	// Acceseur
	public int               getNumJoueur()     { return this.numJoueur;     }
	public Plateauindividuel getPlateauJoueur() { return this.plateauJoueur; }
	public int               getScore()         { return this.score;         }
}
