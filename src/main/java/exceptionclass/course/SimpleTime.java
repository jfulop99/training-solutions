package exceptionclass.course;

public class SimpleTime {

    private int hour;
    private int minute;


    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public SimpleTime(int hour, int minute) {
            setTime(hour, minute);
    }

    public SimpleTime(String timeStr) {
        if (timeStr == null) {
            throw new InvalidTimeException("Time is null");
        }
        String[] timeArray = timeStr.split(":");
        if (timeArray.length != 2) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        int hour;
        int minute;
        try {
            hour = Integer.parseInt(timeArray[0]);
            minute = Integer.parseInt(timeArray[1]);
        }catch (NumberFormatException e) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        setTime(hour, minute);
    }

    private void setTime(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        this.hour = hour;
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.minute = minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}
