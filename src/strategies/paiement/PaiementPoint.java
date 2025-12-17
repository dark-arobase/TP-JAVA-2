package strategies.paiement;

import cartes.CarteClient;

public class PaiementPoint extends StrategyPaiement {
    private CarteClient carte;

    public PaiementPoint(CarteClient carte) {
        this.carte = carte;
    }

    
    @Override
    public boolean effectuerPaiement(double montant) {
        if (carte == null) {
            System.out.println("Erreur: Aucune carte client pour paiement par points!");
            return false;
        }
        System.out.println("Paiement de " + montant + "$ par points de fidélité effectué.");
        return true;
    }


    @Override
    public String getNomPaiement() {
        return "Points";
    }
}
