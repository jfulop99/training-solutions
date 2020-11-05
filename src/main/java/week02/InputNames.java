package week02;

import java.util.Scanner;

public class InputNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tomb[] = new String[5];

        for (int i = 0; i < 5; i++){
            System.out.println("Kérem az " + (i+1) + ". nevet:");
            tomb[i] = scanner.nextLine();
        }
        int i = 1;
        for (String elem: tomb) {
            System.out.println(i + ".elem: " + elem);
            i++;
        }
    }
}
