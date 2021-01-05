package week10.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Travel {

    private int[] passanger = new int[30];
    public int getStopWithMax(InputStream inputStream) {
        int maxPeoplePerStop = 0;
        readFile(inputStream);
        for (int item:passanger){
            if (item > maxPeoplePerStop) {
                maxPeoplePerStop = item;
            }
        }
        return maxPeoplePerStop;
    }

    private void readFile(InputStream inputStream) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                passanger[Integer.parseInt(parts[0])]++;
                }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }

    }

    public static void main(String[] args) {
        Travel travel = new Travel();
        System.out.println(travel.getStopWithMax(Travel.class.getResourceAsStream("utasadat.txt")));
    }

}
