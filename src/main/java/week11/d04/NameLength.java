package week11.d04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameLength {

    public static final String FIRST_LETTER = "J";

    public List<Integer> getLengths(List<String> names) {
        Set<Integer> lengthsOfNames = new HashSet<>();
        if (names != null) {
            for (String item : names) {
                if (item != null && item.toUpperCase().startsWith(FIRST_LETTER)) {
                    lengthsOfNames.add(item.length());
                }
            }
        }
    return new ArrayList<>(lengthsOfNames);
    }

    public static void main(String[] args) {

        System.out.println(new NameLength().getLengths(List.of("Joe", "Jack", "Jane", "Jake", "George", "William")));
    }
}
