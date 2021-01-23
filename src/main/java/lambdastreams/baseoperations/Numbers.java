package lambdastreams.baseoperations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Numbers {

    private List<Integer> list;

    public Numbers(List<Integer> list) {
        this.list = new ArrayList<>(list);
    }

    public Optional<Integer> min() {

        return list.stream().min(Comparator.naturalOrder());

    }
    public int sum() {

        BinaryOperator<Integer> add = (a, b) -> a +b;
        return list.parallelStream().reduce(0, add, add);
    }

    public boolean isAllPositive() {

        return list.stream().allMatch(a -> 0 < a );
    }

    public List<Integer> getDistinctElements() {

        return list.stream().distinct().collect(Collectors.toList());
    }


}
