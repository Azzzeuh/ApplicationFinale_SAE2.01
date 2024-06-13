package metier;

public class JetonMine implements IRessource
{
	private static int    nbMine = 0;
	private        String couleur;
	private        int    valeur;

	public JetonMine creerJetonMine(String couleur, int valeur)
	{
		if(nbMine > 29) { return null;                           }
		else            { return new JetonMine(couleur, valeur); }
	}

	public JetonMine(String couleur, int valeur)
	{
		nbMine++;
		this.couleur = couleur;
		this.valeur  = valeur;

	}

	public String toString()
	{
		return "Jeton Mine " + this.couleur + this.valeur;
	}

}
