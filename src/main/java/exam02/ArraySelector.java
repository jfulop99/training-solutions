package exam02;

public class ArraySelector {

    public String selectEvens(int[] array) {
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
}
