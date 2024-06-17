package application.metier;

import java.util.ArrayList;
import java.util.List;

public class PlateauIndividuel {

	private final int NB_COLONNE_MAX = 8;
	private final int NB_LIGNE_MAX = 4;

	private List<List<JetonRessource>> plateau;
	// private ArrayList<Jeton> jetonCollecter;
	private int score;

	public PlateauIndividuel() // création d'un plateau pour le joueur
	{
		this.plateau = new ArrayList<>(NB_LIGNE_MAX);
		for (int i = 0; i < NB_LIGNE_MAX; i++) {
			List<JetonRessource> ligne = new ArrayList<>(NB_COLONNE_MAX);
			for (int j = 0; j < NB_COLONNE_MAX; j++) {
				ligne.add(null);
			}

			plateau.add(ligne);
		}

		this.score = 0;
	}

	// Accesseurs
	public int getScore() {
		return this.score;
	}

	public boolean ajouterRessource(Jeton r) {


		if (r.getType() instanceof JetonRessource) {
			JetonRessource jeton = (JetonRessource) r.getType();
			int i = 3;

				for (int j = 0; j < NB_COLONNE_MAX; j++) {
					if (plateau.get(i).get(j) == null && jeton.getNom() != "Monnaie") 
					{
						plateau.get(i).set(j, jeton);
						return true;
					}
			}

			for (i = 1; i < (NB_LIGNE_MAX); i++) {
				for (int j = 0; j < NB_COLONNE_MAX; j++) {
					if (plateau.get(i).get(j) == jeton && jeton.getNom() != "Monnaie") {
						plateau.get(i - 1).set(j, jeton);
						return true;
					}
				}
			}

			return false;
		}
		return false;
	}

	public String toString() {
		// Creation du tableau
		String resultat = "+-----+-----+-----+-----+-----+-----+-----+-----+\n";
		for (int i = 0; i < NB_LIGNE_MAX; i++) {
			resultat += "|";

			for (int j = 0; j < NB_COLONNE_MAX; j++) {
				if (plateau.get(i).get(j) != null) {
					resultat += String.format("%4s", (plateau.get(i).get(j)).getLibCourt());
				} else {
					resultat += String.format("%4s", " ");
				}
				resultat += " |";
			}

			resultat += " \n+-----+-----+-----+-----+-----+-----+-----+-----+\n";

		}
		return resultat;
	}

	public static void main(String[] args) {
		// Crée une instance de Plateau

		PlateauIndividuel plateau = new PlateauIndividuel();
		Pioche pioche = new Pioche();

		// Affiche l'état initial du plateau

		System.out.println("Etat initial du plateau : \n");
		System.out.println(plateau.toString() + "\n");

		System.out.println("Ajout des ressources à partir des jetons de la pioche\n");

		for (int i = 0; i < 30; i++) {
			String sRet;
			Jeton j = pioche.tirerJeton();
			sRet = j.toString();
			sRet += plateau.ajouterRessource(j);
			sRet = j.toString();
			System.out.println(sRet);
		}

		System.out.println("\n\nEtat final du Plateau");
		System.out.println(plateau.toString() + "\n");
	}

}
