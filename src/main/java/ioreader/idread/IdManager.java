package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {

    private List<String> ids = new ArrayList<>();


    public void readIdsFromFile(String filename) {

        Path file = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            String line;
            while ((line = reader.readLine()) != null) {
                if (checkId(line)) {
                    ids.add(line);
                }
            }
        }catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private boolean checkId(String id) {
        if (id.length() != 8) {
            return false;
        }
        //return Pattern.matches("d{6}\\[A-Z]{2}", id);
        return true;
    }

    public List<String> getIds() {
        List<String> idsCopy = new ArrayList<>(ids);
        //idsCopy.addAll(ids);
        return idsCopy;
    }
}
