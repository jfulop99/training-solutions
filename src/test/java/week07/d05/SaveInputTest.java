package week07.d05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SaveInputTest {


    @TempDir
    Path tempDirectory;

    @Test
    void saveInputTest(){
        Scanner scanner = new Scanner("1. sor\n2. sor\n3. sor\nsorok.txt\n");
        SaveInput saveInput = new SaveInput(scanner);
        saveInput.writeFile();
        try {
            String result = Files.readString(Path.of("sorok.txt"));
            assertEquals("1. sor\r\n2. sor\r\n3. sor\r\n", result);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    @Test
    void testWrite() throws IOException{
        //Given
        SaveInput saveInput = new SaveInput(new Scanner(System.in));

        Path file = tempDirectory.resolve("test.txt");
        System.out.println(file);

        System.out.println(tempDirectory);
        //When
        saveInput.writeFile(file, List.of("alma", "korte"));

        //Then
        String result = Files.readString(file);

        assertEquals("alma\r\nkorte\r\n", result);

    }

}