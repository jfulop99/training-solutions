package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PensionCalculator {

    private List<Period> periodList = new ArrayList<>();

    public void addEmploymentPeriod(Period period) {

        periodList.add(period);

    }

    public Period sumEmploymentPeriods() {
        Period total = Period.of(0, 0, 0);
        for (Period item : periodList) {
            total = total.plus(item);
        }
        return total.normalized();
    }

    public Period modifyByDays(Period period, int days) {

        return fullyNormalized(period.plusDays(days));
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null || toDate == null) {
            throw new NullPointerException("Null parameters are not allowed!");
        }
        return fullyNormalized(Period.between(fromDate, toDate));
    }

    private Period fullyNormalized(Period period) {
        return Period.ofDays(period.getYears() * 365 + period.getMonths() * 30 + period.getDays());
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        if (isEmpty(fromDate)) {
            throw new IllegalArgumentException("Empty from date string, cannot use: ");
        }
        if (isEmpty(toDate)) {
            throw new IllegalArgumentException("Empty to date string, cannot use: ");
        }
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        LocalDate startDate = LocalDate.parse(fromDate, format);
        LocalDate endDate = LocalDate.parse(toDate, format);

        return fullyNormalized(Period.between(startDate, endDate));
    }

    public int calculateTotalDays(Period period) {
        if (period == null) {
            throw new NullPointerException("Null parameters are not allowed!");
        }
        return period.getDays();
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

}
