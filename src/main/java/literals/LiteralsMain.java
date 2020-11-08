package literals;

public class LiteralsMain {
    public static void main(String[] args) {

// Összefűzés
        String a;

        a = Integer.toString(1) + Integer.toString(2);
        System.out.println(a);

        a = "1" + "2";
        System.out.println(a);


        // Osztás
        double quotient;

        quotient = 3/4;

        System.out.println(quotient);
        // Az eredmény 0.0, mert a két int literál hányadosa is int, amit egy double változóba tárolunk.

        quotient = 3D/4D;
        System.out.println(quotient);
        quotient = 3.0/4.0;
        System.out.println(quotient);

        // Nagy szám

        long big = 3_244_444_444L;

        String s = "árvíztűrőtükörfúrógép";

        System.out.println(s);

        String word = "title".toUpperCase();
        System.out.println(word);

        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-2));

    }
}
