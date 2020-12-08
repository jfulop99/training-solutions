package exceptionclass.course;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SimpleTime {

    private LocalTime time;

    public SimpleTime(String timeStr) {
        if (timeStr == null) {
            throw new IllegalArgumentException("Time is null");
        }
        String[] timeArray = timeStr.split(":");
        if (timeArray.length != 2) {

        }
        int hour;
        int min;
        int index = 0;
        try {
            hour = Integer.parseInt(timeArray[index++]);
            min = Integer.parseInt(timeArray[index]);
        }catch (NumberFormatException e) {

            throw new IllegalArgumentException("AA" + e.getMessage(), e.getCause());
        }
        this.time = LocalTime.of(hour, min);
    }

    public static void main(String[] args) {
        SimpleTime simpleTime = new SimpleTime("rg:23");
    }
}
