package week08.d05;

public class MathAlgorithms {

    public int greatestCommonDivisor(int a, int b) {
        int greatestCommonDivisor = 0;
        int smallestNumber;
        smallestNumber = a < b ? a : b;

        for (int i = 1; i <= smallestNumber; i++) {
            if ((a % i == 0) && (b % i == 0)) {
                greatestCommonDivisor = i;
            }
        }
        return greatestCommonDivisor;
    }

    public static void main(String[] args) {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        System.out.println(mathAlgorithms.greatestCommonDivisor(1326, 246));
    }
}
