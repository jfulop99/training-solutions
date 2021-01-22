package week12.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CovidCounter {

    private static final String COVID_WORD = "koronavírus";

    public int getNumberOfCovidWords() {

        int covidCount = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CovidCounter.class.getResourceAsStream("index.html"), StandardCharsets.UTF_8))) {
            covidCount = readAndCount(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        } catch (NullPointerException npe) {
            throw new IllegalStateException("Cannot find file");
        }

        return covidCount;
    }

    private int readAndCount(BufferedReader reader) throws IOException {
        int counter = 0;

            String line;
            while ((line = reader.readLine()) != null) {

                if (line.contains(COVID_WORD)) {
                    counter++;
                }
            }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new CovidCounter().getNumberOfCovidWords());
    }
}
