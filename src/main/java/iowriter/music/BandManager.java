package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private List<Band> bands;

    public BandManager() {
        bands = new ArrayList<>();
    }

    public void writeBandsBefore(Path file, int year) {
        try (BufferedWriter writer = Files.newBufferedWriter(file)){

            for (Band band:bands) {
                if (band.getYear() < year) {
                    writer.write(band.getName() + ";" + band.getYear() + "\n");
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    void readBandsFromFile(Path inputFile) {

//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(BandManager.class.getResourceAsStream("bands_and_years.txt ")))) {
        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                bands.add(new Band(parts[0], Integer.parseInt(parts[1])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

}
