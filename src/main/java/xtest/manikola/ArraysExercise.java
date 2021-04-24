package xtest.manikola;

import java.util.Arrays;

public class ArraysExercise {

    public int lastIndexOf(int[] numbers, int number) {
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                index = i;
            }
        }
        return index;
    }

    public int range(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int item : numbers) {
            if (item > max) {
                max = item;
            }
            if (item < min) {
                min = item;
            }
        }
        return max - min + 1;
    }

    public int countInRange(int[] numbers, int min, int max) {
        int result = 0;
        for (int item : numbers) {
            if (item > min && item < max) {
                result++;
            }
        }
        return result;
    }

    public static boolean isSorted(double[] numbers) {
        double prev = Double.MIN_VALUE;
        for (double item : numbers) {
            if (item < prev) {
                return false;
            }
            prev = item;
        }
        return true;
    }

    public int mode(int[] numbers) {
        int[] counters = new int[101];
        for (int item : numbers) {
            if (item < 0 || item > 100) {
                throw new IllegalArgumentException("Invalid number");
            }
            counters[item]++;
        }
        int result = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] > result) {
                result = counters[i];
                index = i;
            }
        }
        return index;
    }

    public double standardDeviation(double[] numbers) {
        double sum = 0.0;
        double sqSum = 0.0;
        for (double item : numbers) {
            sum += item;
            sqSum += Math.pow(item, 2);
        }
        int length = numbers.length;
        double variance = (sqSum - Math.pow(sum, 2) / length) / (length - 1);
        return Math.sqrt(variance);
    }

    public int kthLargest(int[] numbers, int k) {
        Arrays.sort(numbers);
        return numbers[numbers.length - k - 1];
    }

    public double median(int[] numbers) {
        Arrays.sort(numbers);
        int length = numbers.length;
        int halfLength = length / 2;
        if (length % 2 == 0) {
            return (numbers[halfLength] + numbers[halfLength - 1]) / 2.0;

        } else {
            return numbers[halfLength];
        }
    }

    public int minGap(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int minGap = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int gap = arr[i] - arr[i - 1];
            if (gap < minGap) {
                minGap = gap;
            }
        }
        return minGap;
    }

    public double percentEven(int[] arr) {
        int countEven = 0;
        if (arr.length == 0) {
            return 0.0;
        }
        double result = 0.0;
        for (int item : arr) {
            if (item % 2 == 0) {
                countEven++;
            }
        }
        result = (double) countEven / arr.length * 100.0;
        return result;
    }

    public boolean isUnique(int[] numbers) {
        Arrays.sort(numbers);
        int prev = Integer.MAX_VALUE;
        for (int item : numbers) {
            if (prev == item) {
                return false;
            }
            prev = item;
        }
        return true;
    }

    public int priceIsRight(int[] bids, int price) {
        int result = -1;
        int minGap = Integer.MAX_VALUE;
        int gap;
        for (int bid : bids) {
            gap = price - bid;
            if (gap > 1 && gap < minGap) {
                minGap = gap;
                result = bid;
            }
        }
        return result;
    }

    public int longestSortedSequence(int[] numbers) {
        int counter = 0;
        int prevCounter = 0;
        int prevNumber = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number >= prevNumber) {
                counter++;
            } else {
                if (counter > prevCounter) {
                    prevCounter = counter;
                }
                counter = 1;
            }
            prevNumber = number;
        }
        if (counter > prevCounter) {
            prevCounter = counter;
        }
        return prevCounter;
    }

    public static boolean contains(int[] a1, int[] a2) {
        int counter = 0;
        boolean in = false;
        for (int item : a1) {
            if (in) {
                if (item == a2[counter]) {
                    counter++;
                    if (counter == a2.length) {
                        return true;
                    }
                } else {
                    in = !in;
                    counter = 0;
                }
            } else {
                if (item == a2[counter]) {
                    in = !in;
                    counter++;
                }
            }
        }
        return false;
    }

    public int[] collapse(int[] a1) {
        int[] result = new int[a1.length / 2 + a1.length % 2];
        int counter = 0;
        for (int i = 0; i < a1.length; i += 2) {
            int next = i + 1;
            if (next != a1.length) {
                result[counter] = a1[i] + a1[next];
                counter++;
            } else {
                result[counter] = a1[i];
            }
        }
        return result;
    }

    public int[] append(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        for (int i = 0; i < result.length; i++) {
            if (i < a1.length) {
                result[i] = a1[i];
            } else {
                result[i] = a2[i - a1.length];
            }
        }
        return result;
    }

    public static int[] vowelCount(String content) {
        int[] result = new int[5];
        for (char item : content.toCharArray()) {
            if (item == 'a') {
                result[0]++;
            }
            if (item == 'e') {
                result[1]++;
            }
            if (item == 'i') {
                result[2]++;
            }
            if (item == 'o') {
                result[3]++;
            }
            if (item == 'u') {
                result[4]++;
            }
        }
        return result;
    }

    public int[] evenBeforeOdd(int[] input) {
        int[] output = new int[input.length];
        int evenPos = 0;
        int oddPos = input.length - 1;
        for (int item : input) {
            if (item % 2 == 0) {
                output[evenPos++] = item;
            } else {
                output[oddPos--] = item;
            }
        }
        return output;
    }
}
