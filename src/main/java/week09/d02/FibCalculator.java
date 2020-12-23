package week09.d02;

public class FibCalculator {


    public long sumEvens(int bound) {
        long result = 0;
        long fibonacci = 0;
        int count = 1;

        while ((fibonacci = fib(count)) < bound) {
            if (fibonacci % 2 == 0) {
                result += fibonacci;
            }
            count++;
        }
        return result;
    }

    private long fib(int n) {
        long result = 0;
        long x = 1;
        long y = 1;
        for (int i = 0; i < n; i++) {
            result = y;
            long temp =  x + y;
            y = x;
            x = temp;
        }
        return result;
    }

    public long sumEvens2(int bound) {
        long result = 0;
        long x = 1;
        long y = 1;
        long sum = 0;
        while (result < bound) {
            if (result % 2 == 0) {
                sum += result;
            }
            result = y;
            long temp =  x + y;
            y = x;
            x = temp;
        }
        return sum;
    }


    public static void main(String[] args) {
        FibCalculator fibonacci = new FibCalculator();
        System.out.println(fibonacci.sumEvens(100));
        System.out.println(fibonacci.sumEvens2(100));
    }
}
