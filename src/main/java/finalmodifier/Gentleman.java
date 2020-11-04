package finalmodifier;

public class Gentleman {
    final static String MESSAGE_PREFIX = "Welcome ";
    public String sayHello( String name) {
        return MESSAGE_PREFIX + name;
    }

    public static void main(String[] args) {
        System.out.println(new Gentleman().sayHello("John Doe"));
    }
}
