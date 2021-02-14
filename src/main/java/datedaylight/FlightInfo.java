package datedaylight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FlightInfo {

    private ZonedDateTime departureDateTime;

    public FlightInfo(String dateString, String pattern, Locale locale, ZoneId zone) {
        if (isEmpty(dateString)) {
            throw new IllegalArgumentException("Empty date string parameter!");
        }
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string parameter!");
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

        departureDateTime = ZonedDateTime.of(LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern, locale)), zone);

    }

    public ZonedDateTime getArrivalDateTime(ZoneId zone, int flightHours, int flightMinutes) {

        return departureDateTime.plusHours(flightHours).plusMinutes(flightMinutes).withZoneSameInstant(zone);

    }

    public ZonedDateTime getDepartureDateTime() {

        return departureDateTime;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
