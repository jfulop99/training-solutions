package activity;

public class Report {

    private final ActivityType activityType;
    private final double distance;

    public Report(ActivityType activityType, double distance) {
        if (activityType == null) {
            throw new IllegalStateException("Activity type is null");
        }
        this.activityType = activityType;
        if (distance < 0) {
            throw new IllegalArgumentException("Must be positive or 0");
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
