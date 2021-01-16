package collectionsset.collectionstreeset;

import java.util.Set;
import java.util.TreeSet;

public class WordFilter {

    public Set<String> filterWords(String[] randomStrings) {

        Set<String> words = new TreeSet<>();
        for (String item:randomStrings) {
            words.add(item);
        }

        return words;
    }


}
