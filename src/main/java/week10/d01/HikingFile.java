package week10.d01;

import ioreader.states.State;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

public class HikingFile {

    public LevelChange getPlusElevation(String filename) {
        if (filename == null || filename.isBlank()) {
            throw new IllegalArgumentException("Wrong filename!");
        }

        double lifting = 0.0;
        double descent = 0.0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(HikingFile.class.getResourceAsStream(filename)))) {
            String line;
            double previousLevel = 0.0;
            double actualLevel = 0.0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (previousLevel > 0) {
                    actualLevel = Double.parseDouble(parts[2]);
                    double diffLevel = actualLevel - previousLevel;
                    if (diffLevel < 0 ) {
                        descent += Math.abs(diffLevel);
                    }
                    else {
                        lifting += diffLevel;
                    }
                }
                previousLevel = Double.parseDouble(parts[2]);
            }
        } catch (NullPointerException e) {
            throw new IllegalStateException("Cannot find file! " + filename);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file ", e);
        }
        return new LevelChange(lifting, descent);
    }

    public static void main(String[] args) {
        HikingFile hikingFile = new HikingFile();
        System.out.println(hikingFile.getPlusElevation("tracker.txt"));
    }

}
