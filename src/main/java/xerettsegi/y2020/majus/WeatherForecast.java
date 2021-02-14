package xerettsegi.y2020.majus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class WeatherForecast {

    private Map<String, List<Weather>> weatherData;

    public WeatherForecast(BufferedReader reader) throws IOException {

        weatherData = new HashMap<>();
        readData(reader);

    }

    private void readData(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            Weather weather = new Weather(line);
            weatherData.computeIfAbsent(weather.getCityCode(), a -> new ArrayList<>()).add(weather);
        }
    }

    public Map<String, List<Weather>> getWeatherData() {
        return weatherData;
    }

    public void lastDataFromCity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("2. feladat");
        System.out.print("Adja meg egy település kódját! Település: ");
        String citiCode = scanner.nextLine();

        List<Weather> cityList = weatherData.get(citiCode);
        System.out.println("Az utolsó mérési adat a megadott településről " + cityList.get(cityList.size() - 1).getTimeOfMeasure().toString() + "-kor érkezett.");

    }

    public void minMaxPerDay() {

        Optional<Weather> min = weatherData
                .values()
                .stream()
                .flatMap(Collection::stream)
                .min(Comparator.comparing(Weather::getTemperature));
        Optional<Weather> max = weatherData
                .values()
                .stream()
                .flatMap(Collection::stream)
                .max(Comparator.comparing(Weather::getTemperature));

        System.out.println("3. feladat");
        System.out.println("A legalacsonyabb hőmérséklet: " + min.get().getCityCode() + " " + min.get().getTimeOfMeasure() + " " + min.get().getTemperature() + " fok.");
        System.out.println("A legmagasabb hőmérséklet: " + max.get().getCityCode() + " " + max.get().getTimeOfMeasure() + " " + max.get().getTemperature() + " fok.");


    }

    public void windSpeedZero() {

        System.out.println("4. feladat");
        List<Weather> result = weatherData
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(weather -> weather.getWindSpeed() == 0)
                .collect(Collectors.toList());
        for (Weather weather : result) {
            System.out.println(weather.getCityCode() + " " + weather.getTimeOfMeasure().toString());
        }
    }

    public void averageTempAndDifferenceByCity() {

        List<Integer> hours = List.of(1, 7, 13, 19);
        String diff;
        System.out.println("5. feladat");
        for (String city : weatherData.keySet()) {
            String average = "NA";
            List<Weather> cityData = weatherData.get(city).stream()
                    .filter(weather -> hours.contains(weather.getTimeOfMeasure().getHour()))
                    .collect(Collectors.toList());
            IntSummaryStatistics stat = weatherData.get(city).stream()
                    .mapToInt(Weather::getTemperature)
                    .summaryStatistics();
            diff = String.format("%d", stat.getMax() - stat.getMin());
            int sum = 0;
            int counter = 0;
            int dataCounter = 0;
            for (Weather item : cityData) {
                if (dataCounter < hours.size() && hours.get(dataCounter) == item.getTimeOfMeasure().getHour()) {
                    dataCounter++;
                }
                sum += item.getTemperature();
                counter++;
            }
            if (dataCounter == hours.size()) {
                average = String.format("%2.0f", (double) sum / counter);
            }
            System.out.println(city + " Középhőmérséklet: " + average + "; Hőmérséklet-ingadozás: " + diff);
        }
    }

    public void writeDataToFiles() {

        System.out.println("6. feladat");
        for (String city : weatherData.keySet()) {
            try (BufferedWriter writer = Files.newBufferedWriter(Path.of(city + ".txt"))) {
                writer.write(city + "\n");
                for (Weather item : weatherData.get(city)) {
                    writer.write(item.getTimeOfMeasure().toString() + " " + "#".repeat(item.getWindSpeed()) + "\n");
                }
            } catch (IOException e) {
                throw new IllegalStateException("Cannot write file", e);
            }
        }
        System.out.println("A fájlok elkészültek.");
    }

    public static void main(String[] args) {

        WeatherForecast weatherForecast;

        try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/erettsegi/2020/majus/4_Meteorologiai_jelentes/tavirathu13.txt"))) {
            weatherForecast = new WeatherForecast(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

        System.out.println(weatherForecast.getWeatherData());
        weatherForecast.lastDataFromCity();
        weatherForecast.minMaxPerDay();
        weatherForecast.windSpeedZero();
        weatherForecast.averageTempAndDifferenceByCity();
        weatherForecast.writeDataToFiles();

    }
}
