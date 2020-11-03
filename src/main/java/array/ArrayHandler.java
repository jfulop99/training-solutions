package array;

import javax.sound.midi.Soundbank;

public class ArrayHandler {
    boolean contains(int[] source, int itemToFind) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == itemToFind) {
                return true;
            }
        }
        return false;
    }

    int find(int[] source, int itemToFind) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == itemToFind) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayHandler arrayHandler = new ArrayHandler();

        int [] testArray = new int[]{1, 5, 7, 11, 25};

        System.out.println("Tartalmazza:");
        System.out.println(arrayHandler.contains(testArray, 33));
        System.out.println(arrayHandler.contains(testArray, 7));

        System.out.println("Keresés:");
        System.out.println(arrayHandler.find(testArray, 11));
        System.out.println(arrayHandler.find(testArray, 11));
    }
}
