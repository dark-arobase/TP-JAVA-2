import cartes.*;
import strategies.paiement.*;
import strategies.recompense.*;
import facture.Facture;

/**
 * Classe de tests unitaires pour valider le système de fidélisation
 * Vérifie les différents scénarios et règles de récompense
 */
public class TestSystemeFidelisation {
    
    private static int testsReussis = 0;
    private static int testsTotaux = 0;
    
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println("        TESTS DU SYSTÈME DE FIDÉLISATION");
        System.out.println("═══════════════════════════════════════════════════════\n");
        
        // Tests des cartes
        testCreationCartePoints();
        testCreationCarteAirmiles();
        
        // Tests des récompenses Points
        testRecompensePointsCredit();
        testRecompensePointsCash();
        testRecompensePointsDebit();
        
        // Tests des récompenses Airmiles
        testRecompenseAirmilesCredit();
        testRecompenseAirmilesCash();
        testRecompenseAirmilesDebit();
        
        // Tests des paiements sans carte
        testPaiementSansCarte();
        testErreurPaiementPointsSansCarte();
        
        // Tests de paiement par points
        testPaiementParPoints();
        
        // Afficher le résumé
        System.out.println("\n═══════════════════════════════════════════════════════");
        System.out.println("                    RÉSUMÉ");
        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println("Tests réussis: " + testsReussis + "/" + testsTotaux);
        
