package application.ihm;

import javax.swing.*;

import application.Controleur;
import application.metier.*;

import java.awt.event.*;
import java.util.ArrayList;

import java.awt.*;

public class PanelPlateau extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{
	private FrameMenu  frameMenu;

	private ArrayList<Sommet> sommetList;
	private ArrayList<Route>  routeList;
	private ArrayList<Jeton>  jetonList;

	private Image             imgFond;
	private Image             imgSommet;
	private Image             imgJeton;


	private boolean partieEnCours = false;

	private Sommet sommetSelectionner;

	private int nvX;
	private int nvY;


	public PanelPlateau(Controleur ctrl, FrameMenu frameMenu)
	{
		this.frameMenu = frameMenu;

		this.sommetList = new ArrayList<>();
		this.routeList  = new ArrayList<>();
		this.jetonList  = new ArrayList<>();

		this.imgFond = getToolkit().getImage ( ctrl.getImageFond() );

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}


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

	public void dessinerRessource(Pioche pioche)
	{
		this.jetonList = pioche.getJetonList();
		this.partieEnCours = true;
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

            int x1 = sommetDepart.getX();
            int y1 = sommetDepart.getY();
            int x2 = sommetArriver.getX();
            int y2 = sommetArriver.getY();

            double distanceTotale = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            double longueurSegment = (distanceTotale - (nbSections - 1)) / nbSections;

            for (int i = 0; i < nbSections; i++)
            {
                double t1 = ( i * longueurSegment)                    / distanceTotale;
                double t2 = ((i * longueurSegment) + longueurSegment) / distanceTotale;

                int x1Segment = (int) (x1 + t1 * (x2 - x1));
                int y1Segment = (int) (y1 + t1 * (y2 - y1));
                int x2Segment = (int) (x1 + t2 * (x2 - x1));
                int y2Segment = (int) (y1 + t2 * (y2 - y1));

				// Déssine la route
				if (i % 2 == 0) 
				{
					// Dessiner une ligne
					if(sommetDepart.getNom().equals("NR")) { g.drawLine(x1Segment + 20, y1Segment + 60, x2Segment + 20, y2Segment + 60); }
                	else { g.drawLine(x1Segment + 20, y1Segment + 60, x2Segment + 20, y2Segment + 60); }
				}

				else
				{
					// Dessiner un point et une ligne
					g.fillOval((x1Segment+20) - 5, (y1Segment+60) - 5, 10, 10);
					if(sommetDepart.getNom().equals("NR")) { g.drawLine(x1Segment + 20, y1Segment + 60, x2Segment + 20, y2Segment + 60); }
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
				g.drawString( sommet.getValeur() + "", sommet.getX() + 16, sommet.getY() + 24);
			}

    	}

		// Dessine les ressources et redessine les sommets avec les images opaques
		if (!this.jetonList.isEmpty())
		{
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
					this.imgSommet = getToolkit().getImage ( "application/ihm/distrib_images/transparent/" + sommet.getNom() + ".png" );
					g.drawImage ( this.imgSommet, sommet.getX() , sommet.getY(), 40, 70, this );
					g.drawString( sommet.getValeur() + "", sommet.getX() + 16, sommet.getY() + 24);
				}

    		}

			for (int i = 1; i < this.sommetList.size(); i++) 
			{
				JetonRessource	j = (JetonRessource) this.jetonList.get(i-1).getType();
				Sommet     		s = this.sommetList.get(i);

				this.imgJeton = getToolkit().getImage ( "application/ihm/distrib_images/ressources/" + j.getLibCourt().toUpperCase() + ".png" );
				g.drawImage ( this.imgJeton, s.getX() + 2 , s.getY() + 35, 35, 35, this);

			}
		}
    }




	// Setter
	public void setSommetList(ArrayList<Sommet> list) { this.sommetList = list; }
	public void setRouteList (ArrayList<Route> list)  { this.routeList  = list; }

	// Getter
    public Sommet getSommetSelectionner (int x, int y)
    {
        for(Sommet sommet : sommetList) 
        {
            int dx = x - sommet.getX();
            int dy = y - sommet.getY();
            if(Math.sqrt(dx*dx + dy*dy) < 10)
            {
                return sommet;
            }
        }

        return null;
    }


	public void mouseDragged(MouseEvent e) 
	{
		if(partieEnCours == true)
		{
			System.out.println("partie en cour");
		}
		else
		{
			if( sommetSelectionner != null)
        	{
		        sommetSelectionner.setX(e.getX() - nvX);
		        sommetSelectionner.setY(e.getY() - nvY);

		        for(Sommet s : sommetList)
		        {
		            if ( s == sommetSelectionner )
		            {
		                s.setX(e.getX());
		                s.setY(e.getY());
		            }
		        }
			}
        this.repaint();
		}
	}


	public void mouseMoved(MouseEvent e) 
	{

	}

	public void mouseClicked(MouseEvent e) 
	{

	}

	public void mousePressed(MouseEvent e) 
	{
		if(partieEnCours == true)
		{
			System.out.println("partie en cour");
		}
		
		else
		{
		    int x = e.getX(); 
		    int y = e.getY();
		    sommetSelectionner = getSommetSelectionner(x, y);

		    if (sommetSelectionner != null)
		    {
		        nvX = x - sommetSelectionner.getX();
		        nvY = y - sommetSelectionner.getY();
		    }
		}
	}

	public void mouseReleased(MouseEvent e) 
	{
		if(partieEnCours == true)
		{
			System.out.println("partie en cour");
		}
		
		else
		{
			sommetSelectionner = null;
		}
	}
	public void mouseEntered(MouseEvent e) 
	{

	}

	public void mouseExited(MouseEvent e) 
	{

	}


}
