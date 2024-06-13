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

	// Arraylist
	private ArrayList<Sommet> listSommet;
	private ArrayList<Route>  listRoute;


	/* Instructions */
	/*--------------*/

	public FrameMenu(int x, int y)
	{
		// Initialisation de la fenêtre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 200);
		this.setTitle ("Menu");
		this.setLocation(x, y);
		this.setLayout(new FlowLayout());


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
		this.listSommet = new ArrayList<>();
		this.listRoute = new ArrayList<>();


		this.setVisible(true);

	}


	// Vider les listes
	public ArrayList<Route> viderListeRoute(ArrayList<Route> liste)
	{
		for(Route r : liste)
		{
			liste.remove(r);
		}
		return liste;
	}

	public ArrayList<Sommet> viderListeSommet(ArrayList<Sommet> liste)
	{
		for(Sommet s : liste)
		{
			liste.remove(s);
			Sommet.resetNbSommet();
		}
		return liste;

	}


	public void actionPerformed(ActionEvent e)
	{
		Decomposeur dec;
		Scanner sc;

		int nbSections;
		Sommet sDepart  = null;
		Sommet sArriver = null;

		int cpt = 0;


		// Action du bouton charger
		if(e.getSource() == this.chargerJButton)
		{
			this.viderListeRoute(this.listRoute);
			this.viderListeSommet(this.listSommet);


			// Scanner
			try
			{
				sc = new Scanner    (new FileInputStream("ihm/theme/texte.txt"),  "UTF-8");

				
				while (sc.hasNextLine())
				{
					System.out.println(cpt++);

					// Décomposeur
					dec = new Decomposeur(sc.nextLine());

					if (dec.getString(1) != null)
                    {
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
				
			}


				sc.close();
			}
			catch (Exception exp){ exp.printStackTrace(); }
		
			for(Sommet s: listSommet)
			{
				System.out.println(s.toString());
			}

			for(Route r: listRoute)
			{
				System.out.println(r.toString());
			}


		}


		// Action du bouton jouer
		if(e.getSource() == this.jouerJButton)
		{


		}

	}




}
