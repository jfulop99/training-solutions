package introcontrol;

import java.util.Scanner;

public class UserMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int select;

        System.out.println("1. Felhasználók listázása\n\r" +
                           "2. Felhasználó felvétele\n\r" +
                           "Többi: Kilépés");
        select = scanner.nextInt();
        if (select == 1) {
            System.out.println("Felhasználók listázása");
        }
        if (select == 2) {
            System.out.println("Felhasználó felvétele");
        }
    }
}
