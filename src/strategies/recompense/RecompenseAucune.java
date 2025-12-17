package strategies.recompense;

public class RecompenseAucune implements StrategyRecompense {
    @Override
    public double calculerRecompense(double montant) {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Aucune récompense";
    }
}
