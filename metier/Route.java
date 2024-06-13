package metier;

public class Route {

	private int  nbSections;
	private Sommet sommetDepart;
	private Sommet sommetArriver;

	// Fabrique de Route
	/*public static Route creerRoute(int nbSections, Sommet sommetDepart, Sommet sommetArriver)
	{
		if(nbSections <= 1 || nbSections >= 2)  { return null; }
		else if(sommetDepart  == sommetArriver) { return null; }
		else if(sommetDepart  == null)          { return null; }
		else if(sommetArriver == null)          { return null; }
		return new Route(nbSections, sommetDepart, sommetArriver); }
	}*/


	public Route(int nbSections, Sommet sommetDepart, Sommet sommetArriver)
	{
		this.nbSections    = nbSections;
		this.sommetDepart  = sommetDepart;
		this.sommetArriver = sommetArriver;

	}

	public String toString()
	{
		String sRoute = "";

		sRoute += "Sommet de départ  : " + this.sommetDepart.getNom() + '\n' 
				+ "Sommet d'arrivé   : " + this.sommetArriver.getNom() + '\n'
				+ "Nombre de section : " + this.nbSections + '\n';

		return sRoute;
	}

	// Accesseurs
	public int    getNbSelections() { return this.nbSections;    }
	public Sommet getMineDepart()   { return this.sommetDepart;  }
	public Sommet getMineArriver()  { return this.sommetArriver; }
}
