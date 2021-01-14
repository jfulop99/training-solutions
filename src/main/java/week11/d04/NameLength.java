package week11.d04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameLength {

    public static final String FIRSTLETTER = "J";

    public static List<Integer> getLengths(List<String> names) {
        Set<Integer> lengthsOfNames = new HashSet<>();
        for (String item: names) {
            if (item.substring(0, 1).equals(FIRSTLETTER)) {
                lengthsOfNames.add(item.length());
            }
        }
    return new ArrayList<>(lengthsOfNames);
    }

    public static void main(String[] args) {
        System.out.println(NameLength.getLengths(List.of("Joe", "Jack", "Jane", "Jake", "George", "William")));
    }
}
