public class PointsCashRecompense implements StrategieRecompense {
    @Override
    public String appliquer(Facture f) {
        if (f.getCarte() instanceof Points) {
            Points p = (Points) f.getCarte();
            int pts = (int) (1 * f.getMontant());
            p.incrementerPoints(pts);
            return "Vous avez gagné " + pts + " points.";
        }
        return "Aucune récompense appliquée.";
    }
}
