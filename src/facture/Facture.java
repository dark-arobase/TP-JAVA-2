package facture;

import cartes.CarteClient;
import strategies.paiement.StrategyPaiement;
import strategies.paiement.PaiementPoint;

public class Facture {
    private CarteClient carte;
    private double montant;
    private StrategyPaiement strategyPaiement;

    public Facture(double montant, StrategyPaiement modePaiement) {
        if (modePaiement instanceof PaiementPoint) {
            throw new IllegalArgumentException(
                "Erreur: Le paiement par points nécessite une carte client!");
        }

        this.montant = montant;
        this.strategyPaiement = modePaiement;
        this.carte = null;

        if (strategyPaiement.effectuerPaiement(montant)) {
            System.out.println("Le paiement par " + modePaiement.getNomPaiement() + 
                             " a été fait avec succès");
            System.out.println("Montant payé: " + montant + "$");
            System.out.println("Aucune récompense appliquée (pas de carte client).\n");
        }
    }

    public Facture(double montant, StrategyPaiement modePaiement, CarteClient client) {
        this.montant = montant;
        this.strategyPaiement = modePaiement;
        this.carte = client;

        if (strategyPaiement.effectuerPaiement(montant)) {
            System.out.println("Le paiement par " + modePaiement.getNomPaiement() + 
                             " a été fait avec succès");
            System.out.println("Montant payé: " + montant + "$");

            if (carte != null) {
                carte.recompenser(this);
            }
            System.out.println();
        }
    }

    public double getMontant() {
        return montant;
    }

    public CarteClient getCarte() {
        return carte;
    }

    public StrategyPaiement getStrategyPaiement() {
        return strategyPaiement;
    }
}
