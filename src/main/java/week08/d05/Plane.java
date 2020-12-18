package week08.d05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class Plane {
    private int longestOceanSection = 0;
    private int zeroCounter = 0;

    public int readMap(String filename) {

        try (InputStream inputStream = Plane.class.getResourceAsStream(filename)) {
            byte[] mapByte= new byte[1];
            while (inputStream.read(mapByte) > 0) {
                checkMapByte(mapByte[0]);
            }
        }catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
        return longestOceanSection;
    }

    private void checkMapByte(byte mapPoint) {
        if (mapPoint == '0') {
            zeroCounter++;
        }
        else {
            if (zeroCounter > longestOceanSection) {
                longestOceanSection = zeroCounter;
            }
            zeroCounter = 0;
        }
    }

    public int readMap2(String filename) {
        int input;
        Path path = Path.of("src/main/resources/week08/d05");
        System.out.println(path.resolve(filename));
        try(FileInputStream fis = new FileInputStream(path.resolve(filename).toString())) {
            while ((input = fis.read()) != -1 ) {
                checkMapByte((byte)input);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return longestOceanSection;
    }


    public static void main(String[] args) {
        Plane plane = new Plane();

        System.out.println(plane.readMap("map.txt"));

        System.out.println(plane.readMap2("map.txt"));

    }
}
