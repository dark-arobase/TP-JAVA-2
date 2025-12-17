package strategies.paiement;

public class PaiementDebit extends StrategyPaiement {

    @Override
    public boolean effectuerPaiement(double montant) {
        System.out.println("Paiement de " + montant + "$ par carte de débit effectué.");
        return true;
    }

    @Override
    public String getNomPaiement() {
        return "Débit";
    }
}
