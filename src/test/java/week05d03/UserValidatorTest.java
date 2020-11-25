package week05d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    private List<User> users1 = Arrays.asList(new User("John Doe", 35), new User("Jane Doe", 46), new User("Jack Doe", 99));
    private List<User> users2 = Arrays.asList(new User("John Doe", 35), new User("", 46), new User("Jack Doe", 99));
    private List<User> users3 = Arrays.asList(new User("John Doe", 35), new User("Jane Doe", 46), new User("Jack Doe", 130));


    @Test
    public void testWithValidList() {

        UserValidator userValidator = new UserValidator();
        userValidator.validate(users1);

    }

    @Test
    void testWithInvalidList() throws IllegalArgumentException {

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(users2));
        assertEquals("Username is empty", ex1.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(users3));
        assertEquals("Age is out of range", ex2.getMessage());
    }
}