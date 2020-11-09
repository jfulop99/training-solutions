package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++){
            System.out.println(i + " " + Operators.isEven(i));
        }
        System.out.println(16);
        System.out.println(16<<1);
        System.out.println(16>>1);
        System.out.println(13);
        System.out.println(13<<1);
        System.out.println(13>>1);

        System.out.println(Operators.multiplyByPowerOfTwo(16, 3));

        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        //int j = Integer.parseInt(s, 2);
        int j = Long.valueOf(s, 2).intValue(); // túlcsordulás miatt
        System.out.println(j);

        System.out.println(0333); // oktális 333=3*8*8+3*8+3*1=219 decimalisan

    }
}
