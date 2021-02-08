package week15.d01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class BitCoin {


    public Result calculateMaxExchangeGain(List<Integer> rates) {

        List<Result> results = new ArrayList<>();
        Result act = null;

        for (int i = 0; i < rates.size() - 1; i++) {
            int maxDiff = Integer.MIN_VALUE;
            int actual = rates.get(i);
            for (int j = i + 1; j < rates.size(); j++) {
                if ((rates.get(j) - actual) > maxDiff) {
                    maxDiff = rates.get(j) - actual;
                    act = new Result(i, j, maxDiff);
                }
                results.add(act);
            }
        }

        int maxDiff = Integer.MIN_VALUE;
        for (Result item : results) {
            if (item.getDiff() > maxDiff) {
                maxDiff = item.getDiff();
                act = item;
            }
        }

        return act;

    }

    public Optional<Result> statisticOfRates(List<Integer> rates) {

        List<Result> results = new ArrayList<>();


        int sizeOfInput = rates.size();


        for (int i = 0; i < sizeOfInput - 1; i++) {
            for (int j = i + 1; j < sizeOfInput; j++) {
                results.add(new Result(i, j, rates.get(j) - rates.get(i)));
            }
        }
        return results.stream().max(Comparator.comparingInt(Result::getDiff));
    }

    public Optional<Result> calculateWithStream(List<Integer> rates) {

        int sizeOfInput = rates.size();
        Object o = new Object();

        return IntStream.range(0, sizeOfInput - 1)
                .boxed()
                .flatMap(a -> IntStream.range(a + 1, sizeOfInput)
                        .mapToObj(b -> new Result(a, b, rates.get(b) - rates.get(a))))
                .max(Comparator.comparingInt(Result::getDiff));


    }

    public static void main(String[] args) {

        BitCoin bitCoin = new BitCoin();

        System.out.println(bitCoin.calculateMaxExchangeGain(List.of(100, 120, 40, 70, 200, 30, 50)));
        System.out.println(bitCoin.calculateWithStream(List.of(100, 120, 40, 70, 200, 30, 50)));
        System.out.println(bitCoin.statisticOfRates(List.of(100, 120, 40, 70, 200, 30, 50)));
        System.out.println(bitCoin.calculateMaxExchangeGain(List.of(130, 110, 100, 70, 50, 30, 10)));
        System.out.println(bitCoin.statisticOfRates(List.of(130, 110, 100, 70, 50, 30, 10)));

    }

}
