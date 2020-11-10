package introjunit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GentlemanTest {
    @Test
    public void testCreate() {
        Gentleman gentleman = new Gentleman();

        String greeting = gentleman.sayHello("John Doe");

        assertThat(greeting, equalTo("Hello John Doe"));

    }
    @Test
    public void testCreate2() {
        Gentleman gentleman2 = new Gentleman();

        String greeting = gentleman2.sayHello();

        assertThat(greeting, equalTo("Hello Anonymus"));

    }
}
