package week10.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HikingFile {

    public LevelChange getElevation(InputStream inputStream) {
        if (inputStream == null ) {
            throw new IllegalArgumentException("Wrong input!");
        }

        LevelChange levelChange = new LevelChange();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            double previousLevel = 0.0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (previousLevel > 0) {
                    double actualLevel = Double.parseDouble(parts[2]);
                    levelChange.addDifference(actualLevel - previousLevel);
                }
                previousLevel = Double.parseDouble(parts[2]);
            }
        } catch (NullPointerException e) {
            throw new IllegalStateException("Cannot find file! ");
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file ", e);
        }
        return levelChange;
    }

    public static void main(String[] args) {
        HikingFile hikingFile = new HikingFile();
                System.out.println(hikingFile.getElevation(HikingFile.class.getResourceAsStream("tracker.txt")));
    }

}
