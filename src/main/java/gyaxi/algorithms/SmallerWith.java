package gyaxi.algorithms;

public class SmallerWith {
    public int smallerWith(int number, int... numbers) {
        if (number < 0) {
            throw new IllegalArgumentException("Value is out of range!");
        }
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Every parameter is a must!");
        }
        int max = Integer.MIN_VALUE;
        for (int item : numbers) {
            if (item > max) {
                max = item;
            }
        }
        int max2 = Integer.MIN_VALUE;
        for (int item : numbers) {
            if (item <= (max - number) && item > max2) {
                max2 = item;
            }
        }
        if (max2 > Integer.MIN_VALUE) {
            return max2;
        }
        throw new IllegalStateException("There is no such number!");
    }
}
