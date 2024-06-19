package application.ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import application.metier.*;
import application.Controleur;

public class PanelJoueur extends JPanel implements ActionListener
{
	private Image imgJoueur;
	private Joueur joueur;

	public PanelJoueur(Joueur joueur)
	{
		this.joueur = joueur;

		this.imgJoueur = getToolkit().getImage (this.getImageJoueur(this.joueur.getNumJoueur()));

		this.setVisible(true);
	}

	public String getImageJoueur(int numJoueur) 
	{ 
		return "application/ihm/distrib_images/plateau_joueur_" + numJoueur + ".png";
	}

	public void actionPerformed ( ActionEvent e )
	{
		this.repaint();
	}

	public void paintComponent(Graphics g)	
	{
		super.paintComponent(g);

		// Ajout de l'image du fond
		if ( imgJoueur != null )
		{
			g.drawImage ( this.imgJoueur, 0 , 0, 750, 400, this);
		}
	}
}
