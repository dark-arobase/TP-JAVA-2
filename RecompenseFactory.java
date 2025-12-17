import cartes.Airmiles;
import cartes.CarteClient;
import cartes.Points;
import strategies.StrategieRecompense;
import strategies.recompense.AucuneRecompense;
import strategies.recompense.airmilesRecompense.AirmilesCashRecompense;
import strategies.recompense.airmilesRecompense.AirmilesCreditRecompense;
import strategies.recompense.pointRecompense.PointsCashRecompense;
import strategies.recompense.pointRecompense.PointsCreditRecompense;

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
