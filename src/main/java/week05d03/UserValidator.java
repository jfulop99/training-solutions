package week05d03;

import java.util.List;

public class UserValidator {


    public void validate(List<User> users) {
        if (users == null) {
            throw new IllegalArgumentException("Users is null");
        }
        for (User user:users) {
            String name = user.getName();
            if (name == null || name.isBlank()){
                throw new IllegalArgumentException("Username is empty or null");
            }
            int age = user.getAge();
            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("Age is out of range");
            }
        }
    }
}
