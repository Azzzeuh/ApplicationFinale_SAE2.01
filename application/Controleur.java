package application;

import application.ihm.*;
import application.metier.*;

public class Controleur
{
	// Jeu 		metier;
	private FramePlateau ihm;

	public Controleur()
	{
		this.ihm = new FramePlateau(this, 50, 50);
		// this.metier = new Jeu();
	}

	// Accesseurs

		// Image de Fond
	public String getImageFond() { return "application/ihm/distrib_images/Plateau_vierge.png"; }

	public static void main(String[] a)
	{
		new Controleur();
	}

}

