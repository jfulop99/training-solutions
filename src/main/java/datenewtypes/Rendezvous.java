package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Rendezvous {

    private LocalTime dateTime;


    public Rendezvous(int hours, int minutes) {

        dateTime = LocalTime.of(hours, minutes);

    }

    public Rendezvous(String dateTimeString, String format) {
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
        if (dateTimeString == null || dateTimeString.isBlank()) {
            throw new IllegalArgumentException("Illegal time string: ");
        }

        try {
            dateTime = LocalTime.parse(dateTimeString, DateTimeFormatter.ofPattern(format));
        }catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Illegal time string: " + dateTimeString, e);
        }
    }

    public void setDateTime(LocalTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalTime getDateTime() {
        return dateTime;
    }

    public String toString(String format) {
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
        return dateTime.format(DateTimeFormatter.ofPattern(format));
    }

    public void pushLater(int hours, int minutes) {

        dateTime = dateTime.plusHours(hours).plusMinutes(minutes);

    }

    public void pullEarlier(int hours, int minutes) {

        dateTime = dateTime.minusHours(hours).minusMinutes(minutes);

    }

    public long countMinutesLeft(LocalTime base) {
        long result = ChronoUnit.MINUTES.between(base, dateTime);
        if (result < 0) {
            throw new MissedOpportunityException("Too late!");
        }
        return result;
    }
}
