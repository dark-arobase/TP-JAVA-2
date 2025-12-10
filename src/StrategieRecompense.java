public interface StrategieRecompense {
    /**
     * Applique la récompense à la facture et retourne un message décrivant
     * ce qui a été attribué (ex: "Vous avez gagné 10 points").
     */
    String appliquer(Facture f);
}
