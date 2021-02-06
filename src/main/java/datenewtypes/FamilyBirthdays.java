package datenewtypes;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {

    private List<LocalDate> familyBirthDays;

    public FamilyBirthdays(LocalDate... dates) {

        familyBirthDays = new ArrayList<>(Arrays.asList(dates));

    }

    public boolean isFamilyBirthday(TemporalAccessor date) {

        int day = date.get(ChronoField.DAY_OF_MONTH);
        int month = date.get(ChronoField.MONTH_OF_YEAR);

        for (LocalDate item : familyBirthDays) {
            if (month == item.getMonthValue() && day == item.getDayOfMonth()) {
                return true;
            }
        }
        return false;
    }

    public long nextFamilyBirthDay(TemporalAccessor date) {
        long closest = Long.MAX_VALUE;
        int year = date.get(ChronoField.YEAR);
        LocalDate base = LocalDate.from(date);

        for (LocalDate item : familyBirthDays) {
            LocalDate nextBirthDay = item.withYear(year);
            if (base.isAfter(nextBirthDay)) {
                nextBirthDay = nextBirthDay.withYear(year + 1);
            }
            long difference = ChronoUnit.DAYS.between(base, nextBirthDay);
            if (difference < closest) {
                closest = difference;
            }
        }


        return closest;
    }
}
