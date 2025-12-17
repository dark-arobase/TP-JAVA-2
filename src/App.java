import cartes.*;
import strategies.paiement.*;
import facture.Facture;

public class App {
    public static void main(String[] args) {

        CartePoints cartePoints = new CartePoints(
            "Eric Cartman",
            "7643, boulevard Lacordaire, Montréal");

        CarteAirmiles carteAirmiles = new CarteAirmiles(
            "Anabelle Tremblay",
            "1234, rue Saint-Denis, Montréal");

        System.out.println("--- Scénario 1: Client SANS carte ---");
        new Facture(100.0, new PaiementCash());
    

        System.out.println("\n--- Scénario 2: Client avec Carte Points - Paiement Crédit ---");
        new Facture(100.0, new PaiementCredit(), cartePoints);
        

        System.out.println("\n--- Scénario 3: Client avec Carte Points - Paiement Cash ---");
        new Facture(50.0, new PaiementCash(), cartePoints);
 
        System.out.println("\n--- Scénario 4: Client avec Carte Airmiles - Paiement Crédit ---");
        new Facture(200.0, new PaiementCredit(), carteAirmiles);

        System.out.println("\n--- Scénario 5: Client avec Carte Airmiles - Paiement Cash ---");
        new Facture(100.0, new PaiementCash(), carteAirmiles);

        System.out.println("\n--- Scénario 6: Client avec Carte Points - Paiement Débit ---");
        new Facture(75.0, new PaiementDebit(), cartePoints);

        System.out.println("\n--- Scénario 7: Tentative de paiement par points SANS carte ---");
        new Facture(20.0, new PaiementPoint(null));
        

        System.out.println("\n--- Scénario 8: Paiement par points AVEC carte ---");
        new Facture(30.0, new PaiementPoint(cartePoints), cartePoints);
        
    }
}
