package statements;

public class StatementMain {
    public static void main(String[] args) {
        int x = 5 + 6 ;
        int y = 11 - x;
        int z = 8;
        boolean b = (x > y);
        boolean c = (b || (z > 5));
        //z++;

        System.out.println("x = : "+ x + "\n\r" + "y = : "+ y + "\n\r" + "z = : "+ z + "\n\r" + "b = : "+ b + "\n\r" + "c = : "+ c + "\n\r" + "z = : "+ ++z + "\n\r") ;

    }
}
