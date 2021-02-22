package exam03retake01;

public class CdvCheck {

    public boolean check(String cdv) {

        if (cdv.length() != 10) {
            throw new IllegalArgumentException("Length is not equal to 10");
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {

            int number = cdv.charAt(i) - 48;
            if (number > 9) {
                throw new IllegalArgumentException("Invalid character");
            }
            sum = sum + (i + 1) * number;
        }
        int checkSum = cdv.charAt(9) - 48;
        if (checkSum > 9) {
            throw new IllegalArgumentException("Invalid character");
        }
        if (sum % 11 == checkSum) {
            return true;
        }
        return false;

    }

}
