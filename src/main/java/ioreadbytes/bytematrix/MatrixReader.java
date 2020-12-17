package ioreadbytes.bytematrix;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class MatrixReader {



    public void createMatrix(String pathString) {
        Path path = Path.of("src/main/resources/ioreadbytes/byteacount");
        try {
            Files.createDirectories(path);
            Random random = new Random();
            OutputStream writer = new BufferedOutputStream(Files.newOutputStream(path.resolve(pathString)));
            for (int i = 0; i < 129; ++i) {
                writer.write(97);
                int max = random.nextInt(6) + 1;
                for (int j = 98; j < 98 + max; j++) {
                    writer.write(j);
                }
            }
            writer.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't write matrix file!");
        }
    }

    public static void main(String[] args) {
        MatrixReader matrixReader = new MatrixReader();
        //matrixReader.createMatrix("data.dat");
    }
}
