package methodchain.robot;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private int distance;
    private int azimut;
    private List<NavigationPoint> navigationPoints = new ArrayList<>();


    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public Robot go(int meter) {
        distance += meter;
        return this;
    }

    public Robot rotate(int angle) {
        azimut += angle;
        return this;
    }

    public Robot registerNavigationPoint() {
        navigationPoints.add(new NavigationPoint(this.distance, this.azimut));
        return this;
    }

    public List<NavigationPoint> getNavigationList() {
        return navigationPoints;
    }

}
