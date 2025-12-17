package strategies.paiement;

public class PaiementCash extends StrategyPaiement {

    @Override
    public boolean effectuerPaiement(double montant) {
        System.out.println("Paiement de " + montant + "$ en espèces effectué.");
        return true;
    }

    @Override
    public String getNomPaiement() {
        return "Cash";
    }
}
