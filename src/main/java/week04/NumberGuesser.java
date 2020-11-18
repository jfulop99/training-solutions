package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {

        Random rnd = new Random();

        System.out.println("Kitaláltam egy számot!");
        Scanner scanner = new Scanner(System.in);
        int number = rnd.nextInt(101
        );
        int i = 0;
        int guess = 0;
        boolean run = true;

        do {
            System.out.println(i+1 + ". tipp? ");
            guess = scanner.nextInt();
            if (number == guess) {
                System.out.println("Nyertél!");
                run = false;
            }
            else {
                System.out.println("A kitalált szám " + (number > guess ? "nagyobb!" : "kisebb!"));
                i++;
            }
            if (i == 7){
                run = false;
                System.out.println("Vesztettél!");
            }
        }while (run);
    }
}
