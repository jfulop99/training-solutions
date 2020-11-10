package introjunit;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemanTest {
    @Test
    void testCreate() {
        //Given
        Gentleman gentleman = new Gentleman();
        //When
        String greeting = gentleman.sayHello("John Doe");
        //Then
        assertEquals("Hello John Doe", greeting);

    }
    @Test
    public void testCreate2() {
        Gentleman gentleman2 = new Gentleman();

        String greeting = gentleman2.sayHello();

        assertEquals("Hello Anonymus", greeting);
        // assertThat(greeting, equalTo("Hello Anonymus")); //  junit4

    }
}
