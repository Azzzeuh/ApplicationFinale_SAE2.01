package application.metier;


import java.util.ArrayList;
public class Sommet
{
    private static  int    nbSommet = 0;
    private         int    num;
    private         String nom;
    private         int    x;
    private         int    y;
    private         int    valeur;

    private ArrayList<Route> listeRoute;

    public Sommet(String nom, int valeur, int x, int y)
    {
        this.nom = nom;
        this.num = ++ nbSommet;
        this.valeur = valeur;
        this.x = x;
        this.y = y;
    }

    // Constructeur nouvelle rome
    public Sommet(String nom, int x, int y)
    {
        this.nom = nom;
        this.num = ++ nbSommet;
        this.valeur = -1;
        this.x = x;
        this.y = y;
    }

	// Accesseurs  
    public String getNom()    { return this.nom;    }
    public int getNumSommet() { return this.num;    }
    public int getX()         { return this.x;      }
    public int getY()         { return this.y;      }
    public int getValeur()    { return this.valeur; }
    public ArrayList<Route> getListeRoute() {return this.listeRoute;}

    public static void resetNbSommet() { nbSommet = 0; }

    public boolean ajouterRoute(Route route)
    {
        if(route != null)
        {
            this.listeRoute.add(route);
            return true;
        }
        return false;
    }

    public boolean supprimerRoute(Route route)
    {
        if(route != null)
        {
            this.listeRoute.remove(route);
            return true;
        }
        return false;
    }

    public String toString()
    {
        String sSommet = "";

        sSommet += "Numéro   : " + this.getNumSommet() + '\n' 
                 + "Nom      : " + this.nom + '\n';
                
        if (this.valeur > 0)
            sSommet += "Valeur   : " + this.valeur + '\n';
                
        sSommet += "Coord. X : " + this.x   + '\n' 
                 + "Coord. Y : " + this.y   + '\n'; 

        return sSommet;
    }
}
