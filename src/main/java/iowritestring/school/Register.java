package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {

    public Register() {
    }

    public void newMark(Path file, int mark) {
        StandardOpenOption option;
        if (Files.exists(file)) {
            option = StandardOpenOption.APPEND;
        }
        else {
            option = StandardOpenOption.CREATE_NEW;
        }
        try {
            Files.writeString(file, Integer.toString(mark) + "\n", option);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    public void average(Path file) {
        try {
            List<String> lines = Files.readAllLines(file);
            double sum = 0;
            for (String line:lines) {
                sum += Double.parseDouble(line);
            }
            Files.writeString(file,"average: " + Double.toString(sum / lines.size()), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot access file", e);
        }
    }
}