        if (testsReussis == testsTotaux) {
            System.out.println("\n✅ TOUS LES TESTS SONT RÉUSSIS!");
        } else {
            System.out.println("\n❌ CERTAINS TESTS ONT ÉCHOUÉ!");
        }
        System.out.println("═══════════════════════════════════════════════════════");
    }
    
    private static void testCreationCartePoints() {
        testsTotaux++;
        System.out.println("Test 1: Création d'une carte Points");
        try {
            CartePoints carte = new CartePoints("Test User", "123 rue Test");
            assertTrue(carte.getNombrePoints() == 0, "Points initiaux = 0");
            assertTrue(carte.getNomClient().equals("Test User"), "Nom correct");
            System.out.println("✅ Test réussi\n");
            testsReussis++;
        } catch (Exception e) {
            System.out.println("❌ Test échoué: " + e.getMessage() + "\n");
        }
    }
    
    private static void testCreationCarteAirmiles() {
        testsTotaux++;
        System.out.println("Test 2: Création d'une carte Airmiles");
        try {
            CarteAirmiles carte = new CarteAirmiles("Test User", "123 rue Test");
            assertTrue(carte.getNombreMiles() == 0.0f, "Miles initiaux = 0");
            assertTrue(carte.getNomClient().equals("Test User"), "Nom correct");
            System.out.println("✅ Test réussi\n");
            testsReussis++;
        } catch (Exception e) {
            System.out.println("❌ Test échoué: " + e.getMessage() + "\n");
        }
    }
    
    private static void testRecompensePointsCredit() {
        testsTotaux++;
        System.out.println("Test 3: Récompense Points avec Crédit (2 points/1$)");
        try {
            CartePoints carte = new CartePoints("Test", "Test");
            Facture facture = new Facture(100.0, new PaiementCredit(), carte);
            assertTrue(carte.getNombrePoints() == 200, "100$ × 2 = 200 points");
            System.out.println("✅ Test réussi\n");
            testsReussis++;
        } catch (Exception e) {
            System.out.println("❌ Test échoué: " + e.getMessage() + "\n");
        }
    }
    
    private static void testRecompensePointsCash() {
        testsTotaux++;
        System.out.println("Test 4: Récompense Points avec Cash (1 point/1$)");
        try {
            CartePoints carte = new CartePoints("Test", "Test");
            Facture facture = new Facture(100.0, new PaiementCash(), carte);
            assertTrue(carte.getNombrePoints() == 100, "100$ × 1 = 100 points");
            System.out.println("✅ Test réussi\n");
            testsReussis++;
        } catch (Exception e) {
            System.out.println("❌ Test échoué: " + e.getMessage() + "\n");
        }
    }
    
    private static void testRecompensePointsDebit() {
        testsTotaux++;
        System.out.println("Test 5: Récompense Points avec Débit (1 point/1$)");
        try {
            CartePoints carte = new CartePoints("Test", "Test");
            Facture facture = new Facture(100.0, new PaiementDebit(), carte);
            assertTrue(carte.getNombrePoints() == 100, "100$ × 1 = 100 points");
            System.out.println("✅ Test réussi\n");
            testsReussis++;
        } catch (Exception e) {
            System.out.println("❌ Test échoué: " + e.getMessage() + "\n");
        }
    }
    
    private static void testRecompenseAirmilesCredit() {
        testsTotaux++;
        System.out.println("Test 6: Récompense Airmiles avec Crédit (2 miles/1$)");
        try {
            CarteAirmiles carte = new CarteAirmiles("Test", "Test");
            Facture facture = new Facture(100.0, new PaiementCredit(), carte);
            assertTrue(carte.getNombreMiles() == 200.0f, "100$ × 2 = 200 miles");
            System.out.println("✅ Test réussi\n");
            testsReussis++;
        } catch (Exception e) {
            System.out.println("❌ Test échoué: " + e.getMessage() + "\n");
        }
    }
    
    private static void testRecompenseAirmilesCash() {
        testsTotaux++;
        System.out.println("Test 7: Récompense Airmiles avec Cash (1 mile/2$)");
        try {
            CarteAirmiles carte = new CarteAirmiles("Test", "Test");
            Facture facture = new Facture(100.0, new PaiementCash(), carte);
            assertTrue(carte.getNombreMiles() == 50.0f, "100$ ÷ 2 = 50 miles");
            System.out.println("✅ Test réussi\n");
            testsReussis++;
        } catch (Exception e) {
            System.out.println("❌ Test échoué: " + e.getMessage() + "\n");
        }
    }
    
    private static void testRecompenseAirmilesDebit() {
        testsTotaux++;
        System.out.println("Test 8: Récompense Airmiles avec Débit (1 mile/2$)");
        try {
            CarteAirmiles carte = new CarteAirmiles("Test", "Test");
            Facture facture = new Facture(100.0, new PaiementDebit(), carte);
            assertTrue(carte.getNombreMiles() == 50.0f, "100$ ÷ 2 = 50 miles");
            System.out.println("✅ Test réussi\n");
            testsReussis++;
        } catch (Exception e) {
            System.out.println("❌ Test échoué: " + e.getMessage() + "\n");
        }
    }
    
    private static void testPaiementSansCarte() {
        testsTotaux++;
        System.out.println("Test 9: Paiement sans carte (pas de récompense)");
        try {
            Facture facture = new Facture(100.0, new PaiementCash());
            assertTrue(facture.getCarte() == null, "Aucune carte associée");
            System.out.println("✅ Test réussi\n");
            testsReussis++;
        } catch (Exception e) {
            System.out.println("❌ Test échoué: " + e.getMessage() + "\n");
        }
    }
    
    private static void testErreurPaiementPointsSansCarte() {
        testsTotaux++;
        System.out.println("Test 10: Erreur paiement par points sans carte");
        try {
            Facture facture = new Facture(100.0, new PaiementPoint(null));
            System.out.println("❌ Test échoué: Exception attendue mais non levée\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Test réussi: Exception correctement levée\n");
            testsReussis++;
        } catch (Exception e) {
            System.out.println("❌ Test échoué: Mauvais type d'exception: " + e.getMessage() + "\n");
        }
    }
    
    private static void testPaiementParPoints() {
        testsTotaux++;
        System.out.println("Test 11: Paiement par points (pas de récompense)");
        try {
            CartePoints carte = new CartePoints("Test", "Test");
            // Ajouter quelques points d'abord
            Facture facture1 = new Facture(100.0, new PaiementCredit(), carte);
            int pointsApres = carte.getNombrePoints();
            
            // Paiement par points
            Facture facture2 = new Facture(50.0, new PaiementPoint(carte), carte);
            
            // Les points ne doivent pas changer
            assertTrue(carte.getNombrePoints() == pointsApres, 
                      "Points inchangés après paiement par points");
            System.out.println("✅ Test réussi\n");
            testsReussis++;
        } catch (Exception e) {
            System.out.println("❌ Test échoué: " + e.getMessage() + "\n");
        }
    }
    
    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError("Assertion échouée: " + message);
        }
    }
}
