package iowriter.names;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NameWriter {

    private Path fileName;

    public NameWriter(Path fileName) {
        this.fileName = fileName;
    }

    public void addAndWrite(String name) {

        try (BufferedWriter writer = Files.newBufferedWriter(fileName, StandardOpenOption.APPEND)){

            writer.write(name + "\n");

        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }
}
