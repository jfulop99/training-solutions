package algorithmssum.integers;

import java.util.List;

public class IntegerSumCalculator {

    public int sum(List<Integer> numbers) {
        int sum = 0;
        for (int item:numbers) {
            sum += item;
        }
        return sum;
    }
}
