package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        if (activities == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        this.activities = new ArrayList<>(activities);
    }

    public void addActivity(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        activities.add(activity);
    }

    public int numberOfWithoutTrackActivities() {

        return numberOfActivitiesByClass(ActivityWithoutTrack.class);
    }

    public int numberOfTrackActivities() {
        return numberOfActivitiesByClass(ActivityWithTrack.class);
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();

        double[] sumDistanceByTypes = distancesSumByActivityType();

        for (ActivityType activity: ActivityType.values()) {
            reports.add(new Report(activity, sumDistanceByTypes[activity.ordinal()]));
        }

        return reports;
    }

    private double[] distancesSumByActivityType() {

        double[] activityDistanceSum = new double[ActivityType.values().length];

        for (Activity activity: activities) {
            activityDistanceSum[activity.getType().ordinal()] += activity.getDistance();
        }
        return activityDistanceSum;
    }

    private int numberOfActivitiesByClass( Class<?> activityClass) {
        int activityNumber = 0;
        for (Activity activity:activities) {
            if (activityClass == activity.getClass()) {
                activityNumber++;
            }
        }
        return activityNumber;
    }
}
