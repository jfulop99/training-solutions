package iofilestest.cheese;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheeseManagerTest {
    @TempDir
    public Path temporaryFolder;

    private List<Cheese> cheeses = new ArrayList<>(Arrays.asList(new Cheese("Gruyere", 1.23),
                                                                new Cheese("Trapista", 2.34),
                                                                new Cheese("Ementáli", 4.23),
                                                                new Cheese("Camenbert", 0.23)));



    @Test
    void listToFileCreateTest() {

        Path path = temporaryFolder.resolve("test.dat");
        assertFalse(Files.exists(path));
        CheeseManager.saveToFile(path, cheeses);
        assertTrue(Files.exists(path));
    }

    @Test
    void listToFileContentTest() {

        Path path = temporaryFolder.resolve("test.dat");
        CheeseManager.saveToFile(path, cheeses);
        Cheese cheese = CheeseManager.findCheese(path, "Ementáli");
        assertNotNull(cheese);
        assertEquals(4.23, cheese.getAmountOfLactose());
        assertNull(CheeseManager.findCheese(path, "Kecske"));
    }

}