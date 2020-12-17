package ioreadbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteChecker {

    public int readBytesAndFindAs(String filename) {
        int count = 0;
        try (InputStream inputStream = new BufferedInputStream(ByteChecker.class.getResourceAsStream(filename))){
            byte[] bytes = new byte[1000];
            int size;
            while ((size = inputStream.read(bytes)) > 0) {
                for (int i = 0; i < size; i++) {
                    if (bytes[i] == 97) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return count;
    }
}
