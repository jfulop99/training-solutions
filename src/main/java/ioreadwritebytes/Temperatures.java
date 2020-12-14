package ioreadwritebytes;

public class Temperatures {

    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage() {
        double average = 0.0;
        for (byte item:data) {
            average += item;
        }
        return average / 365;
    }

    public double getMonthAverage() {
        double average = 0.0;
        for (int i = 335; i < 365; i++) {
            average += data[i];
        }
        return average / 30;
    }

}
