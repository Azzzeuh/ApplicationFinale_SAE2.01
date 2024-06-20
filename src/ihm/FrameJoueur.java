package src.ihm;

import java.awt.Image;

import javax.swing.*;

import src.metier.*;

public class FrameJoueur extends JFrame{
	
	private PanelJoueur panelJoueur;
	private PanelPlateau panelPlateau;

	public FrameJoueur(int x, int y, PanelPlateau panelPlateau, Joueur joueur)
	{
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(x, y);
		this.setTitle("FrameJoueur");
		this.setSize(750, 436);

		this.panelJoueur = new PanelJoueur(joueur);



		this.add(panelJoueur);

		this.setVisible(true);
	}

	public PanelJoueur getPanelJoueur() { return this.panelJoueur; }
}
