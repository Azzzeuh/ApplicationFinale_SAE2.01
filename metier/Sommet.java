package metier;


import java.util.ArrayList;
public class Sommet
{
    private static int    nbSommet = 0;
    private        int    num;
    private        String nom;
    private        int    x;
    private        int    y;

    private ArrayList<Route> listeRoute;

    public Sommet(String nom, int x, int y)
    {
        this.nom = nom;
        this.num = ++ nbSommet;
        this.x = x;
        this.y = y;
    }

	// Accesseurs
    public String getNom()    { return this.nom; }
    public int getNumSommet() { return this.num; }
    public int getX()         { return this.x;   }
    public int getY()         { return this.y;   }
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
                 + "Nom      : " + this.nom + '\n' 
                 + "Coord. X : " + this.x   + '\n' 
                 + "Coord. Y : " + this.y   + '\n'; 

        return sSommet;
    }
}
