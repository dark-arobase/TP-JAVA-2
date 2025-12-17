package strategies.paiement;

public class PaiementCredit extends StrategyPaiement {

    @Override
    public boolean effectuerPaiement(double montant) {
        System.out.println("Paiement de " + montant + "$ par carte de crédit effectué.");
        return true;
    }

    @Override
    public String getNomPaiement() {
        return "Crédit";
    }
}
