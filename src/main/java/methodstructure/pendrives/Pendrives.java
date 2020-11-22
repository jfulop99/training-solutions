package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendrives) {
        Pendrive best = null;
        for (Pendrive pendrive:pendrives) {
            if (best == null || best.comparePricePerCapacity(pendrive) == 1) {
                best = pendrive;
            }
        }
        return best;
    }

    public Pendrive cheapest(List<Pendrive> pendrives) {
        Pendrive cheapest = null;
        for (Pendrive pendrive:pendrives) {
            if (cheapest == null || pendrive.cheaperThan(cheapest)) {
                cheapest = pendrive;
            }
        }
        return cheapest;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive pendrive: pendrives) {
            if (pendrive.getCapacity() == capacity) {
                pendrive.risePrice(percent);
            }
        }
    }
}
