package application.ihm;

import javax.swing.*;

import application.Controleur;
import application.metier.*;

import java.awt.event.*;
import java.util.ArrayList;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

public class PanelPlateau extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{
	private FrameMenu  frameMenu;

	private ArrayList<Sommet> sommetList;
	private ArrayList<Route>  routeList;

	private Image             imgFond;
	private Image             imgSommet;

	public PanelPlateau(Controleur ctrl, FrameMenu frameMenu)
	{
		this.frameMenu = frameMenu;

		this.sommetList = new ArrayList<>();
		this.routeList  = new ArrayList<>();

		this.imgFond = getToolkit().getImage ( ctrl.getImageFond() );
	}

	public void setSommetList(ArrayList<Sommet> list) { this.sommetList = list; }
	public void setRouteList (ArrayList<Route> list)  { this.routeList  = list; }

	// Déssiner
	public void actionPerformed ( ActionEvent e )
	{
		this.repaint();
	}

	public void dessinerSommet(String n,int valeur, int x, int y)
	{
		Sommet sommet = new Sommet(n, valeur, x, y);
		this.sommetList.add(sommet);
		this.repaint();
	}

	public void dessinerRoute(int sections, Sommet sommetDepart, Sommet sommetArriver)
	{
		Route r = new Route(sections, sommetDepart, sommetArriver);
		this.routeList.add(r);
		this.repaint();
	}

	public void paintComponent(Graphics g)	
	{
		super.paintComponent(g);

		// Ajout de l'image du fond
		if ( imgFond != null )
		{
			g.drawImage ( this.imgFond, 0 , 0, 1000, 884, this);
		}

		// Dessiner les routes avec les tronçons
		for(Route route : routeList)
		{
			Sommet sommetDepart  = route.getSommetDepart();
			Sommet sommetArriver = route.getSommetArriver();
			g.setColor(Color.BLACK);

			int nbSections = route.getNbSections();
			int espace = 10;

            int x1 = sommetDepart.getX();
            int y1 = sommetDepart.getY();
            int x2 = sommetArriver.getX();
            int y2 = sommetArriver.getY();

            double distanceTotale = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            double longueurTotale = nbSections * 10 + (nbSections - 1) * espace;

            // Si la longueur totale des segments et des espaces dépasse la distance totale
            if (longueurTotale > distanceTotale) 
            {
                if(sommetDepart.getNom().equals("NR")) { g.drawLine(x1 + 20, y1 + 22, x2 + 20, y2 + 22); }
                else { g.drawLine(x1 + 20, y1 + 60, x2 + 20, y2 + 60); }
            }

            else
            {
                double longueurSegment = (distanceTotale - (nbSections - 1) * espace) / nbSections;

                for (int i = 0; i < nbSections; i++) 
                {
                    double t1 = (i * (longueurSegment + espace)) / distanceTotale;
                    double t2 = ((i * (longueurSegment + espace)) + longueurSegment) / distanceTotale;

                    int x1Segment = (int) (x1 + t1 * (x2 - x1));
                    int y1Segment = (int) (y1 + t1 * (y2 - y1));
                    int x2Segment = (int) (x1 + t2 * (x2 - x1));
                    int y2Segment = (int) (y1 + t2 * (y2 - y1));

					// Déssine la route
                    if(sommetDepart.getNom().equals("NR")) { g.drawLine(x1Segment + 20, y1Segment + 22, x2Segment + 20, y2Segment + 22); }
                    else { g.drawLine(x1Segment + 20, y1Segment + 60, x2Segment + 20, y2Segment + 60); }
                }
            }
        }
        

		// Dessiner sommet
        for (Sommet sommet : this.sommetList )
        {
            // Dessiner sommet
			if(sommet.getNom().equals("NR"))
			{
				this.imgSommet = getToolkit().getImage ( "application/ihm/distrib_images/transparent/" + sommet.getNom() + ".png" );
				g.drawImage ( this.imgSommet, sommet.getX() , sommet.getY(), 40, 44, this );
			}

			else
			{
				this.imgSommet = getToolkit().getImage ( "application/ihm/distrib_images/transparent/" + sommet.getNom() + "_clair.png" );
				g.drawImage ( this.imgSommet, sommet.getX() , sommet.getY(), 40, 70, this );
			}

    	}
    }


	public void mouseDragged(MouseEvent e) 
	{

	}

	public void mouseMoved(MouseEvent e) 
	{

	}

	public void mouseClicked(MouseEvent e) 
	{

	}

	public void mousePressed(MouseEvent e) 
	{

	}

	public void mouseReleased(MouseEvent e) 
	{

	}
	public void mouseEntered(MouseEvent e) 
	{

	}

	public void mouseExited(MouseEvent e) 
	{

	}


}
