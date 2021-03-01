package vaccine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Citizen {

    public static final int MIN_AGE = 10;
    public static final int MAX_AGE = 150;
    private long id;

    private final String fullName;

    private final String zipNumber;

    private final int age;

    private final String emailAddress;

    private final String tajNumber;

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern NINE_DIGIT = Pattern.compile("^\\d{9}$");

    private static final Pattern FOUR_DIGIT = Pattern.compile("^\\d{4}$");


    public Citizen(String fullName, String zipNumber, int age, String emailAddress, String tajNumber) {
        validator(fullName, zipNumber, age, emailAddress, tajNumber);
        this.fullName = fullName;
        this.zipNumber = zipNumber;
        this.age = age;
        this.emailAddress = emailAddress;
        this.tajNumber = tajNumber;
    }


    public Citizen(long id, String fullName, String zipNumber, int age, String emailAddress, String tajNumber) {
        this(fullName, zipNumber, age, emailAddress, tajNumber);
        this.id = id;
    }

    private void validator(String fullName, String zipNumber, int age, String emailAddress, String tajNumber) {
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new IllegalArgumentException("Must be between " + MIN_AGE + " - " + MAX_AGE);
        }
        if (emailAddress == null || !isEmailValid(emailAddress)) {
            throw new IllegalArgumentException("E-mail address is invalid");
        }
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Fullname cannot be empty");
        }
        if (tajNumber == null || !isValidTajNumber(tajNumber)) {
            throw new IllegalArgumentException("TAJ number must be valid");
        }
        if (zipNumber == null || !FOUR_DIGIT.matcher(zipNumber).find()) {
            throw new IllegalArgumentException("Invalid postal code");
        }

    }

    private boolean isValidTajNumber(String tajNumber) {
        Matcher matcher = NINE_DIGIT.matcher(tajNumber);
        if (!matcher.find()) {
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
        if (sum % 10 == (tajNumber.charAt(8) - '0')) {
            return true;
        }
        return false;
    }

    private boolean isEmailValid(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }


    public String getFullName() {
        return fullName;
    }

    public String getZipNumber() {
        return zipNumber;
    }

    public int getAge() {
        return age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTajNumber() {
        return tajNumber;
    }

    public long getId() {
        return id;
    }
}
