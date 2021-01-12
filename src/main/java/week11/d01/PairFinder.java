package week11.d01;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PairFinder {


    public int findPairs(int[] arr) {
        int numberOfPairs = 0;

        List<Integer> array = new ArrayList<>();
        for (Integer t:arr) {
            array.add(t);
        }
        Collections.sort(array);
        Integer prevNumber = null;
        for (Integer item:array) {
            if (prevNumber != null) {
                if (prevNumber.equals(item)) {
                    numberOfPairs++;
                    prevNumber = null;
                }
                else {
                    prevNumber = item;
                }
            }
            else {
                prevNumber = item;
            }
        }

        return numberOfPairs;
    }

//    Órai megoldás
    public int findPairs2(int[] arr) {
        int numberOfPairs = 0;

        List<Integer> arrayItems = new ArrayList<>();
        for (Integer item:arr) {
            if (arrayItems.contains(item)) {
                numberOfPairs++;
                arrayItems.remove(item);
            }
            else {
                arrayItems.add(item);
            }
        }

        return numberOfPairs;
    }



    public static void main(String[] args) {

        PairFinder pairFinder = new PairFinder();
        System.out.println(pairFinder.findPairs(new int[]{7, 1, 5, 7, 3, 3, 9, 7, 6, 7}));
        System.out.println(pairFinder.findPairs2(new int[]{7, 1, 5, 7, 3, 3, 9, 7, 6, 7}));

    }
}
