package methodoverloading.pub;

import methodoverloading.Time;

public class Pub {

    private String name;
    private Time time;


    public Pub(String name, int hours, int minutes) {
        this.name = name;
        time = new Time(hours, minutes);
    }

    public Time getOpenFrom() {
        return time;
    }

    @Override
    public String toString() {
        return name + ";" + time.getHours() + ":" + time.getMinutes();
    }

    public String getName() {
        return name;
    }
}
