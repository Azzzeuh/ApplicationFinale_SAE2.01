package application;

import application.ihm.*;
import application.metier.*;

public class Controleur
{

	public Controleur()
	{
		FramePlateau plt = new FramePlateau(this, 100, 100);
	}

	// Accesseurs

		// Image de Fond
	public String getImageFond() { return "application/ihm/distrib_images/Plateau_vierge.png"; }

	public static void main(String[] a)
	{
		new Controleur();
	}

}

