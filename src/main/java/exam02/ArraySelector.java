package exam02;

import java.util.ArrayList;
import java.util.List;

public class ArraySelector {

    public String selectEvens2(int[] array) {
        StringBuilder result = new StringBuilder("");
        if (array.length == 0) {
            return result.toString();
        }
        result.append("[");
        result.append(array[0]);
        for (int i = 2; i < array.length; i += 2) {
            result.append(", ");
            result.append(array[i]);
        }
        result.append("]");
        return result.toString();
    }
    public String selectEvens(int[] array) {
        if (array.length == 0) {
            return "";
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i += 2) {
            result.add(array[i]);
        }
        return result.toString();
    }
}
