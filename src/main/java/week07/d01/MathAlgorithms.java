package week07.d01;

public class MathAlgorithms {
    public static boolean isPrime(int x) {
        if (x < 2) {
            throw new IllegalArgumentException("Nem megfelelő paraméter! x=" + x);
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int counter = 1;
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (isPrime(i)) {
                System.out.println(counter + " - " + i);
                counter++;
            }
        }
    }
}
