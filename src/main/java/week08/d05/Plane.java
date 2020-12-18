package week08.d05;

import java.io.IOException;
import java.io.InputStream;

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

    public static void main(String[] args) {
        Plane plane = new Plane();

        System.out.println(plane.readMap("map.txt"));
    }
}
