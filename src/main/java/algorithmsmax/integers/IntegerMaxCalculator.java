package algorithmsmax.integers;

import java.util.List;

public class IntegerMaxCalculator {

    public int max(List<Integer> integers) {
        int maximun = Integer.MIN_VALUE;
        for (int integer:integers ) {
            if (integer > maximun) {
                maximun = integer;
            }
        }
        return maximun;
    }
}
