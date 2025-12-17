package strategies.recompense.RecompenseAirmiles;

import strategies.recompense.StrategyRecompense;

public class RecompenseAirmilesCash implements StrategyRecompense {

    @Override
    public double calculerRecompense(double montant) {
        return montant / 2;
    }

    @Override
    public String getDescription() {
        return "1 mile pour 2$ (Cash)";
    }
}
