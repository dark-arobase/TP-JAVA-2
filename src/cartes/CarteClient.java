package cartes;

import strategies.recompense.StrategyRecompense;

public abstract class CarteClient {
    private String NomClient;
    private String AdresseClient;
    protected StrategyRecompense strategyRecompense;

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

    public void setStrategyRecompense(StrategyRecompense strategy) {
        this.strategyRecompense = strategy;
    }

    public void appliquerRecompense(double montant) {
        if (strategyRecompense != null) {
            double recompense = strategyRecompense.calculerRecompense(montant);
            ajouterRecompense(recompense);
            System.out.println("Récompense appliquée: " + recompense + " " + getUniteRecompense());
            System.out.println(strategyRecompense.getDescription());
        }
    }

    protected abstract void ajouterRecompense(double recompense);

    protected abstract String getUniteRecompense();

    public abstract void afficherInfos();

    public abstract void recompenser(facture.Facture f);
}