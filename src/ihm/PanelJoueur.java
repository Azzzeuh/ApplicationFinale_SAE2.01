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
	private static boolean partieEnCours = false;
	
	private int ligMax;
	private int colMax;

	private Image imgJoueur;
	private Image imgRess;
	private Joueur joueur;
	private PlateauIndividuel plateauIndividuel;

	private ArrayList<Sommet> sommetJoueurList;

	public PanelJoueur(Joueur joueur)
	{
		this.joueur = joueur;
		this.plateauIndividuel = null;

		this.sommetJoueurList = new ArrayList<>();
	
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
	public void setSommetJoueurList(ArrayList<Sommet> list) { this.sommetJoueurList = list; }
	public void setPartieEnCours() { partieEnCours = true; }


	public void actionPerformed ( ActionEvent e )
	{
		this.repaint();
	}

	public void redessinerPlateau() 
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

		if(!this.sommetJoueurList.isEmpty() && this.sommetJoueurList.get(0) != null && partieEnCours)
		{
			int x = 65;
			int y = 220;
			int cpt = 0;
			JetonRessource jr = null;
			int xMonnaie = 65;
			int yMonnaie = 328;
			int nbNr = 0;

			for (int i = 0; i < 4; i++) 
			{
				for (int j = 0; j < 8; j++) 
				{
					if (cpt < this.sommetJoueurList.size()) 
					{
						jr = (JetonRessource) this.sommetJoueurList.get(cpt).getJeton().getType();
						if (jr.getLibCourt().equalsIgnoreCase("Nr")) 
						{
							nbNr++;
							cpt++;
							continue; 
						}
						else 
						{
							if (jr != null) 
							{
								String nomRess = jr.getLibCourt().toUpperCase();
								this.imgRess = getToolkit().getImage("src/ihm/images/ressources/" + nomRess + ".png");
								g.drawImage(imgRess, x, y, 50, 50, this);
								x += 52;
								cpt++;
							}
						}
						
					}
				}
				y-= 55;
				x = 65;
			}

			for(int n = 0; n < nbNr; n++)
			{
				this.imgRess = getToolkit().getImage ("src/ihm/images/ressources/NR.png");
				g.drawImage(imgRess, xMonnaie, yMonnaie, 50, 50, this);
				xMonnaie += 52;
			}
		}
	}


	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		System.out.println(e.getX() + "   " + e.getY());
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
}
