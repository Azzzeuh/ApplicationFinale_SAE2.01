public class Route {

	private int  nbSections;
	private Mine mineDepart;
	private Mine mineArriver;

	// Fabrique de Route
	public static Route creerRoute(int nbSections, Mine mineDepart, Mine mineArriver)
	{
		if(nbSections <= 1 || nbSections >= 2) { return null; }
		else if(mineDepart  == null)           { return null; }
		else if(mineArriver == null)           { return null; }
		else { return new Route(nbTroncons, villeDepart, villeArriver); }
	}


	private Route(int nbSections, Mine mineDepart, Mine mineArriver)
	{
		this.nbSections   = nbSections;
		this.mineDepart  = mineDepart;
		this.mineArriver = mineArriver;

	}

	// Accesseurs
	public int  getNbTroncons()  { return this.nbSections;  }
	public Mine getMineDepart()  { return this.mineDepart;  }
	public Mine getMineArriver() { return this.mineArriver; }
}
