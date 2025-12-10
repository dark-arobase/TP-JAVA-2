public enum ModePaiement {
    CASH("Cash"),
    DEBIT("Débit"),
    CREDIT("Crédit"),
    POINTS("Points");
    
    private final String libelle;
    
    ModePaiement(String libelle) {
        this.libelle = libelle;
    }
    
    public String getLibelle() {
        return libelle;
    }
    
    @Override
    public String toString() {
        return libelle;
    }
}

