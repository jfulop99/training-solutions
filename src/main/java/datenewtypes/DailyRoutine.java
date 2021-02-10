package datenewtypes;

import java.time.LocalTime;

public class DailyRoutine {

    private LocalTime startTime;

    public DailyRoutine(int hour, int minute) {

        startTime = LocalTime.of(hour, minute);

    }

    public DailyRoutine(String timeString) {

        startTime = LocalTime.parse(timeString);

    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setFutureTime(int minutes) {

        startTime = startTime.plusMinutes(minutes);

    }

    public boolean isBeforeNoon() {

        return startTime.isBefore(LocalTime.NOON);

    }

    public static void main(String[] args) {

        DailyRoutine dr = new DailyRoutine(9, 0);
        System.out.println(dr.getStartTime());
        DailyRoutine dailyRoutine = new DailyRoutine("09:00");
        System.out.println(dailyRoutine.getStartTime());
        dr.setFutureTime(3 * 45 + 20);
        System.out.println(dr.getStartTime());
        System.out.println(dr.isBeforeNoon());
    }

}
