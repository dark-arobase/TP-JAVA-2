public class AirmilesCreditRecompense implements StrategieRecompense {
    @Override
    public String appliquer(Facture f) {
        if (f.getCarte() instanceof Airmiles) {
            Airmiles a = (Airmiles) f.getCarte();
            double miles = 2.0 * f.getMontant();
            a.ajouterMiles(miles);
            return "Vous avez gagné " + miles + " miles.";
        }
        return "Aucune récompense appliquée.";
    }
}
