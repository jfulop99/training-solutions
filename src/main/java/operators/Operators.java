package operators;

public class Operators {
    public static boolean isEven(int n){
        return n % 2 == 0 ? true : false;
    }
    public static int multiplyByPowerOfTwo(int number, int powerOfTwo){
        return number << powerOfTwo;
    }
}
