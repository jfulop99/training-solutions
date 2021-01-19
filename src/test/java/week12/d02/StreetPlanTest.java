package week12.d02;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreetPlanTest {

    private InputStream is = StreetPlan.class.getResourceAsStream("kerites.txt");

    @TempDir
    public File folder;

    @Test
    void testReadFromFile() {

        StreetPlan streetPlan = new StreetPlan(is);

        assertEquals(98, streetPlan.getHouseList().size());

        assertEquals("P", streetPlan.getHouseList().get(0).getColorOfHedge());

        assertEquals("S", streetPlan.getHouseList().get(streetPlan.getHouseList().size() - 1).getColorOfHedge());

    }

    @Test
    void housesByArea() {
        StreetPlan streetPlan = new StreetPlan(is);
        List<House> result = streetPlan.housesByArea();

        assertEquals(8,result.get(0).getWidth());
        assertEquals(20,result.get(result.size()-1).getWidth());
    }

    @Test
    void lastNumber() {
        StreetPlan streetPlan = new StreetPlan(is);
        assertEquals(78, streetPlan.lastNumber());
    }

    @Test
    void writeOddStreetView() throws IOException {
        File file = new File(folder, "test.txt");
        Path targetPath = file.toPath();

        String fences = "0 10 P\n1 8 K\n1 10 :\n1 9 S\n0 10 P\n1 8 B\n1 9 F";
        InputStream stream = new ByteArrayInputStream(fences.getBytes(StandardCharsets.UTF_8));

        StreetPlan streetPlan = new StreetPlan(stream);
        streetPlan.writeOddStreetView(targetPath);

        assertTrue(Files.exists(folder.toPath().resolve("test.txt")));

        BufferedReader reader = Files.newBufferedReader(targetPath, StandardCharsets.UTF_8);
        String input = reader.readLine();

        assertEquals("(1)KKKKKKKK(3)::::::::::(5)SSSSSSSSS(7)BBBBBBBB(9)FFFFFFFFF", input);

    }

    @Test
    void testFileNotFound() {
        Exception e = assertThrows(IllegalStateException.class, ()-> new StreetPlan(null));
        assertEquals("Cannot find file", e.getMessage());
    }

}