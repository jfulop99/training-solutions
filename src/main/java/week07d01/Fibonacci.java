package week07d01;

public class Fibonacci {

    private static final Long[] RESULTS = new Long[2000];

    public static long fib(int n) {
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


    public static long fib2(int n) {
        if (n < 0 ) {
            throw new IllegalArgumentException("Must be positive");
        }
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        if (RESULTS[n] == null) {
            RESULTS[n] = fib2(n - 2 ) + fib2(n - 1);
        }
        return RESULTS[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 300; i++) {
            System.out.println(i + " - " + Fibonacci.fib(i) + " - " + Fibonacci.fib2(i));
        }
    }
}
