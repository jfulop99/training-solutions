package dateduration;

import java.time.Duration;
import java.time.format.DateTimeParseException;

public class WorkHoursCalculator {

    private Duration totalDuration = Duration.ZERO;

    public void addWorkTime(Duration duration) {

        totalDuration = totalDuration.plus(duration);

    }

    public void addWorkTime(int days, int hours, int minutes) {

        totalDuration = totalDuration.plusDays(days).plusHours(hours).plusMinutes(minutes);
    }

    public void addWorkTime(String durationString) {
        if (durationString == null || durationString.isBlank()) {
            throw new IllegalArgumentException("Parameter must not be empty!");
        }
        try {
            totalDuration = totalDuration.plus(Duration.parse(durationString));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Parameter must match PnDTnHnM pattern, but found: " + durationString);
        }
    }

    public int calculateWorkHours() {

        return (int) totalDuration.toHours();
    }

    public Duration getWorkDuration() {

        return totalDuration;
    }

    public String toString() {

        return "Days: " + totalDuration.toDaysPart() + ", hours: " + totalDuration.toHoursPart() + ", minutes: " + totalDuration.toMinutesPart();
    }

}
