package activity;

public class ActivityWithoutTrack implements Activity{

    private ActivityType activityType;

    public ActivityWithoutTrack(ActivityType activityType) {
        if (activityType == null) {
            throw new IllegalArgumentException("Activity type is null");
        }
        this.activityType = activityType;
    }

    @Override
    public double getDistance() {
        return 0.0;
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }
}
