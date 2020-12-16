package week08.d03.mid;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    private List<String> union;

    public StringLists() {
        union = new ArrayList<>();
    }

    public List<String>  stringListsUnion(List<String> first, List<String> second) {
        union.addAll(first);
        for (String item:second) {
            if (!union.contains(item)) {
                union.add(item);
            }
        }
        return union;
    }

    public static void main(String[] args) {
        StringLists stringLists = new StringLists();

        System.out.println(stringLists.stringListsUnion(List.of("b","c","d"), List.of("a","b","c","d","e")));
    }
}
