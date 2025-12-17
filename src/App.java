import cartes.*;
import strategies.paiement.*;
import facture.Facture;

public class App {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("SYSTÈME DE FIDÉLISATION MAXI");
        System.out.println("=================================================\n");

        CartePoints cartePoints = new CartePoints(
            "Jean Dupont",
            "3800, boulevard Sherbrooke, Montréal");

        CarteAirmiles carteAirmiles = new CarteAirmiles(
            "Marie Tremblay",
            "1234, rue Saint-Denis, Montréal");

        System.out.println("--- Scénario 1: Client SANS carte ---");
        System.out.println("Client paie 100$ en espèces sans carte\n");
        try {
            Facture facture1 = new Facture(100.0, new PaiementCash());
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }

        System.out.println("\n--- Scénario 2: Client avec Carte Points - Paiement Crédit ---");
        System.out.println("Jean paie 100$ par crédit avec sa carte Points\n");
        Facture facture2 = new Facture(100.0, new PaiementCredit(), cartePoints);
        cartePoints.afficherInfos();

        System.out.println("\n--- Scénario 3: Client avec Carte Points - Paiement Cash ---");
        System.out.println("Jean paie 50$ en espèces avec sa carte Points\n");
        Facture facture3 = new Facture(50.0, new PaiementCash(), cartePoints);
        cartePoints.afficherInfos();

        System.out.println("\n--- Scénario 4: Client avec Carte Airmiles - Paiement Crédit ---");
        System.out.println("Marie paie 200$ par crédit avec sa carte Airmiles\n");
        Facture facture4 = new Facture(200.0, new PaiementCredit(), carteAirmiles);
        carteAirmiles.afficherInfos();

        System.out.println("\n--- Scénario 5: Client avec Carte Airmiles - Paiement Cash ---");
        System.out.println("Marie paie 100$ en espèces avec sa carte Airmiles\n");
        Facture facture5 = new Facture(100.0, new PaiementCash(), carteAirmiles);
        carteAirmiles.afficherInfos();

        System.out.println("\n--- Scénario 6: Client avec Carte Points - Paiement Débit ---");
        System.out.println("Jean paie 75$ par débit avec sa carte Points\n");
        Facture facture6 = new Facture(75.0, new PaiementDebit(), cartePoints);
        cartePoints.afficherInfos();

        System.out.println("\n--- Scénario 7: Tentative de paiement par points SANS carte ---");
        System.out.println("Client essaie de payer par points sans avoir de carte\n");
        try {
            Facture facture7 = new Facture(50.0, new PaiementPoint(null));
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur capturée: " + e.getMessage() + "\n");
        }

        System.out.println("\n--- Scénario 8: Paiement par points AVEC carte ---");
        System.out.println("Jean paie 30$ par points avec sa carte\n");
        Facture facture8 = new Facture(30.0, new PaiementPoint(cartePoints), cartePoints);
        cartePoints.afficherInfos();

        System.out.println("\n=================================================");
        System.out.println("RÉSUMÉ FINAL");
        System.out.println("=================================================\n");
        cartePoints.afficherInfos();
        System.out.println();
        carteAirmiles.afficherInfos();

        System.out.println("\n=================================================");
        System.out.println("Démonstration terminée avec succès!");
        System.out.println("=================================================");
    }
}
