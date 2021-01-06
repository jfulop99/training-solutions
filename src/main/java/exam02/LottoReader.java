package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {

    private int[] numbers = new int[90];

    public LottoReader(InputStream inputStream) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                for (int i = 11; i < 16; i++) {
                    numbers[Integer.parseInt(parts[i]) - 1]++;
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public int getNumber(int number) {
        if (number < 1 || number > 90) {
            throw new IllegalArgumentException("Number is out of range");
        }
        return numbers[number - 1];
    }
}
