package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {

    public void writeAsBytes(List<String> list, Path path) {

        try (OutputStream writer = new BufferedOutputStream(Files.newOutputStream(path))){
            for (String item: list) {
                if (item.charAt(0) != '_') {
                    writer.write(item.getBytes());
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

}
