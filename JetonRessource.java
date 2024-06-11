public enum JetonRessource implements IRessource
{
    Al("aluminium"),
    Ag("argent"),
    Au("or"),
    Co("cobalt"),
    Fe("fer"),
    Ni("nickel"),
    Pt("Platine"),
    Ti("Titane");

    private String nom;

    JetonRessource (String nom)
    {
        this.nom = nom;
    }

    public String getNom()
    {
        return this.nom;
    }

    public String toString()
    {
        return this.nom;
    }
    
}