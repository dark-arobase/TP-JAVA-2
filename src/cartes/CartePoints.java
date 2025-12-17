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
        appliquerRecompense(f.getMontant());
        System.out.println("Vous avez accumulé " + getNombrePoints() + " points\n");
    }
}
