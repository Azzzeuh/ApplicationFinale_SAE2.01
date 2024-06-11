import java.util.ArrayList;
import java.util.Collections;

public class Pioche {
    private ArrayList<Jeton> jetons;

    public Pioche() {
        this.jetons = new ArrayList<>();
        this.initPioche();
    }

    public Jeton tirerJeton() {
        if (jetons.isEmpty()) {
            return null; // ou lever une exception

        }
        return jetons.remove(0);
    }

    private void initPioche() {
        jetons.add(new Jeton(JetonRessource.Al));
        jetons.add(new Jeton(JetonRessource.Ag));
        jetons.add(new Jeton(JetonRessource.Au));
        jetons.add(new Jeton(JetonRessource.Co));
        jetons.add(new Jeton(JetonRessource.Fe));
        jetons.add(new Jeton(JetonRessource.Ni));
        jetons.add(new Jeton(JetonRessource.Pt));
        jetons.add(new Jeton(JetonRessource.Ti));

        Collections.shuffle(jetons);
    }

}

// fini