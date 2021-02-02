package datenewtypes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Rendezvous {

    private LocalDateTime rendezvousDate;


    public Rendezvous(String dateString, String format, Locale locale) {
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

        rendezvousDate = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(format, locale));
    }

    public void setRendezvousDate(LocalDateTime rendezvousDate) {
        this.rendezvousDate = rendezvousDate;
    }

    public LocalDateTime getRendezvousDate() {
        return rendezvousDate;
    }
}
