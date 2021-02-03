package datenewtypes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {

    private List<LocalDate> familyBirthDays;

    public FamilyBirthdays(LocalDate... dates) {

        familyBirthDays = new ArrayList<>(Arrays.asList(dates));

    }

    public boolean isFamilyBirthday(LocalDate date) {

        for (LocalDate item: familyBirthDays ) {
            if (date.getMonthValue() == item.getMonthValue() && date.getDayOfMonth() == item.getDayOfMonth()) {
                return true;
            }
        }
        return false;
    }

    public ChronoUnit nextFamilyBirthDay(LocalDate date) {
        return null;
    }
}
