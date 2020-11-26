package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private List<SimpleTime> timeTable = new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable) {
        if (timeTable == null) {
            throw new IllegalArgumentException("xxx");
        }
        this.timeTable = List.copyOf(timeTable);
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        if (!checkHour(firstHour)) {
            throw new IllegalArgumentException("xxx");
        }
        if (!checkHour(lastHour)) {
            throw new IllegalArgumentException("xxx");
        }
        if (everyMinute < 0 || everyMinute > 59) {
            throw new IllegalArgumentException("xxx");
        }
        for (int i = firstHour; i <= lastHour; i++) {
            timeTable.add(new SimpleTime(i, everyMinute));
        }

    }

    public List<SimpleTime> getTimeTable() {
        return List.copyOf(timeTable);
    }

    public SimpleTime nextBus(SimpleTime actual) {
        if (actual == null) {
            throw new IllegalArgumentException("xxx");
        }
        SimpleTime nextBus = null;
        int difference = Integer.MAX_VALUE;
        int actualDifference;
        for (SimpleTime time:timeTable) {
            actualDifference = time.difference(actual);
            if (actualDifference > 0 && actualDifference < difference) {
               difference = actualDifference;
               nextBus = time;
            }
        }
        if (nextBus == null) {
            throw new IllegalStateException("No more buses today!");
        }
        return nextBus;
    }

    public SimpleTime firstBus() {
        return nextBus(new SimpleTime(0, 0));
    }

    private boolean checkHour(int hour) {
        return (hour >= 0 && hour < 24) ? true : false;
    }
}
