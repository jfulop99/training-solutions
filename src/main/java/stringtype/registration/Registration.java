package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        UserValidator valid = new UserValidator();
        Scanner scanner = new Scanner(System.in);
        String username;
        String password1;
        String password2;
        String email;

        System.out.println("Username:");
        username = scanner.nextLine();
        System.out.println("E-mail:");
        email = scanner.nextLine();
        System.out.println("Password:");
        password1 = scanner.nextLine();
        System.out.println("Password once more:");
        password2 = scanner.nextLine();
        scanner.close();

        System.out.println("Username: \t" + username + (valid.isValidUsername(username) ? " \tVALID " : " \tINVALID"));
        System.out.println("E-mail  : \t" + email + (valid.isValidEmail(email) ? " \tVALID " : " \tINVALID"));
        System.out.println("Password: \t" + password1 + (valid.isValidPassword(password1, password2) ? " \tVALID " : " \tINVALID"));
    }
}
