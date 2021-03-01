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

    public boolean ssnChecker(String ssn) {
        int sum = 0;
        int multiplier = 3;
        for (int i = 0; i < ssn.length() - 1; i++) {
            int number = ssn.charAt(i) - '0';
            sum = sum + number * multiplier;
            multiplier = multiplier == 3 ? 7 : 3;
        }
        sum = sum % 10;

        if (sum == ssn.charAt(8) - '0') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CdvCheck cdvCheck = new CdvCheck();

        System.out.println(cdvCheck.check("3943141829"));
        System.out.println((cdvCheck.ssnChecker("519639869")));

    }

}
