package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song song = new Song();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Performer of your favorite song:");
        song.band = scanner.nextLine();
        System.out.println("Title of your favorite song:");
        song.title = scanner.nextLine();
        System.out.println("Length of your favorite song (sec):");
        song.length = scanner.nextInt();
        scanner.nextLine();

        System.out.println(song.band + " - " + song.title + " (" + song.length + " sec.)");
    }
}
