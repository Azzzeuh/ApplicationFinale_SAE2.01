import java.util.ArrayList;
public class Mine
{
    private static int nbMine = 0;
    private int num;
    private String nomMine;
    private int x;
    private int y;

    private ArrayList<Route> listeRoute;

    public Mine(String nomMine, int x, int y)
    {
        this.nomMine = nomMine;
        this.num = ++ nbMine;
        this.x = x;
        this.y = y;
    }

	// Accesseurs
    public String getNom()                {return this.nomMine;   }
    public int getX()                     {return this.x;         }
    public int getY()                     {return this.y;         }
    public int getNumMine()               {return this.nbMine;    }
    public ArrayList<Route> getListeMine(){return this.listeRoute;}
    public Mine getMine()                 {return this;}


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
}
