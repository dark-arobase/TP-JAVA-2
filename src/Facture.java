public class Facture {
    
    private CarteClient carte;
    private double montant;
    private ModePaiement modePaiement;
    
    public Facture(double montant, ModePaiement modePaiement) {
        if (modePaiement == ModePaiement.POINTS) {
            throw new IllegalArgumentException("Le paiement par points nécessite une carte client!");
        }
        this.montant = montant;
        this.modePaiement = modePaiement;
        this.carte = null;
        System.out.println("Le payement par " + modePaiement.getLibelle() + " a été fait avec succès.");
    }
    
    public Facture(double montant, ModePaiement modePaiement, CarteClient carte) {
        this.montant = montant;
        this.modePaiement = modePaiement;
        this.carte = carte;

        StrategieRecompense strategie = RecompenseFactory.getStrategie(carte, modePaiement);
        String messageRecompense = strategie.appliquer(this);

        System.out.println("Le payement par " + modePaiement.getLibelle() + " a été fait avec succès.");
        if (messageRecompense != null && !messageRecompense.isEmpty()) {
            System.out.println(messageRecompense);
        }

        System.out.println("Détails : Montant = " + String.format("%.2f", montant) + "$, Mode = " + modePaiement.getLibelle());
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



