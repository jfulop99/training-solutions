package week07d03;

public class Date {

    private final int year;
    private final int month;
    private final int day;


    public Date(int year, int month, int day) {
        if (year < 1900) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.year = year;
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }
        this.month = month;
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day");
        }
        this.day = day;
    }

    public static Date of(int year, int month, int day) {
        return new Date(year, month, day);
    }

    public Date withYear(int year) {
        return new Date(year,  getMonth(), getDay());
    }

    public Date withMonth(int month) {
        return new Date(getYear(), month, getDay());
    }

    public Date withDay(int day) {
        return new Date(getYear(), getMonth(), day);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
