package xerettsegi.y2020.majus;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Weather {

    private final String cityCode;
    private final LocalTime timeOfMeasure;
    private final String windDirection;
    private final int windSpeed;
    private final int temperature;

    public Weather(String cityCode, LocalTime timeOfMeasure, String windDirection, int windSpeed, int temperature) {
        this.cityCode = cityCode;
        this.timeOfMeasure = timeOfMeasure;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.temperature = temperature;
    }

    public Weather(String line) {

        String[] parts = line.split(" ");

        cityCode = parts[0];
        timeOfMeasure = LocalTime.parse(parts[1], DateTimeFormatter.ofPattern("HHmm"));
        windDirection = parts[2].substring(0, 3);
        windSpeed = Integer.parseInt(parts[2].substring(3));
        temperature = Integer.parseInt(parts[3]);
    }

    public String getCityCode() {
        return cityCode;
    }

    public LocalTime getTimeOfMeasure() {
        return timeOfMeasure;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return cityCode + " " + timeOfMeasure + " " + windDirection + " " + windSpeed + " " + temperature;
    }
}
