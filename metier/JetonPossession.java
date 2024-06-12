package metier;

public class JetonPossession implements IRessource {

    private static final int NB_JETONP_ASTRAL = 25;
    private static final int NB_JETONP_SOLAIRE = 25;


    private static int nbJetonAstral = NB_JETONP_ASTRAL;
    private static int nbJetonSolaire = NB_JETONP_SOLAIRE;
    private String type;


    public JetonPossession(char c)
    {
        if(c == 'A')
            this.type = "astral";
        else if (c == 'S')
            this.type = "solaire";
    }

    public String getType() { return this.type; }

    public String poseJetonPAstral() 
    {
        nbJetonAstral--;
        return this.getType();
    }

    public String poseJetonPSolaire() 
    {
        nbJetonSolaire--;
        return this.getType();
    }
}
