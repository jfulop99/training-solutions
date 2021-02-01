package week14.d01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Transformers {

    public <T, R> List<R> map(List<T> list, Function<T, R> transformer) {

        List<R> result = new ArrayList<>();
        for ( T item: list) {
            result.add(transformer.apply(item));
        }
        return result;

//        return list.stream().map(transformer).collect(Collectors.toList());

    }

    public <T> T reduce(List<T> list, T identity, BiFunction<T, T, T> combiner) {

        T result = identity;
        for (T t : list) {
            result = combiner.apply(result, t);
        }
        return result;

//        return list.stream().reduce(identity, combiner::apply);

    }


    public static void main(String[] args) {

        System.out.println(new Transformers().map(Arrays.asList(1, 2, 3), (value) -> value + 1)); // [2, 3, 4]

        System.out.println(new Transformers().map(Arrays.asList("egy", "kettő", "három"), String::length)); // [3, 5, 5]

        System.out.println(new Transformers().reduce(Arrays.asList(1, 2, 3), 0, Integer::sum)); // 6
    }

}
