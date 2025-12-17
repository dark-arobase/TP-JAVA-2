package facture;

import cartes.CarteClient;
import strategies.paiement.StrategyPaiement;
import strategies.recompense.RecompenseFactory;

public class Facture {
    private CarteClient carte;
    private double montant;
    private StrategyPaiement strategyPaiement;

    public Facture(double montant, StrategyPaiement modePaiement) {
        this.montant = montant;
        this.strategyPaiement = modePaiement;
        this.carte = null;

        boolean success = strategyPaiement.effectuerPaiement(montant);
        if (success) {
            System.out.println("Le paiement par " + modePaiement.getNomPaiement() + 
                             " a été fait avec succès");
            System.out.println("Montant payé: " + montant + "$");
            System.out.println("Aucune récompense appliquée (pas de carte client).\n");
        } else {
            System.out.println("Le paiement par " + modePaiement.getNomPaiement() + " a échoué.\n");
        }
    }

    public Facture(double montant, StrategyPaiement modePaiement, CarteClient client) {
        this.montant = montant;
        this.strategyPaiement = modePaiement;
        this.carte = client;

        boolean success = strategyPaiement.effectuerPaiement(montant);
        if (success) {
            System.out.println("Le paiement par " + modePaiement.getNomPaiement() + 
                             " a été fait avec succès");
            System.out.println("Montant payé: " + montant + "$");

            if (carte != null) {
                // Déterminer et assigner la stratégie de récompense avant d'appliquer
                strategies.recompense.StrategyRecompense sr = RecompenseFactory.creer(carte, modePaiement);
                carte.setStrategyRecompense(sr);
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
