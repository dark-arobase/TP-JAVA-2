package strategies.paiement;

public abstract class StrategyPaiement {
    public abstract boolean effectuerPaiement(double montant);
    public abstract String getNomPaiement();
}
