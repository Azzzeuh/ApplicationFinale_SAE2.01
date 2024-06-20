package src.ihm;

import src.metier.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Scanner;
import java.io.FileInputStream;


public class FrameMenu extends JFrame implements ActionListener
{
	/* Variables    */
	/*--------------*/

	// Boutons
	private JButton chargerJButton;
	private JButton   jouerJButton;

	private ArrayList<Sommet> listSommet;
	private ArrayList<Route> listRoute;

	private PanelPlateau panelPlateau;
	
	private Joueur joueur1;
	private Joueur joueur2;

	private FrameJoueur frameJoueur1;
	private FrameJoueur frameJoueur2;
	/* Instructions */
	/*--------------*/

	public FrameMenu(int x, int y, PanelPlateau panelPlateau, Joueur joueur1, Joueur joueur2)
	{
		// Initialisation de la fenêtre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 200);
		this.setTitle ("Menu");
		this.setLocation(x, y);
		this.setLayout(new FlowLayout());

		this.joueur1 = joueur1;
		this.joueur2 = joueur2;

		this.panelPlateau = panelPlateau;

		// Initialisation des Boutton
		this.chargerJButton = new JButton("CHARGER");
		this.jouerJButton   = new JButton("JOUER");

		// Initialisation des listes
		this.listSommet = new ArrayList<>();
		this.listRoute = new ArrayList<>();

		// Ajout des Composants
		this.add(chargerJButton);
		this.add(jouerJButton);


		// Activation des Bouton
		this.chargerJButton.addActionListener( this );
		this.jouerJButton.addActionListener( this );



		this.setVisible(true);

	}

	public Joueur getJoueur(int n) 
	{ 
		if ( n == 1 ) return this.joueur1;
		if ( n == 2 ) return this.joueur2;
		return null;
	}

	public PanelJoueur getPanelJoueur(int n) 
	{ 
		if ( n == 1 ) return this.frameJoueur1.getPanelJoueur();
		if ( n == 2 ) return this.frameJoueur2.getPanelJoueur();
		return null;
	}

	public ArrayList<Sommet> viderListeSommet(ArrayList<Sommet> listSommet)
	{
		if(this.listRoute.isEmpty())
		{
			for(Sommet s : listSommet)
				listSommet.remove(s);
			Sommet.resetNbSommet();
		}
		//this.panelPlateau.setSommetList(listSommet);
		return listSommet;
	}

	public ArrayList<Route> viderListeRoute(ArrayList<Route> listRoute)
	{
		if(this.listRoute.isEmpty())
		{
			for(Route r : listRoute)
				listRoute.remove(r);
		}
		//this.panelPlateau.setRouteList(listRoute);
		return listRoute;
	}

	public void setPanelPlateau(PanelPlateau panel)
	{
		this.panelPlateau = panel;
	}


	public void actionBouton(String btn) 
	{
		if( btn == "Charger" ) { this.chargerJButton.doClick(); }
		if( btn == "Jouer"   ) { this.jouerJButton.doClick();   }
	}

	public void actionPerformed(ActionEvent e)
	{
		Scanner sc;

		Sommet sDepart  = null;
		Sommet sArriver = null;


		// Action du bouton charger
		if(e.getSource() == this.chargerJButton)
		{
			this.viderListeSommet(listSommet);
			this.viderListeRoute(listRoute);

			this.panelPlateau.repaint();

			if(!this.listSommet.isEmpty() && !this.listRoute.isEmpty())
			{
				this.viderListeRoute(this.listRoute);
				this.viderListeSommet(this.listSommet);
			}

			// Scanner
			try
			{
				sc = new Scanner    (new FileInputStream("src/ihm/theme/texte.txt"),  "UTF-8");

				while (sc.hasNextLine())
				{
					String line = sc.nextLine().trim();
                	if (line.isEmpty()) {
                    	continue; 
                	}

					// Décomposeur
					String[] mots = line.split("\t");
					if(mots[0].charAt(0)=='S')
					{
						this.listSommet.add(new Sommet(mots[1], Integer.parseInt(mots[2]), Integer.parseInt(mots[3]), Integer.parseInt(mots[4])));
					}
					if(mots[0].charAt(0)=='R')
					{
						for(Sommet s: listSommet)
						{
							if(Integer.parseInt(mots[2])==s.getNumSommet()) { sDepart  = s; }
							if(Integer.parseInt(mots[3])==s.getNumSommet()) { sArriver = s; }
						}
						this.listRoute.add(new Route(Integer.parseInt(mots[1]), sDepart, sArriver));
					
					}
				}

				sc.close();
			}
			catch (Exception exp){ exp.printStackTrace(); }

			this.panelPlateau.setSommetList(this.listSommet);
			this.panelPlateau.setRouteList(this.listRoute);

			this.panelPlateau.repaint();
		}


		// Action du bouton jouer
		if(e.getSource() == this.jouerJButton)
		{
			this.dispose();

			Pioche pioche = new Pioche();

			this.panelPlateau.dessinerRessource(pioche);
				
			this.frameJoueur1 = new FrameJoueur(this.getX(), 50, panelPlateau, this.joueur1);
			this.frameJoueur2 = new FrameJoueur(this.getX(), this.frameJoueur1.getHeight() + 90, panelPlateau, this.joueur2);
		
			this.panelPlateau.setPanelJoueur(this.frameJoueur1.getPanelJoueur(), 1);
			this.panelPlateau.setPanelJoueur(this.frameJoueur2.getPanelJoueur(), 2);
		}

	}




}
