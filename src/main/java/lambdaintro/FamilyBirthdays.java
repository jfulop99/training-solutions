package lambdaintro;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {

    private List<LocalDate> familyBirthDays;

    public FamilyBirthdays(LocalDate... birthDays) {

        if (birthDays == null || birthDays.length == 0) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        familyBirthDays = new ArrayList<>(Arrays.asList(birthDays));

    }

    public boolean isFamilyBirthday(TemporalAccessor date) {

        int day = date.get(ChronoField.DAY_OF_MONTH);
        int month = date.get(ChronoField.MONTH_OF_YEAR);

        for (LocalDate birthDay: familyBirthDays) {

            if (birthDay.get(ChronoField.DAY_OF_MONTH) == day && birthDay.get(ChronoField.MONTH_OF_YEAR) == month) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {

        int day = date.get(ChronoField.DAY_OF_MONTH);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int year = date.get(ChronoField.YEAR);


        LocalDate reference = LocalDate.of(year, month, day);

        int closest = Integer.MAX_VALUE;

        for (LocalDate birthday:familyBirthDays) {

            long difference = ChronoUnit.DAYS.between(reference, birthday.withYear(year));

            if (difference < 0) {
                difference = ChronoUnit.DAYS.between(reference, birthday.withYear(year +1));
            }
            if (difference < closest) {
                closest = (int) difference;
            }
        }


        return closest;
    }

}
