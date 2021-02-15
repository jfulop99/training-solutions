package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {


    public String printHistogram(BufferedReader reader) throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append("*".repeat(Integer.parseInt(line)) + "\n");
        }
        return sb.toString();
    }

}
