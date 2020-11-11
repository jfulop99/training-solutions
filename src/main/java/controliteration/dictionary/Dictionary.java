package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public void addItem (String word, List<String> newTranslation){
        List<String> tr = new ArrayList<>();
        tr = findTranslations(word);
        if (tr.size() == 0){
            dictionaryItems.add(new DictionaryItem(word, newTranslation));
        }
        else{
            for (DictionaryItem dictionaryItem : dictionaryItems) {
                if (dictionaryItem.getWord().equals(word)){
                    dictionaryItem.addTranslation(newTranslation);
                    break;
                }
            }
        }
    }

    public List<String> findTranslations(String word){
        for (DictionaryItem dictionaryItem : dictionaryItems) {
            if (dictionaryItem.getWord().equals(word)){
                return dictionaryItem.getTranslation();
            }
            else {
                break;
            }
        }
        return new ArrayList<>();
    }
}
