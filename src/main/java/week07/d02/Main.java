package week07.d02;

public class Main {

    public static void main(String[] args) {
        User x = User.of("User1", "John", "Doe");
        System.out.println(x.getFullName() + " " + x.getUserName());
    }
}
