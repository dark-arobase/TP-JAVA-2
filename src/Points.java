public class Points extends CarteClient {

    private int nombrePoint;

    public Points(String nomClient, String adresse) {
        super(nomClient, adresse);
        this.nombrePoint = 0;
    }

    public int getNombrePoint() {
        return nombrePoint;
    }

    public void incrementerPoints(int pts) {
        this.nombrePoint += pts;
    }

    @Override
    public void afficherInfo() {
        System.out.println("Carte Points de " + getNomClient());
        System.out.println("Adresse : " + getAdresseClient());
        System.out.println("Points accumulés : " + nombrePoint);
        System.out.println("--------------------------------");
    }

    @Override
    public String getTypeCarte() {
        return "Points";
    }
}
