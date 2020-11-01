package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {

        int hour = 12;
        int min = 30;
        int sec = 30;



        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg az első időpontot!");
        System.out.println("Óra ?");
        hour = scanner.nextInt();
        System.out.println("Perc ?");
        min = scanner.nextInt();
        System.out.println("Másodperc ?");
        sec = scanner.nextInt();

        Time firstTime = new Time(hour, min, sec);


        System.out.println("Add meg a második időpontot!");
        System.out.println("Óra ?");
        hour = scanner.nextInt();
        System.out.println("Perc ?");
        min = scanner.nextInt();
        System.out.println("Másodperc ?");
        sec = scanner.nextInt();

        Time secondTime = new Time(hour, min, sec);

        System.out.println("Az első időpont \t" + firstTime.toString() + " \t=\t" + firstTime.getInMinutes() + " perc");
        System.out.println("A második időpont \t" + secondTime.toString() + " \t=\t" + secondTime.getInSeconds() + " másodperc");
        System.out.println("Az első korábbi, mint a második: \t" + firstTime.earlierThan(secondTime));

    }


}
