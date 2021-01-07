package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();


    public List<TrackPoint> getTrackPoints() {
        return new ArrayList<>(trackPoints);
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        if (trackPoint == null) {
            throw new IllegalArgumentException("Trackpoint is null");
        }
        trackPoints.add(trackPoint);
    }

    public double getDistance() {
        double distance = 0.0;
        TrackPoint prevTrackPoint =trackPoints.get(0);
        for (TrackPoint trackPoint:trackPoints) {
            distance += trackPoint.getDistanceFrom(prevTrackPoint);
            System.out.println(distance);
        }
//        distance += trackPoints.get(trackPoints.size() - 1).getDistanceFrom(prevTrackPoint);
//        System.out.println(distance);
        return distance;
    }



}
