package xtest;

import week08.d05.MathAlgorithms;

public class Main {
    public static String convert(int a, int b) {
        return Integer.toString(a) + Integer.toString(b);
    }

    public static void main(String[] args) {
        B c = new C();

        System.out.println(c instanceof A);

        System.out.println(new Main().convert(5,6));
    }

}
