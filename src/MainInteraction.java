import java.util.Scanner;

public class MainInteraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==============================================");
        System.out.println("SYSTÈME DE FIDÉLISATION MAXI - Mode interactif");
        System.out.println("==============================================\n");

        boolean continuer = true;
        while (continuer) {
            try {
                System.out.print("Entrez le montant de la facture (ex: 45.50) : ");
                double montant = Double.parseDouble(sc.nextLine().trim());

                // Carte
                System.out.print("Le client présente-t-il une carte ? (o/n) : ");
                String reponseCarte = sc.nextLine().trim().toLowerCase();
                CarteClient carte = null;
                if (reponseCarte.equals("o") || reponseCarte.equals("y")) {
                    System.out.print("Type de carte - 1: Points, 2: Airmiles. Votre choix : ");
                    String type = sc.nextLine().trim();
                    System.out.print("Nom du client : ");
                    String nom = sc.nextLine().trim();
                    System.out.print("Adresse du client : ");
                    String adresse = sc.nextLine().trim();
                    if (type.equals("1")) {
                        carte = new Points(nom, adresse);
                    } else if (type.equals("2")) {
                        carte = new Airmiles(nom, adresse);
                    } else {
                        System.out.println("Type invalide — on continue sans carte.");
                    }
                }

                // Mode de paiement
                System.out.println("\nSélectionnez le mode de paiement :");
                System.out.println("1 - CASH");
                System.out.println("2 - DEBIT");
                System.out.println("3 - CREDIT");
                System.out.println("4 - POINTS");
                System.out.print("Votre choix : ");
                String choixMode = sc.nextLine().trim();
                ModePaiement mode = null;
                switch (choixMode) {
                    case "1": mode = ModePaiement.CASH; break;
                    case "2": mode = ModePaiement.DEBIT; break;
                    case "3": mode = ModePaiement.CREDIT; break;
                    case "4": mode = ModePaiement.POINTS; break;
                    default:
                        System.out.println("Mode invalide — utilisation par défaut: CASH");
                        mode = ModePaiement.CASH;
                }

                // Vérification règle : paiement par points nécessite une carte
                if (mode == ModePaiement.POINTS && carte == null) {
                    System.out.println("Impossible : paiement par points sans carte. Opération annulée.");
                } else {
                    // Création facture
                    Facture facture;
                    if (carte == null) {
                        facture = new Facture(montant, mode);
                    } else {
                        facture = new Facture(montant, mode, carte);
                    }

                    // Afficher détails
                    System.out.println("\n--- Récapitulatif de la facture ---");
                    System.out.println("Montant : " + montant);
                    System.out.println("Mode : " + mode.getLibelle());
                    if (carte != null) {
                        carte.afficherInfo();
                    } else {
                        System.out.println("Aucune carte fournie.");
                    }
                }

            } catch (NumberFormatException ex) {
                System.out.println("Montant invalide. Réessayez.");
            } catch (IllegalArgumentException ex) {
                System.out.println("Erreur : " + ex.getMessage());
            }

            System.out.print("Voulez-vous traiter une autre facture ? (o/n) : ");
            String rep = sc.nextLine().trim().toLowerCase();
            if (!(rep.equals("o") || rep.equals("y"))) {
                continuer = false;
            }
            System.out.println();
        }

        System.out.println("Fin du mode interactif. Merci.");
        sc.close();
    }
}
