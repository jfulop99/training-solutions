package collectionslist.collectionslinkedlist;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Draw {

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less then " + maxNumber + "!");
        }
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= maxNumber; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
//        Queue<Integer> numbersQueue = (Queue<Integer>) numbers;

//        ((LinkedList<Integer>) numbers).poll()
        TreeSet<Integer> winNumbers = new TreeSet<>();
        for (int i = 0; i < drawCount; i++) {
            winNumbers.add(numbers.poll());
        }

        return winNumbers;
    }

    public static void main(String[] args) {
        System.out.println(new Draw().drawNumbers(5, 90));
    }
}
