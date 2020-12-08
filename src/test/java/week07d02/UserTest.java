package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void ofMethodTest() {
        User x = User.of("User1", "John", "Doe");
        assertEquals("User1", x.getUserName());
        assertEquals("John Doe", x.getFullName());
    }

}