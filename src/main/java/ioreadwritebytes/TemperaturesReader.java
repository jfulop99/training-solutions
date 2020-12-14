package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String path) {

        Path file = Path.of(path);
        try {
            return new Temperatures(Files.readAllBytes(file));
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }
}
