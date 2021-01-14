package collectionslist.collectionslinkedlist;

import java.util.*;

public class Draw {

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less then " + maxNumber + "!");
        }
        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= maxNumber; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        Queue<Integer> numbersQueue = (Queue<Integer>) numbers;

        TreeSet<Integer> winNumbers = new TreeSet<>();
        for (int i = 0; i < drawCount; i++) {
            winNumbers.add(numbersQueue.poll());
        }

        return winNumbers;
    }

    public static void main(String[] args) {
        System.out.println(new Draw().drawNumbers(5, 90));
    }
}
