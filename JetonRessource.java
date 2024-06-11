public enum JetonRessource implements IRessource
{
	Nr("Monnaie"),

	Al("Aluminium"),
	Ag("Argent"),
	Au("Or"),
	Co("Cobalt"),
	Fe("Fer"),
	Ni("Nickel"),
	Pt("Platine"),
	Ti("Titane");

	private String nom;

	JetonRessource (String nom)
	{
		this.nom = nom;
	}

	public String getLibCourt()
	{
		return this.name();
	}

	public String getNom() { return this.nom; }

	public String toString()
	{
		return this.nom;
	}

}
