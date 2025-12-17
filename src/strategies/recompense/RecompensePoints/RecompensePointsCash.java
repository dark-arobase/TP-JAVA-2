package strategies.recompense.RecompensePoints;

import strategies.recompense.StrategyRecompense;

public class RecompensePointsCash implements StrategyRecompense {

    @Override
    public double calculerRecompense(double montant) {
        return montant;
    }

    @Override
    public String getDescription() {
        return "1 point pour 1$ (Cash)";
    }
}
