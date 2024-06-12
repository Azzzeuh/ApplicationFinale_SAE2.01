import java.util.ArrayList;
import java.util.Collections;

public class Pioche {
	private ArrayList<Jeton> jetons;

	public Pioche() {
		this.jetons = new ArrayList<>();
		this.initPioche();
	}

	public Jeton tirerJeton() {
		if (this.jetons.isEmpty()) {
			return null;
		} else {
			return this.jetons.remove(0);
		}
	}

	private void initPioche() {
		for (int cpt = 0; cpt < 8; cpt++) {
			jetons.add(new Jeton(JetonRessource.Nr));
		}

		for (int cpt = 0; cpt < 4; cpt++) {
			jetons.add(new Jeton(JetonRessource.Al));
			jetons.add(new Jeton(JetonRessource.Ag));
			jetons.add(new Jeton(JetonRessource.Au));
			jetons.add(new Jeton(JetonRessource.Co));
			jetons.add(new Jeton(JetonRessource.Fe));
			jetons.add(new Jeton(JetonRessource.Ni));
			jetons.add(new Jeton(JetonRessource.Pt));
			jetons.add(new Jeton(JetonRessource.Ti));
		}

		Collections.shuffle(jetons);
	}
<<<<<<< HEAD

}
=======
}


>>>>>>> f402761aeffe95b87aa368b4578eb07872d0cb42
