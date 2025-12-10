public class PointsCreditRecompense implements StrategieRecompense {
    @Override
    public String appliquer(Facture f) {
        if (f.getCarte() instanceof Points) {
            Points p = (Points) f.getCarte();
            int pts = (int) (2 * f.getMontant());
            p.incrementerPoints(pts);
            return "Vous avez gagné " + pts + " points.";
        }
        return "Aucune récompense appliquée.";
    }
}
