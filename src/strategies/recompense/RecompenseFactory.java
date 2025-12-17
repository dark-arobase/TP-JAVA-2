package strategies.recompense;

import cartes.CarteClient;
import cartes.CartePoints;
import cartes.CarteAirmiles;
import strategies.paiement.StrategyPaiement;
import strategies.recompense.RecompensePoints.RecompensePointsCash;
import strategies.recompense.RecompensePoints.RecompensePointsCredit;
import strategies.recompense.RecompensePoints.RecompensePointsDebit;
import strategies.recompense.RecompenseAirmiles.RecompenseAirmilesCash;
import strategies.recompense.RecompenseAirmiles.RecompenseAirmilesCredit;
import strategies.recompense.RecompenseAirmiles.RecompenseAirmilesDebit;

public class RecompenseFactory {
    public static StrategyRecompense creer(CarteClient carte, StrategyPaiement paiement) {
        if (carte == null || paiement == null) return new RecompenseAucune();
        String nom = paiement.getNomPaiement();
        if (carte instanceof CartePoints) {
            switch (nom) {
                case "Crédit":
                    return new RecompensePointsCredit();
                case "Cash":
                    return new RecompensePointsCash();
                default:
                    return new RecompensePointsDebit();
            }
        } else if (carte instanceof CarteAirmiles) {
            switch (nom) {
                case "Crédit":
                    return new RecompenseAirmilesCredit();
                case "Cash":
                    return new RecompenseAirmilesCash();
                default:
                    return new RecompenseAirmilesDebit();
            }
        }
        return new RecompenseAucune();
    }
}
