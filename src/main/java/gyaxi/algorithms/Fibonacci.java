package gyaxi.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class Fibonacci {
    public String getPrims(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Invalid parameter!");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            long fib = fib(i);
            if (isPrime(fib)) {
                if (!result.isEmpty()) {
                    result.append(", ");
                }
                result.append(fib);
            }
            if (i == 1) {
                i++;
            }
        }
        return result.toString();
    }

    private long fib(int n) {
        long result = 0;
        long x = 1;
        long y = 1;
        for (int i = 0; i < n; i++) {
            result = y;
            long temp = x + y;
            y = x;
            x = temp;
        }
        return result;
    }

    private boolean isPrime(long number) {
        return !LongStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

    public List<Integer> getPiecesPrims(int num) {
        List<Integer> result = new ArrayList<>();
        if (num <= 0) {
            return result;
        }
        int i = 1;
        while (result.size() < num) {
            long fib = fib(i++);
            if (isPrime(fib)) {
                result.add((int) fib);
            }
        }
        return result;
    }
}
