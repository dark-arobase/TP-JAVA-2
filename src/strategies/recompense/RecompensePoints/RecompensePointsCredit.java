package strategies.recompense.RecompensePoints;

import strategies.recompense.StrategyRecompense;

public class RecompensePointsCredit implements StrategyRecompense {

    @Override
    public double calculerRecompense(double montant) {
        return montant * 2;
    }

    @Override
    public String getDescription() {
        return "2 points pour 1$ (Crédit)";
    }
}
