package ihm;

import metier.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

public class PanelPlateau extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{
	private FrameMenu  frameMenu;

	private ArrayList<Sommet> sommetList;
	private ArrayList<Route>  routeList;

	public PanelPlateau(FrameMenu frameMenu)
	{
		this.frameMenu = frameMenu;
		
		this.sommetList = new ArrayList<>();
		this.routeList  = new ArrayList<>();
	}

	public void setSommetList(ArrayList<Sommet> list) { this.sommetList = list; }
	public void setRouteList (ArrayList<Route> list)  { this.routeList  = list; }

	// Déssiner
	public void actionPerformed ( ActionEvent e )
	{
		this.repaint();
	}

	public void dessinerSommet(String n, int x, int y)
	{
		Sommet sommet = new Sommet(n, x, y);
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
                g.drawLine(x1, y1, x2, y2);
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

                    g.drawLine(x1Segment, y1Segment, x2Segment, y2Segment);
                }
            }
        }
        

		// Dessiner sommet
        for (Sommet sommet : this.sommetList )
        {
            g.setColor(Color.BLUE);
            g.fillOval(sommet.getX() - 13, sommet.getY() - 13, 26, 26);
            g.setColor(Color.BLACK);
            g.drawOval(sommet.getX() - 13, sommet.getY() - 13, 26, 26);
			g.drawString(sommet.getNom(), sommet.getX() - 16, sommet.getY() - 25);
			g.drawString("x: " + sommet.getX() + " y: " + sommet.getY(), sommet.getX() + 16, sommet.getY() + 25);
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
