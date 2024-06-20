package src.metier;


import java.util.ArrayList;
public class Sommet
{
    private static  int    nbSommet = 0;
    private         int    num;
    private         String nom;
    private         int    x;
    private         int    y;
    private         int    valeur;
    private         Jeton  jeton;

    private ArrayList<Route> listeRoute;

    public Sommet(String nom, int valeur, int x, int y)
    {
        this.nom = nom;
        this.num = ++ nbSommet;
        this.valeur = valeur;
        this.x = x;
        this.y = y;
        this.jeton = null;
    }


	// Accesseurs  
    public String   getNom()        { return this.nom;    }
    public int      getNumSommet()  { return this.num;    }
    public int      getX()          { return this.x;      }
    public int      getY()          { return this.y;      }
    public int      getValeur()     { return this.valeur; }
    public Jeton    getJeton()      { return this.jeton;  }
    public ArrayList<Route> getListeRoute() {return this.listeRoute;}

    public void setX    (int x)     { if(x >= 0 && x <= 1000) this.x = x; }
    public void setY    (int y)     { if(y >= 0 && y <= 884 ) this.y = y; }
    public void setJeton(Jeton j)   { if (j != null) this.jeton = j; }

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
