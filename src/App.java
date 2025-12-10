public class App {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("SYSTÈME DE FIDÉLISATION MAXI - Scénarios");
        System.out.println("==============================================\n");

        // Création des cartes clients
        Points carteJean = new Points("Jean Tremblay", "3800, boulevard Sherbrooke, Montréal");
        Airmiles carteMarie = new Airmiles("Marie Dupont", "1234, rue Saint-Denis, Montréal");

        // ---------------------------------------------
        System.out.println("--- SCÉNARIO 1: Client sans carte ---");
        new Facture(50.0, ModePaiement.CASH);

        // ---------------------------------------------
        System.out.println("\n--- SCÉNARIO 2: Carte Points avec paiement crédit ---");
        new Facture(100.0, ModePaiement.CREDIT, carteJean);
        carteJean.afficherInfo();

        // ---------------------------------------------
        System.out.println("\n--- SCÉNARIO 3: Carte Points avec paiement cash ---");
        new Facture(75.0, ModePaiement.CASH, carteJean);
        carteJean.afficherInfo();

        // ---------------------------------------------
        System.out.println("\n--- SCÉNARIO 4: Carte AirMiles avec paiement crédit ---");
        new Facture(150.0, ModePaiement.CREDIT, carteMarie);
        carteMarie.afficherInfo();

        // ---------------------------------------------
        System.out.println("\n--- SCÉNARIO 5: Carte AirMiles avec paiement cash ---");
        new Facture(200.0, ModePaiement.CASH, carteMarie);
        carteMarie.afficherInfo();

        // ---------------------------------------------
        System.out.println("\n--- SCÉNARIO 6: Carte Points avec paiement débit ---");
        new Facture(50.0, ModePaiement.DEBIT, carteJean);
        carteJean.afficherInfo();

        // ---------------------------------------------
        System.out.println("\n--- SCÉNARIO 7: Test d'exception (paiement par points sans carte) ---");
        try {
            new Facture(100.0, ModePaiement.POINTS);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur attendue: " + e.getMessage());
        }

        System.out.println("\nFin du programme (scénarios terminés).");
    }
}

