package src;

import src.ihm.*;
import src.metier.*;

import java.util.ArrayList;

public class Controleur
{
	// Jeu 		metier;
	private FramePlateau ihm;
	private int          scn;

	public Controleur(int scenario)
	{
		this.ihm = new FramePlateau(this, 50, 50);
		this.scn = scenario;
	}

	// Accesseurs

		// Image de Fond
	public String getImageFond() { return "src/ihm/images/Plateau_vierge.png"; }

	public void executerEtape(int numeroEtape)
	{
		if(this.scn == 1)
		{
			if (numeroEtape == 1) { 
				this.ihm.getFrameMenu().actionBouton("Charger");
			}
			/*if( numeroEtape == 2) { 
				this.ihm.getFrameMenu().actionBouton("Charger"); 
			}*/
			if( numeroEtape == 3) { 
				this.ihm.getFrameMenu().actionBouton("Jouer"  );
			}
		}
	}

	public static void main(String[] a)
	{
		new Controleur(1);
	}
	

}

