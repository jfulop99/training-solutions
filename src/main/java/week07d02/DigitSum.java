package week07d02;

public class DigitSum {

    public static int sumOfDigits(int x){
        int sum = 0;
        String number = Integer.toString(x);
        for (char digit:number.toCharArray()) {
            sum += Integer.parseInt(Character.toString(digit));
        }
        return sum;
    }

    public static int sumOfDigits2(int x) {
        int sum = 0;
        while (x > 0) {
            int digit = x % 10;
            sum += digit;
            x = (x - digit) / 10;
        }
        return sum;
    }

    public static int sumOfDigits3(int x) {
        int digit = x % 10;
        if (x == 0) {
            return 0;
        }
        return digit += sumOfDigits3((x - digit) / 10);
    }
}
