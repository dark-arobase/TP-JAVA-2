public abstract class CarteClient {
    private String NomClient;
    private String AdresseClient;
        

    //constructeur


    // methodes 
    /*
    i.	un constructeur, qui nécessite le nom et adresse du client. 
    ii.	une méthode abstract nommée récompenser (Facture f).
    */ 
    
    public CarteClient(String NomClient, String AdresseClient) {
        this.NomClient = NomClient;
        this.AdresseClient = AdresseClient;
    }


 // Getters
    public String getNomClient() {
        return NomClient;
    }
    
    public String getAdresseClient() {
        return AdresseClient;
    }
    
    /**
     * Méthode abstraite pour afficher les informations de la carte
     */
    public abstract void afficherInfo();
    
    /**
     * Retourne le type de carte (pour la sélection de la stratégie)
     */
    public abstract String getTypeCarte();
}