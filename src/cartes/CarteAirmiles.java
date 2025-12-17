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
        appliquerRecompense(f.getMontant());
        System.out.println("Vous avez accumulé " + getNombreMiles() + " miles\n");
    }
}
