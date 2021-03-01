package vaccine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VaccineValidator {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern NINE_DIGIT = Pattern.compile("^\\d{9}$");

    private static final Pattern FOUR_DIGIT = Pattern.compile("^\\d{4}$");

    private static final int MIN_AGE = 10;

    private static final int MAX_AGE = 150;

    private Map<String, List<PostalCode>> postalCodes;

    public VaccineValidator(Map<String, List<PostalCode>> postalCodes) {
        this.postalCodes = postalCodes;
    }

    public boolean isValidTajNumber(String tajNumber) {
        if (tajNumber == null || !NINE_DIGIT.matcher(tajNumber).find()) {
            return false;
        }
        int sum = 0;
        int multiplier = 3;
        for (int i = 0; i < 8; i++) {
            sum += (tajNumber.charAt(i) - '0') * multiplier;
            if (multiplier == 3) {
                multiplier = 7;
            } else {
                multiplier = 3;
            }
        }
        return sum % 10 == (tajNumber.charAt(8) - '0');
    }

    public boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public boolean isValidAge(String strAge) {
        int age;
        try {
            age = Integer.parseInt(strAge);
        } catch (NumberFormatException e) {
            return false;
        }
        return (age > MIN_AGE && age < MAX_AGE);
    }

    public List<PostalCode> getPostalCode(String zipNumber) {
        if (zipNumber == null || !FOUR_DIGIT.matcher(zipNumber).find()) {
            return new ArrayList<>();
        }
        List<PostalCode> result = postalCodes.get(zipNumber);
        if (result == null) {
            return new ArrayList<>();
        }
        return result;
    }

    public boolean isEmpty(String str) {
        return (str == null || str.isBlank());
    }

}
