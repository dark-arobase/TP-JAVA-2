public abstract class CarteClient {
    private String NomClient;
    private String AdresseClient;
    
    public CarteClient(String NomClient, String AdresseClient) {
        this.NomClient = NomClient;
        this.AdresseClient = AdresseClient;
    }
    public String getNomClient() {
        return NomClient;
    }
    
    public String getAdresseClient() {
        return AdresseClient;
    }
    
    public abstract void afficherInfo();
    
    public abstract String getTypeCarte();
}