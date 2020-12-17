package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] image, Path path) {

        Path file = path.resolve("image.png");
        try (OutputStream writer = new BufferedOutputStream(Files.newOutputStream(file))){
            for (byte[] part:image) {
                writer.write(part);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }
}
