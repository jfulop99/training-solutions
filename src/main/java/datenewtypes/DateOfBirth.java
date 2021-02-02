package datenewtypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

    private final LocalDate dateOfBirth;

    public DateOfBirth(int year, int month, int day) {

        LocalDate inputDate = LocalDate.of(year, month, day);
        if (inputDate.isAfter(LocalDate.now())) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        dateOfBirth = inputDate;

    }

    public DateOfBirth(String dateString, String format) {
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }

        dateOfBirth = LocalDate.parse(dateString, DateTimeFormatter.ofPattern(format));
    }

    public DateOfBirth(String dateString, String format, Locale locale) {
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }

        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

            dateOfBirth = LocalDate.parse(dateString, DateTimeFormatter.ofPattern(format, locale));
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

        return dateOfBirth.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);

    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate later) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

        return later.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);

    }

    public String toString(String format) {
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
        return dateOfBirth.format(DateTimeFormatter.ofPattern(format));
    }

    public long countDaysSinceBirth(LocalDate date) {
        if (date.isBefore(dateOfBirth)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }

        return ChronoUnit.DAYS.between(dateOfBirth, date);
    }

    public long countDaysBetween(DateOfBirth date) {

        return ChronoUnit.DAYS.between(dateOfBirth, date.dateOfBirth);
    }
}
