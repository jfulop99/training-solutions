package introcontrol;

import java.awt.event.WindowFocusListener;
import java.util.Scanner;

public class IntroControlMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntroControl introControl = new IntroControl();
        int temp;

        while (true) {
            System.out.println("Írj be egy egész számot (0 = kilépés)!");
            temp = introControl.substractTenIfGreaterThanTen(scanner.nextInt());
            if (temp == 0){
                break;
            }
            else {
                System.out.println(temp);
            }
        }
        scanner.nextLine();

        String stringTemp;
        while (true) {
            System.out.println("Írj be egy egész számot (0 = kilépés)!");
            stringTemp = introControl.describeNumber(scanner.nextInt());
            if (stringTemp.equals("zero")){
                System.out.println(stringTemp);
                break;
            }
            else {
                System.out.println(stringTemp);
            }
        }
        scanner.nextLine();

        while (true) {
            System.out.println("Írj be egy nevet ! (Joe = vége)");
            stringTemp = introControl.greetingToJoe(scanner.nextLine());
            if (stringTemp.length() != 0) {
                System.out.println(stringTemp);
                break;
            }
        }

        while (true) {
            System.out.println("Írj be az eladások összegét (0 = kilépés)!");
            temp = scanner.nextInt();
            if (temp == 0){
                break;
            }
            else {
                System.out.println( introControl.calculateBonus(temp));
            }
        }
        scanner.nextLine();

        int prev;
        int next;
        while (true) {

            System.out.println("Add meg az előző és mostani mérőállást ! (ha mindkettő 0 kilép)");
            prev = scanner.nextInt();
            next = scanner.nextInt();
            if ((next == 0) && (prev == 0)) {
                break;
            }
            else {
                System.out.println(introControl.calculateConsumption(prev, next));
            }
        }
        scanner.nextLine();

        while (true) {
            System.out.println("Add meg a max értéket ! ( 0 kilép)");
            temp = scanner.nextInt();
            if (temp == 0) {
                break;
            }
            else {
                introControl.printNumbers(temp);
            }
        }
        scanner.nextLine();

        while (true) {

            System.out.println("Add meg az kezdő és végértéket ! (ha mindkettő 0 kilép)");
            prev = scanner.nextInt();
            next = scanner.nextInt();
            if ((next == 0) && (prev == 0)) {
                break;
            }
            else {
                introControl.printNumbersBetween(prev, next);
            }
        }
        scanner.nextLine();

        while (true) {

            System.out.println("Add meg az kezdő és végértéket ! (ha mindkettő 0 kilép)");
            prev = scanner.nextInt();
            next = scanner.nextInt();
            if ((next == 0) && (prev == 0)) {
                break;
            }
            else {
                introControl.printNumbersBetweenAnyDirection(prev, next);
            }
        }
        scanner.nextLine();

        while (true) {
            System.out.println("Add meg a max értéket ! ( 0 kilép)");
            temp = scanner.nextInt();
            if (temp == 0) {
                break;
            }
            else {
                introControl.printOddNumbers(temp);
            }
        }
        scanner.nextLine();
    }
}
