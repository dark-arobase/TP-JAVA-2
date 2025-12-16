public class AirmilesCashRecompense implements StrategieRecompense {
    @Override
    public String appliquer(Facture f) {
        if (f.getCarte() instanceof Airmiles) {
            Airmiles a = (Airmiles) f.getCarte();
            double miles = f.getMontant() / 2.00;
            a.ajouterMiles(miles);
            return "Vous avez gagné " + miles + " miles.";
        }
        return "Aucune récompense appliquée.";
    }
}
