public class Airmiles extends CarteClient {

    private double nombreMile;

    public Airmiles(String nomClient, String adresse) {
        super(nomClient, adresse);
        this.nombreMile = 0.00;
    }

    public double getNombreMile() {
        return nombreMile;
    }

    public void ajouterMiles(double miles) {
        this.nombreMile += miles;
    }

    @Override
    public void afficherInfo() {
        System.out.println("Carte Airmiles de " + getNomClient());
        System.out.println("Adresse : " + getAdresseClient());
        System.out.println("Miles accumulés : " + nombreMile);
        System.out.println("--------------------------------");
    }

    @Override
    public String getTypeCarte() {
        return "Airmiles";
    }
}

