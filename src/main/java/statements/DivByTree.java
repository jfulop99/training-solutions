package statements;

import java.util.Scanner;

public class DivByTree {
    public static void main(String[] args) {
        int i;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Írj be egy pozitív egész számot (0 = vége)!");
        do {
            i = scanner.nextInt();
            if (i > 0)
                System.out.println(i + (i % 3 ==0 ? " osztható " : " nem osztható ") + "hárommal!");
        }while (i > 0);
    }
}
