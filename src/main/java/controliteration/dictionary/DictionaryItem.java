package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {

    private String word;
    private List<String> translations = new ArrayList<>();

    public DictionaryItem(String word, List<String> translation) {
        this.word = word;
        addTranslation(translation);
    }

    public void addTranslation(List<String> translations){
        for (String translation: translations) {
            if (!this.translations.contains(translation)){
                this.translations.add(translation);
            }
        }
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslation() {
        return translations;
    }
}
