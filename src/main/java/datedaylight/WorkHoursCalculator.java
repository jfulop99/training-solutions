package datedaylight;

import java.time.*;

public class WorkHoursCalculator {

    private ZonedDateTime startDateTime;

    public WorkHoursCalculator(int startYear, Month startMonth, int startDay, int startHour, ZoneId zone) {
        startDateTime = ZonedDateTime.of(LocalDateTime.of(startYear, startMonth, startDay, startHour, 0), zone);
    }

    public long calculateHours(int year, Month month, int day, int hour) {

        return Duration.between(startDateTime, ZonedDateTime.of(LocalDateTime.of(year, month, day, hour, 0), startDateTime.getZone())).toHours();
    }

    public ZonedDateTime getStartDateTime() {

        return startDateTime;
    }

}
