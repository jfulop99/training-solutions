package methoverloading.pub;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {

    private List<Pub> goodPubs = new ArrayList<>();

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null || goodPubs.size() == 0) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        else {
            this.goodPubs = goodPubs;
        }
    }

    public Pub findTheBest() {
        Pub bestPub = null;
        for (Pub pub: goodPubs) {
            if (bestPub == null || pub.getOpenFrom().isEarlier(bestPub.getOpenFrom())) {
                bestPub = pub;
            }
        }
        return bestPub;
    }
}
