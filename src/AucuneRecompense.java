public class AucuneRecompense implements StrategieRecompense {
    @Override
    public String appliquer(Facture f) {
        return "Aucune récompense appliquée.";
    }
}
