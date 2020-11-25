package week05d03;

import java.util.List;

public class UserValidator {


    public void validate(List<User> users) {
        for (User user:users) {
            if (user.getName().isBlank()){
                throw new IllegalArgumentException("Username is empty");
            }
            int age = user.getAge();
            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("Age is out of range");
            }
        }
    }
}
