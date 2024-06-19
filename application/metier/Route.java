package application.metier;

public class Route {

	private int    nbSections;
	private Sommet sommetDepart;
	private Sommet sommetArriver;
	private int    joueur;


	public Route(int nbSections, Sommet sommetDepart, Sommet sommetArriver)
	{
		this.nbSections    = nbSections;
		this.sommetDepart  = sommetDepart;
		this.sommetArriver = sommetArriver;
		this.joueur        = 0;

	}

	public String toString()
	{
		String sRoute = "";

		sRoute += "Sommet de départ  : " + this.sommetDepart.getNom() + '\n' 
				+ "Sommet d'arrivé   : " + this.sommetArriver.getNom() + '\n'
				+ "Nombre de section : " + this.nbSections + '\n';

		return sRoute;
	}

	public void   setJoueur(int j)    { this.joueur = j; }

	// Accesseurs
	public int    getNbSections()     { return this.nbSections;    }
	public Sommet getSommetDepart()   { return this.sommetDepart;  }
	public Sommet getSommetArriver()  { return this.sommetArriver; }
	public int    getJoueur()         { return this.joueur;        }
}
