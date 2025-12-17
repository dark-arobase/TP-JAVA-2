package strategies.recompense.RecompenseAirmiles;

import strategies.recompense.StrategyRecompense;

public class RecompenseAirmilesDebit implements StrategyRecompense {

    @Override
    public double calculerRecompense(double montant) {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Aucune récompense";
    }
}
