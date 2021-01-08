package activity;

public class Report {

    private ActivityType activityType;
    private double distance;

    public Report(ActivityType activityType, double distance) {
        this.activityType = activityType;
        if (distance < 0) {
            throw new IllegalArgumentException("Must be positive");
        }
        this.distance = distance;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public double getDistance() {
        return distance;
    }
}
