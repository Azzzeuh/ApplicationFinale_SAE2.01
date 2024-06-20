package src.ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import src.metier.*;
import src.Controleur;

public class PanelJoueur extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{	
	private int ligMax;
	private int colMax;

	private Image imgJoueur;
	private Image imgRess;
	private Joueur joueur;
	private PlateauIndividuel plateauIndividuel;

	public PanelJoueur(Joueur joueur)
	{
		this.joueur = joueur;
		this.plateauIndividuel = null;

		this.ligMax = this.joueur.getPlateauJoueur().getLigMax();
		this.colMax = this.joueur.getPlateauJoueur().getColMax();

		this.imgJoueur = getToolkit().getImage (this.getImageJoueur(this.joueur.getNumJoueur()));

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.setVisible(true);
	}

	public String getImageJoueur(int numJoueur) 
	{ 
		return "src/ihm/images/plateau_joueur_" + numJoueur + ".png";
	}

	public void setPlateauIndividuel(PlateauIndividuel plateau) { this.plateauIndividuel = plateau; }

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
			g.drawImage ( this.imgJoueur, 0 , 0, 550, 400, this);
		}
	
		// String nomRess = this.joueur.getPlateauJoueur().getJetonRessource(0, 0).getLibCourt().toUpperCase();
		// this.imgRess = getToolkit().getImage("application/ihm/distrib_images/ressources/" + nomRess + ".png");
		
		
	}


	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("X : " + e.getX() + "|" + "Y : " + e.getY());
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
}
