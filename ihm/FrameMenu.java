package ihm;

import metier.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Scanner;
import java.io.FileInputStream;

import iut.algo.*;


public class FrameMenu extends JFrame implements ActionListener
{
	/* Variables    */
	/*--------------*/

	// Boutons
	private JButton chargerJButton;
	private JButton   jouerJButton;



	private PanelPlateau panelPlateau;
	/* Instructions */
	/*--------------*/

	public FrameMenu(int x, int y, PanelPlateau panelPlateau)
	{
		// Initialisation de la fenêtre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 200);
		this.setTitle ("Menu");
		this.setLocation(x, y);
		this.setLayout(new FlowLayout());

		this.panelPlateau = panelPlateau;

		// Initialisation des Boutton
		this.chargerJButton = new JButton("CHARGER");
		this.jouerJButton   = new JButton("JOUER");


		// Ajout des Composants
		this.add(chargerJButton);
		this.add(jouerJButton);


		// Activation des Bouton
		this.chargerJButton.addActionListener( this );
		this.jouerJButton.addActionListener( this );


		// Création des ArrayList



		this.setVisible(true);

	}

	public void setPanelPlateau(PanelPlateau panel)
	{
		this.panelPlateau = panel;
	}

	public void actionPerformed(ActionEvent e)
	{
		Decomposeur dec;
		Scanner sc;

		int nbSections;
		Sommet sDepart  = null;
		Sommet sArriver = null;


		// Action du bouton charger
		if(e.getSource() == this.chargerJButton)
		{
			//this.viderListeRoute(this.listRoute);
			//this.viderListeSommet(this.listSommet);


			// Scanner
			try
			{
				sc = new Scanner    (new FileInputStream("ihm/theme/texte.txt"),  "UTF-8");

				
				while (sc.hasNextLine())
				{

					// Décomposeur
					dec = new Decomposeur(sc.nextLine());


					if(dec.getChar(0)=='S')
					{
						this.listSommet.add(new Sommet(dec.getString(1), dec.getInt(2), dec.getInt(3)));
					}
					if(dec.getChar(0)=='R')
					{
						for(Sommet s: listSommet)
						{
							if(dec.getString(2).equals(s.getNom())) { sDepart  = s; }
							if(dec.getString(3).equals(s.getNom())) { sArriver = s; }

						}
						this.listRoute.add(new Route(dec.getInt(1), sDepart, sArriver));
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


		}

	}




}
