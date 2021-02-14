package jvm;

import java.util.List;
import java.util.Random;

public class SorterMain {

    public static void main(String[] args) {
        while (true) {
            Random random = new Random();
            int size = random.nextInt(500_000);
            System.out.println("Creating and sorting with size " + size);
            List<Integer> list = new Sorter().createListAndSort(size);
        }
    }
}
