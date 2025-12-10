public class RecompenseFactory {
    public static StrategieRecompense getStrategie(CarteClient carte, ModePaiement mode) {
        if (carte == null) {
            return new AucuneRecompense();
        }

        // Points card
        if (carte instanceof Points) {
            switch (mode) {
                case CREDIT:
                    return new PointsCreditRecompense();
                case CASH:
                    return new PointsCashRecompense();
                default:
                    return new AucuneRecompense();
            }
        }

        // Airmiles card
        if (carte instanceof Airmiles) {
            switch (mode) {
                case CREDIT:
                    return new AirmilesCreditRecompense();
                case CASH:
                    return new AirmilesCashRecompense();
                default:
                    return new AucuneRecompense();
            }
        }

        return new AucuneRecompense();
    }
}
