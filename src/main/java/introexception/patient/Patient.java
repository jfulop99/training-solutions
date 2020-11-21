package introexception.patient;

public class Patient {
    String name;
    String socialSecurityNumber;
    int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        SsnValidator ssnValidator = new SsnValidator();
        if (name.length() > 0){
            this.name = name;
        }
        else {
            throw new IllegalArgumentException();
        }

        try {
            ssnValidator.isValidSsn(socialSecurityNumber);
        }catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(iae);
        }
        this.socialSecurityNumber = socialSecurityNumber;
        //        if (ssnValidator.isValidSsn(socialSecurityNumber)){
//            this.socialSecurityNumber = socialSecurityNumber;
//        }
//        else {
//            throw new IllegalArgumentException();
//        }

        if (yearOfBirth >= 1900){
            this.yearOfBirth = yearOfBirth;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
