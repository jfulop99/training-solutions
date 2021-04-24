package xtest.manikola;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArraysExerciseTest {

    private ArraysExercise arraysExercise = new ArraysExercise();

    @Test
    void lastIndexOf() {
        int[] numbers = new int[]{74, 85, 102, 99, 101, 85, 56};
        assertEquals(5, arraysExercise.lastIndexOf(numbers, 85));
    }

    @Test
    void lastIndexOfNotFound() {
        int[] numbers = new int[]{74, 85, 102, 99, 101, 85, 56};
        assertEquals(-1, arraysExercise.lastIndexOf(numbers, 100));
    }

    @Test
    void range() {
        assertEquals(7, arraysExercise.range(new int[]{8, 3, 5, 7, 2, 4}));
        assertEquals(24, arraysExercise.range(new int[]{15, 22, 8, 19, 31}));
        assertEquals(10000030, arraysExercise.range(new int[]{3, 10000000, 5, -29, 4}));
        assertEquals(61, arraysExercise.range(new int[]{-25, -50, 10}));
        assertEquals(96, arraysExercise.range(new int[]{100, 5}));
        assertEquals(1, arraysExercise.range(new int[]{32}));
    }

    @Test
    void countInRange() {

        assertEquals(1, arraysExercise.countInRange(new int[]{1, 2, 3, 4, 5, 6}, 2, 4));
        assertEquals(3, arraysExercise.countInRange(new int[]{17, 1, 22, 14, 36, 7, -43, 5}, 4, 17));
        assertEquals(2, arraysExercise.countInRange(new int[]{-11, 1, 5, 21}, 0, 17));

    }

    @Test
    void isSorted() {
        assertEquals(false, ArraysExercise.isSorted(new double[]{16.1, 12.3, 22.2, 14.1}));
        assertEquals(false, ArraysExercise.isSorted(new double[]{22.2, 16.1, 14.3, 12.1}));
        assertEquals(true, ArraysExercise.isSorted(new double[]{1.5, 4.3, 7.0, 19.5, 25.1, 46.2}));
        assertEquals(true, ArraysExercise.isSorted(new double[]{1.5, 1.5, 4.3, 7.0, 19.5, 25.1, 46.2}));
        assertEquals(true, ArraysExercise.isSorted(new double[]{1.5}));
    }

    @Test
    void mode() {
        assertEquals(15, arraysExercise.mode(new int[]{27, 15, 15, 11, 18}));
        assertEquals(27, arraysExercise.mode(new int[]{27, 27, 27, 27}));
        assertEquals(27, arraysExercise.mode(new int[]{27}));
    }

    @Test
    void modeException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> arraysExercise.mode(new int[]{-1, 2, 2, 3, 4, 5}));
        assertEquals("Invalid number", ex.getMessage());
        ex = assertThrows(IllegalArgumentException.class, () -> arraysExercise.mode(new int[]{2, 2, 125, 3, 4, 5,}));
        assertEquals("Invalid number", ex.getMessage());
    }

    @Test
    void standardDeviation() {
        assertEquals(11.237, arraysExercise.standardDeviation(new double[]{1, -2, 4, -4, 9, -6, 16, -8, 25, -10}), 0.005);
        assertEquals(7.905, arraysExercise.standardDeviation(new double[]{5, 10, 15, 20, 25}), 0.005);
        assertEquals(0.0, arraysExercise.standardDeviation(new double[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}), 0.005);
        assertEquals(0.774, arraysExercise.standardDeviation(new double[]{2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4}), 0.005);
        assertEquals(1.414, arraysExercise.standardDeviation(new double[]{1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5}), 0.005);
    }

    @Test
    void kthLargest() {
        assertEquals(99, arraysExercise.kthLargest(new int[]{74, 85, 102, 99, 101, 56, 84}, 2));
        assertEquals(8, arraysExercise.kthLargest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 1));
        assertEquals(7, arraysExercise.kthLargest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2));
        assertEquals(9, arraysExercise.kthLargest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0));
    }

    @Test
    void median() {
        assertEquals(30, arraysExercise.median(new int[]{10, 20, 30, 40, 50}));
        assertEquals(5, arraysExercise.median(new int[]{5, 2, 4, 17, 55, 4, 3, 26, 18, 2, 17}));
        assertEquals(25, arraysExercise.median(new int[]{42, 37, 1, 97, 1, 2, 7, 42, 3, 25, 89, 15, 10, 29, 27}));
        assertEquals(25, arraysExercise.median(new int[]{10, 20, 30, 40}));
        assertEquals(2.5, arraysExercise.median(new int[]{1, 4, 2, 4, 2, 3, 5, 3, 1, 1}));
    }

    @Test
    void minGap() {
        assertEquals(1, arraysExercise.minGap(new int[]{1, 3, 6, 7, 12}));
        assertEquals(-7, arraysExercise.minGap(new int[]{3, 5, 11, 4, 8}));
        assertEquals(0, arraysExercise.minGap(new int[]{}));
        assertEquals(0, arraysExercise.minGap(new int[]{8}));
    }

    @Test
    void percentEven() {
        assertEquals(40.0, arraysExercise.percentEven(new int[]{6, 2, 9, 11, 3}));
        assertEquals(0.0, arraysExercise.percentEven(new int[]{}));
        assertEquals(0.0, arraysExercise.percentEven(new int[]{9, 11, 3}));
        assertEquals(12.5, arraysExercise.percentEven(new int[]{2, 9, 11, 3, 1, 1, 1, 1}));
    }

    @Test
    void isUnique() {
        assertEquals(true, arraysExercise.isUnique(new int[]{3, 8, 12, 2, 9, 17, 43, -8, 46, 203, 14, 97, 10, 4}));
        assertEquals(false, arraysExercise.isUnique(new int[]{4, 7, 2, 3, 9, 12, -47, -19, 308, 3, 74}));
        assertEquals(true, arraysExercise.isUnique(new int[]{}));
        assertEquals(true, arraysExercise.isUnique(new int[]{74}));
    }

    @Test
    void priceIsRight() {
        assertEquals(1, arraysExercise.priceIsRight(new int[]{900, 885, 989, 1}, 800));
        assertEquals(250, arraysExercise.priceIsRight(new int[]{200, 300, 250, 999, 40}, 280));
        assertEquals(-1, arraysExercise.priceIsRight(new int[]{200}, 120));
        assertEquals(-1, arraysExercise.priceIsRight(new int[]{500, 300, 241, 99, 501}, 50));
    }

    @Test
    void longestSortedSequence() {
        assertEquals(4, arraysExercise.longestSortedSequence(new int[]{3, 8, 10, 1, 9, 14, -3, 0, 14, 207, 56, 98, 12}));
        assertEquals(5, arraysExercise.longestSortedSequence(new int[]{17, 42, 3, 5, 5, 5, 8, 2, 4, 6, 1, 19}));
        assertEquals(0, arraysExercise.longestSortedSequence(new int[]{}));
    }

    @Test
    void contains() {
        int[] a1 = new int[]{1, 6, 2, 1, 4, 1, 2, 1, 8};
        int[] a2 = new int[]{1, 2, 1};
        int[] a3 = new int[]{2, 1, 2};
        int[] a4 = new int[]{2, 1, 2};

        assertEquals(true, ArraysExercise.contains(a1, a2));
        assertEquals(false, ArraysExercise.contains(a2, a1));
        assertEquals(false, ArraysExercise.contains(a1, a3));
        assertEquals(true, ArraysExercise.contains(a3, a4));
    }

    @Test
    void collapse() {
        int[] a1 = new int[]{7, 2, 8, 9, 4, 13, 7, 1, 9, 10};
        int[] a2 = new int[]{9, 17, 17, 8, 19};

        int[] b1 = new int[]{1, 2, 3, 4, 5};
        int[] b2 = new int[]{3, 7, 5};

        int[] d1 = new int[]{2, 2, 2, 2};
        int[] d2 = new int[]{4, 4};

        assertEquals(true, Arrays.equals(a2, arraysExercise.collapse(a1)));
        assertEquals(true, Arrays.equals(b2, arraysExercise.collapse(b1)));
        assertEquals(true, Arrays.equals(d2, arraysExercise.collapse(d1)));
    }

    @Test
    void append() {
        int[] a1 = new int[]{2, 4, 6};
        int[] a2 = new int[]{1, 2, 3, 4, 5};

        int[] result1 = new int[]{2, 4, 6, 1, 2, 3, 4, 5};
        int[] result2 = new int[]{1, 2, 3, 4, 5, 2, 4, 6};

        assertEquals(true, Arrays.equals(result1, arraysExercise.append(a1, a2)));
        assertEquals(true, Arrays.equals(result2, arraysExercise.append(a2, a1)));
    }

    @Test
    void vowelCount() {
        int[] r = new int[]{1, 3, 3, 1, 0};

        assertEquals(true, Arrays.equals(r, ArraysExercise.vowelCount("i think, therefore i am")));
    }

    @Test
    void evenBeforeOdd() {
        int[] result = arraysExercise.evenBeforeOdd(new int[]{5, 4, 2, 11, 9, 10, 4, 7, 3});


        assertEquals(true, result[3] % 2 == 0);
        assertEquals(true, result[2] % 2 == 0);
        assertEquals(true, result[1] % 2 == 0);
        assertEquals(true, result[0] % 2 == 0);
    }
}