package ioreadstring.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private List<Human> humans;
    private Path myFile;

    public FileManager(String myFile) {
        if (myFile == null ||myFile.isBlank()) {
            throw new IllegalArgumentException("Filename is invalid");
        }
        this.myFile = Path.of(myFile);
        humans = new ArrayList<>();
    }

    public void readFromFile() {
        try {
            List<String> lines = Files.readAllLines(myFile);
            for (String line: lines) {
            String[] name = line.split(" ");
            humans.add(new Human(name[0], name[1]));
            }
        }catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public List<Human> getHumans() {
        return humans;
    }

    public Path getMyFile() {
        return myFile;
    }
}
