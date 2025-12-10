public class Facture {
    /*la carte c de type carte
    le montant
    Strategy de payment*/
    /**
 * Classe Facture
 * Gère la facturation et l'application des récompenses via le patron Strategy
 */

    private CarteClient carte;
    private double montant;
    private ModePaiement modePaiement;
    //private StrategieRecompense strategieRecompense;
    
    
    public Facture(double montant, ModePaiement modePaiement) {

        if (modePaiement == ModePaiement.POINTS) {
            throw new IllegalArgumentException(
            "Le paiement par points nécessite une carte client!");
        }
        
        this.montant = montant;
        this.modePaiement = modePaiement;
        this.carte = null;
        //this.strategieRecompense = new AucuneRecompense();
        
        System.out.println("Le payement par " + modePaiement.getLibelle() + " a été fait avec succès.");

    }
    
    /**
     * Constructeur pour un client avec carte
     */
    public Facture(double montant, ModePaiement modePaiement, CarteClient carte) {
        this.montant = montant;
        this.modePaiement = modePaiement;
        this.carte = carte;

        // Application automatique de la récompense via une stratégie
        StrategieRecompense strategie = RecompenseFactory.getStrategie(carte, modePaiement);
        String messageRecompense = strategie.appliquer(this);

        System.out.println("Le payement par " + modePaiement.getLibelle() + " a été fait avec succès.");
        if (messageRecompense != null && !messageRecompense.isEmpty()) {
            System.out.println(messageRecompense);
        }

        // Afficher plus d'informations : montant, mode, et total mis à jour
        System.out.println("Détails : Montant = " + montant + "$, Mode = " + modePaiement.getLibelle());
        if (carte != null) {
            if (carte instanceof Points) {
                Points p = (Points) carte;
                System.out.println("Total points après transaction : " + p.getNombrePoint());
            } else if (carte instanceof Airmiles) {
                Airmiles a = (Airmiles) carte;
                System.out.println("Total miles après transaction : " + a.getNombreMile());
            }
        }
    }
    
    // Getters
    public double getMontant() {
        return montant;
    }
    
    public ModePaiement getModePaiement() {
        return modePaiement;
    }
    
    public CarteClient getCarte() {
        return carte;
    }
    
}



