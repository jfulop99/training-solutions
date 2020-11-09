package typeconversion.whichtype;

public class WhichTypeMain {
    public static void main(String[] args) {
        System.out.println(WhichType.whichType(Long.toString(Long.MAX_VALUE - 2)));
        System.out.println(WhichType.whichType(Long.toString((long)Integer.MAX_VALUE - 2)));
        System.out.println(WhichType.whichType(Long.toString((long)Short.MAX_VALUE - 2)));
        System.out.println(WhichType.whichType(Long.toString((long)Byte.MAX_VALUE - 2)));
        System.out.println(WhichType.whichType(Long.toString(0)));
        System.out.println(WhichType.whichType("123"));
    }
}
