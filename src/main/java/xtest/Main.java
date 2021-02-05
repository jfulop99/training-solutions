package xtest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static String convert(int a, int b) {
        return Integer.toString(a) + Integer.toString(b);
    }

    public static void main(String[] args) {
        B c = new C();

        System.out.println(c instanceof A);

        System.out.println(new Main().convert(5, 6));


        List<User> users = new ArrayList<>(List.of(new User("Alma", 500), new User("Ábra", 500), new User("Béla", 500)));


        users.sort(Comparator.naturalOrder());

        System.out.println(users);

    }

}
