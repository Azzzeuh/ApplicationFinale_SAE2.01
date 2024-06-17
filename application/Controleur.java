package application;


import java.util.ArrayList;

import application.ihm.*;
import application.metier.*;

public class Controleur
{

		// Arraylist
		private ArrayList<Sommet> listSommet;
		private ArrayList<Route>  listRoute;

	public Controleur()
	{
		FramePlateau plt = new FramePlateau(100, 100);

		this.listSommet = new ArrayList<>();
		this.listRoute = new ArrayList<>();
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
	
	public ArrayList<Sommet> getSommetList() { return this.listSommet; }
	public ArrayList<Route>  getRouteList()  { return this.listRoute;  }

	public static void main(String[] a)
	{
		new Controleur();
	}

}

