package week08.d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {

    private List<String> titlesOfExamples;
    private static final String MARK_OF_TITLE= "#";

    public ExamplesStore() {
        titlesOfExamples = new ArrayList<>();
    }

    public List<String> getTitlesOfExamples() {

        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ExamplesStore.class.getResourceAsStream("examples.md")))){
            while ((line = reader.readLine()) != null){
                addTitles(line);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        } catch (NullPointerException e) {
            throw new IllegalStateException("File not found", e);
        }
        return titlesOfExamples;
    }

    private void addTitles(String line) {
        if (line.startsWith(MARK_OF_TITLE)) {
            String lineWithoutMark = line.substring(2);
            titlesOfExamples.add(lineWithoutMark);
        }
    }

    public static void main(String[] args) {
        ExamplesStore examplesStore = new ExamplesStore();

        System.out.println(examplesStore.getTitlesOfExamples());
    }

}
