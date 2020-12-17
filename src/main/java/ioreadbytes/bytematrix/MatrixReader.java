package ioreadbytes.bytematrix;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixReader {

    private List<byte[]> myMatrix = new ArrayList<>();


    public void readBytesAndCreateMatrix(String file){
        try (InputStream inputStream = MatrixReader.class.getResourceAsStream(file)) {

            int bytes = 0;
            byte[] line = new byte[1000];

            while ((bytes = inputStream.read(line)) > 0) {
                myMatrix.add(line);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

    }

    public int numberOfColumnsWhereMoreZeros() {
        int numberOfColumnsWhereMoreZeros = 0;
        for (int i = 0; i < 1000; i++) {
            int numberOfZeros = 0;
            int numberOfOnes = 0;

            for (byte[] line: myMatrix) {
                if (line[i] == 0) {
                    numberOfZeros++;
                }
                else {
                    numberOfOnes++;
                }
            }
            if (numberOfZeros > numberOfOnes) {
                numberOfColumnsWhereMoreZeros++;
            }
        }
        return numberOfColumnsWhereMoreZeros;
    }

    public List<byte[]> getMyMatrix() {
        return myMatrix;
    }

    public void createMatrix(String pathString) {
        Path path = Path.of("src/main/resources/ioreadbytes/bytematrix");
        try {
            Files.createDirectories(path);
            OutputStream writer = new BufferedOutputStream(Files.newOutputStream(path.resolve(pathString)));
            for (int j = 0; j < 9; j++) {
                for (int i = 0; i < 1000; ++i) {
                    if (i < 493) {
                        writer.write(0);
                    } else {
                        writer.write(1);
                    }
                }
            }
            writer.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't write matrix file!");
        }
    }

    public void createData(String pathString) {
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
        matrixReader.createMatrix("matrix.dat");

    }
}
