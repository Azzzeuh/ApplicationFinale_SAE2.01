public class Constructeur
{
	private Pioche pioche;
	private Joueur joueur1;
	private Joueur joueur2;

	private PanelPlateau plateau;


	public Constructeur()
	{
		this.pioche  = new Pioche();
		this.joueur1 = new Joueur();
		this.joueur2 = new Joueur();

		this.plateau = new PanelPlateau();

	}

	// Accesseurs
	public Pioche getPioche()  { return this.pioche;  }
	public Joueur getJoueur1() { return this.joueur1; }
	public Joueur getJoueur2() { return this.joueur2; }

}
