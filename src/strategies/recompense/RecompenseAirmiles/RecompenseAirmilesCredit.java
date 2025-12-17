package strategies.recompense.RecompenseAirmiles;

import strategies.recompense.StrategyRecompense;

public class RecompenseAirmilesCredit implements StrategyRecompense {

    @Override
    public double calculerRecompense(double montant) {
        return montant * 2;
    }

    @Override
    public String getDescription() {
        return "2 miles pour 1$ (Crédit)";
    }
}
