package recursion;

public class FactorialCalculator {

    public long getFactorial(int number) {
        if (number > 1) {
            long result = getFactorial(number-1);
            return number * result;
        }
        else {
            return 1;
        }
    }
}
