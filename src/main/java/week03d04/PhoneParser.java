package week03d04;

public class PhoneParser {

    public Phone parsePhone(String phonenumber){
        Phone phone;
        int dashPosition;
        dashPosition = phonenumber.indexOf("-");
        phone = new Phone(phonenumber.substring(0,dashPosition), phonenumber.substring(dashPosition+1));
        return phone;
    }
}
