package week03;

import javax.swing.plaf.basic.BasicListUI;

public class PhoneParser {

    public Phone parsePhone(String phonenumber){
        Phone phone;
        int dashPosition;
        dashPosition = phonenumber.indexOf("-");
        phone = new Phone(phonenumber.substring(0,dashPosition), phonenumber.substring(dashPosition+1));
        return phone;
    }

    public static void main(String[] args) {
        PhoneParser phoneParser = new PhoneParser();
        System.out.println(phoneParser.parsePhone("32-12345678"));
    }
}
