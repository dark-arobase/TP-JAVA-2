package strategies.recompense.RecompensePoints;

import strategies.recompense.StrategyRecompense;

public class RecompensePointsDebit implements StrategyRecompense {

    @Override
    public double calculerRecompense(double montant) {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Aucune récompense";
    }
}
