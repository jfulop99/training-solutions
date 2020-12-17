package week08.d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {

    private List<String> titlesOfExamples = new ArrayList<>();

    public List<String> getTitlesOfExamples() {

        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ExamplesStore.class.getResourceAsStream("examples.md")))){
            while ((line = reader.readLine()) != null){
                if (line.startsWith("#")) {
                    titlesOfExamples.add(line.substring(1));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return titlesOfExamples;
    }

    public static void main(String[] args) {
        ExamplesStore examplesStore = new ExamplesStore();

        System.out.println(examplesStore.getTitlesOfExamples());
    }

}
