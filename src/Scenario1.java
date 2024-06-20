package src;

public class Scenario1 {

    private int etapes;

    public Scenario1()
    {
        new FrameScenario(50, 815, this.etapes, 1);
        this.etapes = 0;
    }

    public Scenario1(int etapes)
    {
        new FrameScenario(50, 815, this.etapes, 1);
        this.etapes = etapes;
    }


    public static void main(String[] args) {

        if (args.length > 0) {
            // Convertit l'argument en entier
            int etape = Integer.parseInt(args[0]);
            // Crée une nouvelle instance de Scenario1 avec l'étape spécifiée
            new Scenario1(etape);
        }
        else { new Scenario1(); }
    }
}
