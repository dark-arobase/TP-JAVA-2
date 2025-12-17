package cartes;

public class CarteAirmiles extends CarteClient {

    private float nombreMiles;

    public CarteAirmiles(String nomClient, String adresse) {
        super(nomClient, adresse);
        this.nombreMiles = 0.00f;
    }

    public CarteAirmiles(String nomClient, String adresse, float milesInitiaux) {
        super(nomClient, adresse);
        this.nombreMiles = milesInitiaux;
    }

    @Override
    protected void ajouterRecompense(double recompense) {
        this.nombreMiles += (float) recompense;
    }

    @Override
    protected String getUniteRecompense() {
        return "miles";
    }

    public float getNombreMiles() {
        return nombreMiles;
    }

    public void setNombreMiles(float nombreMiles) {
        this.nombreMiles = nombreMiles;
    }

    @Override
    public void afficherInfos() {
        System.out.println("=== Carte Airmiles ===");
        System.out.println("Client: " + getNomClient());
        System.out.println("Adresse: " + getAdresseClient());
        System.out.println("Miles accumulés: " + nombreMiles);
        System.out.println("======================");
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
            s = new strategies.recompense.RecompenseAirmiles.RecompenseAirmilesCredit();
        } else if (nom.equals("Cash")) {
            s = new strategies.recompense.RecompenseAirmiles.RecompenseAirmilesCash();
        } else if (nom.equals("Débit")) {
            s = new strategies.recompense.RecompenseAirmiles.RecompenseAirmilesDebit();
        } else {
            s = new strategies.recompense.RecompenseAucune();
        }
        setStrategyRecompense(s);
        appliquerRecompense(f.getMontant());
    }
}
