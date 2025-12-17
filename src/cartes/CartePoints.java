package cartes;

public class CartePoints extends CarteClient {

    private int nombrePoints;

    public CartePoints(String nomClient, String adresse) {
        super(nomClient, adresse);
        this.nombrePoints = 0;
    }

    public CartePoints(String nomClient, String adresse, int pointsInitiaux) {
        super(nomClient, adresse);
        this.nombrePoints = pointsInitiaux;
    }

    @Override
    protected void ajouterRecompense(double recompense) {
        this.nombrePoints += (int) recompense;
    }

    @Override
    protected String getUniteRecompense() {
        return "points";
    }

    public int getNombrePoints() {
        return nombrePoints;
    }

    public void setNombrePoints(int nombrePoints) {
        this.nombrePoints = nombrePoints;
    }

    @Override
    public void afficherInfos() {
        System.out.println("=== Carte Points ===");
        System.out.println("Client: " + getNomClient());
        System.out.println("Adresse: " + getAdresseClient());
        System.out.println("Points accumulés: " + nombrePoints);
        System.out.println("===================");
    }

    @Override
    public void recompenser(facture.Facture f) {
        strategies.recompense.StrategyRecompense s;
        strategies.paiement.StrategyPaiement p = f.getStrategyPaiement();
        String nom = p.getNomPaiement();
        if (p instanceof strategies.paiement.PaiementPoint) {
            System.out.println("Aucune récompense pour paiement par points.");
            return;
        }
        if (nom.equals("Crédit")) {
            s = new strategies.recompense.RecompensePoints.RecompensePointsCredit();
        } else if (nom.equals("Cash")) {
            s = new strategies.recompense.RecompensePoints.RecompensePointsCash();
        } else if (nom.equals("Débit")) {
            s = new strategies.recompense.RecompensePoints.RecompensePointsDebit();
        } else {
            s = new strategies.recompense.RecompenseAucune();
        }
        setStrategyRecompense(s);
        appliquerRecompense(f.getMontant());
    }
}
